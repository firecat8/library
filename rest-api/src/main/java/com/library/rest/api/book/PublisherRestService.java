package com.library.rest.api.book;

import com.library.rest.api.request.PublisherRequest;
import com.library.rest.api.request.PublishersRequest;
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
@Path("/book/publisher")
@Consumes("application/json")
@Produces("application/json")
public interface PublisherRestService {

    @POST
    @Path("/save")
    public Response save(PublisherRequest request);

    @POST
    @Path("/update")
    public Response update(PublisherRequest request);

    @GET
    @Path("/load")
    public Response load(@QueryParam("id") Long id);

    @DELETE
    @Path("/delete")
    public Response delete(@QueryParam("id") Long id);

    @POST
    @Path("/saveAll")
    public Response saveAll(PublishersRequest request);

    @POST
    @Path("/deleteAll")
    public Response deleteAll(PublishersRequest request);

    @GET
    @Path("/loadAll")
    public Response loadAll();
}
