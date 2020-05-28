package com.library.rest.api.book;

import com.library.rest.api.request.BookSerieRequest;
import com.library.rest.api.request.BookSeriesRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
@Path("/book/serie")
@Consumes("application/json")
@Produces("application/json")
public interface BookSerieRestService {

    @POST
    @Path("/save")
    public Response save(BookSerieRequest request);

    @POST
    @Path("/update")
    public Response update(BookSerieRequest request);

    @GET
    @Path("/load")
    public Response load(@QueryParam("id") Long id);

    @DELETE
    @Path("/delete")
    public Response delete(@QueryParam("id") Long id);

    @POST
    @Path("/saveAll")
    public Response saveAll(BookSeriesRequest request);

    @POST
    @Path("/deleteAll")
    public Response deleteAll(BookSeriesRequest request);

    @GET
    @Path("/loadAll")
    public Response loadAll();
}
