package com.library.rest.api.user;

import com.library.rest.api.request.LoginRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author gdimitrova
 */
@Path("/user")
@Consumes("application/json")
@Produces("application/json")
public interface UserRestService {

    @POST
    @Path("/login")
    public Response login(LoginRequest request);

    @GET
    @Path("/logout/{sessionId}")
    public Response logout(String sessionId);
}
