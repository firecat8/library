package com.library.rest.api.book;

import com.library.rest.api.request.CharacteristicRequest;
import com.library.rest.api.request.CharacteristicsRequest;
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
@Path("/book/characteristic")
@Consumes("application/json")
@Produces("application/json")
public interface CharacteristicRestService {

    @POST
    @Path("/save")
    public Response save(CharacteristicRequest request);

    @POST
    @Path("/update")
    public Response update(CharacteristicRequest request);

    @GET
    @Path("/load")
    public Response load(@QueryParam("id") Long id);

    @GET
    @Path("/delete")
    public Response delete(@QueryParam("id") Long id);

    @POST
    @Path("/saveAll")
    public Response saveAll(CharacteristicsRequest request);

    @POST
    @Path("/deleteAll")
    public Response deleteAll(CharacteristicsRequest request);
}
