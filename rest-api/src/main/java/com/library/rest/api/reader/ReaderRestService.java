package com.library.rest.api.reader;

import com.library.rest.api.request.AddReaderRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author gdimitrova
 */
@Path("/reader")
@Consumes("application/json")
@Produces("application/json")
public interface ReaderRestService {
    
    @POST
    @Path("/addReader")
    public Response addReader(AddReaderRequest request);
}
