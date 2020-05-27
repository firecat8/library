package com.library.bl.rest.impl.user;

import com.library.bl.rest.impl.AbstractRestService;
import com.library.bl.rest.impl.ErrorCode;
import com.library.bl.rest.impl.vo.exchanger.UserVoExchanger;
import com.library.dao.DaoRegistry;
import com.library.dao.DaoRegistryFactory;
import com.library.dao.UserDao;
import com.library.domain.user.User;
import com.library.rest.api.request.LoginRequest;
import com.library.rest.api.request.UserRequest;
import com.library.rest.api.request.UsersRequest;
import com.library.rest.api.user.UserRestService;
import com.library.rest.api.vo.user.RolesVo;
import com.library.rest.api.vo.user.UserVo;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Response;

/**
 *
 * @author gdimitrova
 */
public class UserRestServiceImpl extends AbstractRestService<UserDao, UserVo, User> implements UserRestService {

    public UserRestServiceImpl(DaoRegistryFactory factory) {
        super(factory, UserVoExchanger.INSTANCE);
    }

    @Override
    protected UserDao getDao(DaoRegistry registry) {
        return registry.getUserDao();
    }

    @Override
    public Response login(LoginRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();
        if (username.equals(password)) {
            return Response.status(Response.Status.OK).entity(new UserVo(username, password, null, RolesVo.ADMINISTRATOR, username, username, username, username)).build();
        }
        return buildResponse(ErrorCode.NOT_FOUND, new HashSet<>());
    }

    @Override
    public Response logout(String sessionId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response save(UserRequest request) {
        return this.save(request.getEntity());
    }

    @Override
    public Response update(UserRequest request) {
        return this.update(request.getEntity());
    }

    @Override
    public Response load(Long id) {
        return this.loadById(id);
    }

    @Override
    public Response saveAll(UsersRequest request) {
        return this.saveAll(request.getList());
    }

    @Override
    public Response deleteAll(UsersRequest request) {
        return this.deleteAll(request.getList());
    }

    @Override
    protected Set<String> validate(User entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
