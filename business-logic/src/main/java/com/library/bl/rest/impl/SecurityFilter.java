package com.library.bl.rest.impl;

import com.library.dao.DaoRegistry;
import com.library.dao.DaoRegistryFactory;
import com.library.domain.user.User;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author gdimitrova
 */
@Provider
public class SecurityFilter implements ContainerRequestFilter {

    @Context
    private ResourceInfo resourceInfo;

    private final DaoRegistryFactory factory;

    private static final String AUTHORIZATION_PROPERTY = "Authorization";

    private static final String AUTHENTICATION_SCHEME = "Basic";

    public SecurityFilter(DaoRegistryFactory factory) {
        this.factory = factory;
    }

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        Method method = resourceInfo.getResourceMethod();

        if (method.isAnnotationPresent(PermitAll.class)) {
            return;
        }

        if (method.isAnnotationPresent(DenyAll.class)) {
            requestContext.abortWith(Response.status(Response.Status.FORBIDDEN)
                    .entity("Access blocked for all users !!").build());
            return;
        }

        final MultivaluedMap<String, String> headers = requestContext.getHeaders();

        final List<String> authorization = headers.get(AUTHORIZATION_PROPERTY);

        if (authorization == null || authorization.isEmpty()) {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                    .entity("You cannot access this resource").build());
            return;
        }
        final String encodedUserPassword = authorization.get(0).replaceFirst(AUTHENTICATION_SCHEME + " ", "");
        String usernameAndPassword = new String(Base64.getMimeDecoder().decode(encodedUserPassword.getBytes(StandardCharsets.UTF_8)));;

        final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
        final String username = tokenizer.nextToken();
        final String password = tokenizer.nextToken();

        if (method.isAnnotationPresent(RolesAllowed.class)) {
            RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
            Set<String> rolesSet = new HashSet<>(Arrays.asList(rolesAnnotation.value()));
            User loaded;
            try (DaoRegistry daoRegistry = factory.makeDaoRegistry()) {
                daoRegistry.beginTransaction();
                loaded = daoRegistry.getUserDao().load(username, password);
                daoRegistry.commitTransaction();
            } catch (Exception e) {
                requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                        .entity(e.getMessage()).build());
                return;
            }
            if (!rolesSet.contains(loaded.getRole().name())) {
                requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                        .entity("You cannot access this resource").build());
            }
        }
    }

}
