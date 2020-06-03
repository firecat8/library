package com.library.rest.api;

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
 * @param <Vo>
 * @param <ListVo>
 */
@Consumes("application/json")
@Produces("application/json")
public interface CrudRestService<Vo,ListVo> {

    @POST
    @Path("/save")
    public Response save(Vo vo);

    @POST
    @Path("/update")
    public Response update(Vo vo);

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
    public Response saveAll(ListVo listVo);

    @POST
    @Path("/deleteAll")
    public Response deleteAll(ListVo listVo);
    
}
