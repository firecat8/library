package com.library.bl.rest.impl.user;

import com.library.bl.rest.impl.ErrorCode;
import com.library.bl.rest.impl.CrudRestServiceImpl;
import com.library.bl.rest.impl.vo.exchanger.UserVoExchanger;
import com.library.dao.DaoRegistry;
import com.library.dao.DaoRegistryFactory;
import com.library.dao.UserDao;
import com.library.domain.user.User;
import com.library.rest.api.request.LoginRequest;
import com.library.rest.api.user.UserRestService;
import com.library.rest.api.vo.list.UsersListVo;
import com.library.rest.api.vo.user.UserVo;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Response;

/**
 *
 * @author gdimitrova
 */
public class UserRestServiceImpl extends CrudRestServiceImpl<UserDao, UserVo, User, UsersListVo> implements UserRestService {

    public UserRestServiceImpl(DaoRegistryFactory factory) {
        super(
                factory,
                UserVoExchanger.INSTANCE,
                UsersListVo::new,
                DaoRegistry::getUserDao
        );
    }

    @Override
    public Response login(LoginRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();

        return doInTransaction((daoRegistry) -> {
            User user = daoRegistry.getUserDao().load(username, password);
//            if (user == null && username.equals("admin") && password.equals("admin")) {
//                user = getDao(daoRegistry).save(getMainAdmin());
//            }
            if (user == null) {
                Set<String> errors = new HashSet<>();
                errors.add("Not valid username and password");
                return buildResponse(ErrorCode.NOT_FOUND, errors);
            }
            return Response.ok(exchanger.exchange(user)).build();
        });
    }
  
}
