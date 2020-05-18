package com.library.rest.api.authentication;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author gdimitrova
 */
@Path("/authentication")
@Consumes("application/json")
@Produces("application/json")
public interface AuthenticationRestService {

    @GET
    @Path("/login/{username}/{password}")
    public Response login(String username, String password);

    @GET
    @Path("/logout/{sessionId}")
    public Response logout(String sessionId);
}
