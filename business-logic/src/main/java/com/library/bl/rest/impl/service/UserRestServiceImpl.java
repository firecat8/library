package com.library.bl.rest.impl.service;

import com.library.bl.rest.impl.CrudRestServiceImpl;
import com.library.bl.rest.impl.ErrorCode;
import com.library.bl.rest.impl.vo.exchanger.UserVoExchanger;
import com.library.dao.DaoRegistry;
import com.library.dao.DaoRegistryFactory;
import com.library.dao.UserDao;
import com.library.domain.user.User;
import com.library.rest.api.service.UserRestService;
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
        super(factory,
                UserVoExchanger.INSTANCE,
                UsersListVo::new,
                DaoRegistry::getUserDao
        );
    }

    @Override
    public Response load(String username) {
        if (username == null) {
            Set<String> errors = new HashSet<>();
            errors.add("Not valid username, username is null ");
            return buildResponse(ErrorCode.VALIDATION, errors);
        }
        return doInTransaction((daoRegistry) -> {
            User loaded = daoRegistry.getUserDao().load(username);
            if (loaded == null) {
                return buildResponse(ErrorCode.NOT_FOUND, new HashSet<>());
            }
            return Response.ok(exchanger.exchange(loaded)).build();
        });
    }

}
