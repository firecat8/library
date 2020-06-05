package com.library.rest.api.service;

import com.library.rest.api.CrudRestService;
import com.library.rest.api.vo.list.UsersListVo;
import com.library.rest.api.vo.user.UserVo;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author gdimitrova
 */
public interface UserRestService extends CrudRestService<UserVo, UsersListVo> {

    @GET
    @Path("/load/{username}")
    public Response load(@PathParam("username") String username);
}
