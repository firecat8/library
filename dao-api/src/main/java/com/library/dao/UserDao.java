package com.library.dao;

import com.library.domain.user.User;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public interface UserDao extends CrudDao<User> {

    public User load(String username, String pass);

    public User load(String username);

    public List<User> loadReaders();

}
