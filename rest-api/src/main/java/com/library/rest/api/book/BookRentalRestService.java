package com.library.rest.api.book;

import com.library.rest.api.request.BookRentalRequest;
import com.library.rest.api.request.BookRentalsRequest;
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
@Path("/book/rental")
@Consumes("application/json")
@Produces("application/json")
public interface BookRentalRestService {

    @POST
    @Path("/save")
    public Response save(BookRentalRequest request);

    @POST
    @Path("/update")
    public Response update(BookRentalRequest request);

    @GET
    @Path("/load")
    public Response load(@QueryParam("id") Long id);

    @GET
    @Path("/loadAll")
    public Response loadAll();

    @DELETE
    @Path("/delete")
    public Response delete(@QueryParam("id") Long id);

    @POST
    @Path("/saveAll")
    public Response saveAll(BookRentalsRequest request);

    @POST
    @Path("/deleteAll")
    public Response deleteAll(BookRentalsRequest request);
}
