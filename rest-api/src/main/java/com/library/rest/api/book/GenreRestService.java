package com.library.rest.api.book;

import com.library.rest.api.request.GenreRequest;
import com.library.rest.api.request.GenresRequest;
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
@Path("/book/genre")
@Consumes("application/json")
@Produces("application/json")
public interface GenreRestService {
    
    @POST
    @Path("/save")
    public Response save(GenreRequest request);

    @POST
    @Path("/update")
    public Response update(GenreRequest request);

    @GET
    @Path("/load")
    public Response load(@QueryParam("id") Long id);

    @GET
    @Path("/delete")
    public Response delete(@QueryParam("id") Long id);

    @POST
    @Path("/saveAll")
    public Response saveAll(GenresRequest request);

    @POST
    @Path("/deleteAll")
    public Response deleteAll(GenresRequest request);
    
}
