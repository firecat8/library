package com.library.rest.api.book;

import com.library.rest.api.request.AddBookRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author gdimitrova
 */
@Path("/book")
@Consumes("application/json")
@Produces("application/json")
public interface BookRestService {
    
    @POST
    @Path("/add")
    public Response add(AddBookRequest request);
    
}
