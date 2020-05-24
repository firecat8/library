package com.library.rest.api.book;

import com.library.rest.api.request.AddOperatorRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author gdimitrova
 */
@Path("/operator")
@Consumes("application/json")
@Produces("application/json")
public interface OperatorRestService {
    
    @POST
    @Path("/add")
    public Response add(AddOperatorRequest request);

}
