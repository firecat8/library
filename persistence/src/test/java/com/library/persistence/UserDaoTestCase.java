/*
 * Project library
 */
package com.library.persistence;

import com.library.dao.DaoRegistry;
import com.library.dao.UserDaoImpl;
import com.library.domain.user.Roles;
import com.library.domain.user.User;
import com.library.dto.UserDto;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class UserDaoTestCase extends AbstractCrudDaoTestCase<UserDto, User, UserDaoImpl> {

    @Override
    protected UserDaoImpl getDao(DaoRegistry registry) {
        return (UserDaoImpl) registry.getUserDao();
    }

    @Override
    protected User createEntity() {
        return createDefault();
    }

    @Override
    protected List<User> createEntities() {
        return createUsers();
    }

    private static User createEntity(String name, Roles role, String phoneNumber) {
        return new User(name + "1234", "pass", name + "@avb.bg", role, name, name, name, phoneNumber,new GregorianCalendar(2020, 1, 1));
    }

    public static User createDefault() {
        return createEntity("anton", Roles.READER, "5865163");
    }

    public static List<User> createUsers() {
        List<User> users = new ArrayList<>();
        users.add(createEntity("admin", Roles.ADMINISTRATOR, "89645"));
        users.add(createEntity("ann", Roles.OPERATOR, "963158"));
        return users;
    }

    @Override
    protected void prepareDbData(DaoRegistry registry) {
    }

    @Override
    protected boolean isRequiredDbDataPreparation() {
        return false;
    }
}
