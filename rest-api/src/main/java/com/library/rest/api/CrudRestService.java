package com.library.rest.api;

import com.library.rest.api.vo.AbstractVo;
import com.library.rest.api.vo.EntityListVo;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author gdimitrova
 * @param <Vo>
 * @param <ListVo>
 */
@Consumes("application/json")
@Produces("application/json")
public interface CrudRestService<Vo extends AbstractVo, ListVo extends EntityListVo<Vo>> {

    @POST
    @RolesAllowed({"ADMINISTRATOR", "OPERATOR"})
    @Path("/save")
    public Response save(Vo vo);

    @POST
    @RolesAllowed({"ADMINISTRATOR", "OPERATOR"})
    @Path("/update")
    public Response update(Vo vo);

    @GET
    @Path("/loadById/{id}")
    public Response loadById(@PathParam("id") Long id);

    @GET
    @Path("/loadAll")
    public Response loadAll();

    @DELETE
    @RolesAllowed({"ADMINISTRATOR", "OPERATOR"})
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") Long id);

    @POST
    @RolesAllowed({"ADMINISTRATOR", "OPERATOR"})
    @Path("/saveAll")
    public Response saveAll(ListVo listVo);

    @DELETE
    @RolesAllowed({"ADMINISTRATOR", "OPERATOR"})
    @Path("/deleteAll")
    public Response deleteAll(ListVo listVo);

}
