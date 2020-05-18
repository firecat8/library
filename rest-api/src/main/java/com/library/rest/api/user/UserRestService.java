package com.library.rest.api.user;

import com.library.rest.api.request.AddUserRequest;
import javax.ws.rs.Consumes;
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
    @Path("/addUser")
    public Response addUser(AddUserRequest request);
}
