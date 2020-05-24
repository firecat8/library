package com.library.bl.rest.impl.user;

import com.library.bl.rest.impl.AbstractRestService;
import com.library.dao.DaoRegistry;
import com.library.dao.UserDao;
import com.library.domain.user.Roles;
import com.library.domain.user.User;
import com.library.rest.api.request.LoginRequest;
import com.library.rest.api.user.UserRestService;
import javax.ws.rs.core.Response;

/**
 *
 * @author gdimitrova
 */
public class UserRestServiceImpl extends AbstractRestService<UserDao, User> implements UserRestService {

    public UserRestServiceImpl(DaoRegistry daoRegistry) {
        super(daoRegistry);
    }

    @Override
    protected UserDao getDao() {
        return daoRegistry.getUserDao();
    }

    @Override
    public Response login(LoginRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();
        if (username.equals(password)) {
            return Response.status(Response.Status.OK).entity(new User(username, password, null, Roles.ADMINISTRATOR)).build();
        }
        return Response.status(Response.Status.OK).entity(new User(username, password, null, Roles.READER)).build();
    }

    @Override
    public Response logout(String sessionId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
