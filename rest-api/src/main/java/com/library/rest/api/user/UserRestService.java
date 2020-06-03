package com.library.rest.api.user;

import com.library.rest.api.CrudRestService;
import com.library.rest.api.request.LoginRequest;
import com.library.rest.api.vo.list.UsersListVo;
import com.library.rest.api.vo.user.UserVo;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author gdimitrova
 */
public interface UserRestService extends CrudRestService<UserVo, UsersListVo> {

    @POST
    @Path("/login")
    public Response login(LoginRequest request);

}
