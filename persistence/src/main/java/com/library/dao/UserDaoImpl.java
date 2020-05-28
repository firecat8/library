/*
 * Project library
 */
package com.library.dao;

import com.library.domain.user.Roles;
import com.library.domain.user.User;
import com.library.dto.UserDto;
import com.library.dto.exchanger.UserDtoExchanger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.management.relation.Role;
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
    public User load(String username, String pass) {
        Map<String, Object> props = new HashMap<>();
        props.put(UserDto.USERNAME_PROP, username);
        props.put(UserDto.PASSWORD_PROP, pass);
        List<User> users = getResults(props);
        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public List<User> loadReaders() {
        Map<String, Object> props = new HashMap<>();
        props.put(UserDto.ROLE_PROP, Roles.READER);
        List<User> users = getResults(props);
        return users.isEmpty() ? null : users;
    }

    @Override
    protected Map<String, Object> loadProperties(UserDto newOne) {
        return new HashMap<>();
    }

}
