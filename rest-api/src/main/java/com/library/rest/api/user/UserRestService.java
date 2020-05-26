package com.library.rest.api.user;

import com.library.rest.api.request.UserRequest;
import com.library.rest.api.request.UsersRequest;
import com.library.rest.api.request.LoginRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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

    @POST
    @Path("/save")
    public Response save(UserRequest request);

    @POST
    @Path("/update")
    public Response update(UserRequest request);

    @GET
    @Path("/load")
    public Response load(@QueryParam("id") Long id);

    @GET
    @Path("/delete")
    public Response delete(@QueryParam("id") Long id);

    @POST
    @Path("/saveAll")
    public Response saveAll(UsersRequest request);

    @POST
    @Path("/deleteAll")
    public Response deleteAll(UsersRequest request);
}
