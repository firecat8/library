package com.library.bl.rest.impl.user;

import com.library.bl.rest.impl.AbstractRestService;
import com.library.bl.rest.impl.ErrorCode;
import com.library.bl.rest.impl.ErrorUtils;
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
import java.util.List;
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
//        if (username.equals("admin") && password.equals("admin1234")) {
//            return Response.ok(getMainAdmin()).build();
//        }
        return doInTransaction((daoRegistry) -> {
            User user = getDao(daoRegistry).load(username, password);
            if (user == null) {
                Set<String> errors = new HashSet<>();
                errors.add("Not valid username and password");
                return buildResponse(ErrorCode.NOT_FOUND, errors);
            }
            return Response.ok(exchanger.exchange(user)).build();
        });
    }

    @Override
    public Response logout(String sessionId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response save(UserRequest request) {
        return super.save(request.getEntity());
    }

    @Override
    public Response update(UserRequest request) {
        return super.update(request.getEntity());
    }

    @Override
    public Response load(Long id) {
        return super.loadById(id);
    }

    @Override
    public Response saveAll(UsersRequest request) {
        return super.saveAll(request.getList());
    }

    @Override
    public Response deleteAll(UsersRequest request) {
        return super.deleteAll(request.getList());
    }
    @Override
    public Response loadReaders() {
        return doInTransaction((daoRegistry) -> {
            List entities = getDao(daoRegistry).loadReaders();
            return Response.ok(entities).build();
        });
    }

    @Override
    protected Set<String> validate(User entity) {
        Set<String> errors = new HashSet<>();
        if (entity == null) {
            errors.add("Entity is null");
            return errors;
        }
        if(ErrorUtils.isValid(entity.getFirstName())){
            errors.add("Missing first name.");
        }
        if(ErrorUtils.isValid(entity.getSurname())){
            errors.add("Missing surname.");
        }
        if(ErrorUtils.isValid(entity.getLastName())){
            errors.add("Missing last name.");
        }
        if(ErrorUtils.isValid(entity.getEmail())){
            errors.add("Missing email.");
        }
        if(ErrorUtils.isValid(entity.getPhoneNumber())){
            errors.add("Missing phone number.");
        }
        if(ErrorUtils.isValid(entity.getUserName())){
            errors.add("Missing username.");
        }
        if(ErrorUtils.isValid(entity.getPassword())){
            errors.add("Missing password.");
        }
        return errors;
    }

//    private UserVo getMainAdmin() {
//        return new UserVo("admin", "admin1234", "defaultAdmin@gmail.bg", RolesVo.ADMINISTRATOR, "admin", "admin", "admin", "1234");
//    }

   
}
