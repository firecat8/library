package com.library.bl.rest.impl;

import java.io.IOException;
import java.util.Base64;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author gdimitrova
 */
@Provider
public class SecurityFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String authHeader = requestContext.getHeaderString("Authorization");
        if (authHeader == null || !authHeader.startsWith("Basic")) {
            requestContext.abortWith(Response.status(401).header("WWW-Authenticate", "Basic").build());
            return;
        }

        String[] tokens = (new String(Base64.getDecoder().decode(authHeader.split(" ")[1]), "UTF-8")).split(":");
        final String username = tokens[0];
        final String password = tokens[1];

        if (username.equals("daniel") && password.equals("123")) {
            // all good
        } else {
            requestContext.abortWith(Response.status(401).build());
            return;
        }
    }

}
