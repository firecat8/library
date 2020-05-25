/*
 * Project library
 */
package com.library.dao;

import com.library.domain.user.User;
import com.library.dto.UserDto;
import com.library.dto.exchanger.UserDtoExchanger;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;

/**
 *
 * @author gdimitrova
 */
public class UserDaoImpl extends AbstractCrudDao<UserDto, User> implements UserDao {

    public UserDaoImpl(EntityManager em) {
        super(UserDto.class, em, UserDtoExchanger.INSTANCE);
    }

    @Override
    protected Map<String, Object> loadProperties(UserDto newOne) {
        return new HashMap<>();
    }

}
