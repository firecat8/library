/*
 * Project library
 */
package com.library.bl.rest.impl.vo.exchanger;

import com.library.domain.user.Roles;
import com.library.domain.user.User;
import com.library.rest.api.vo.user.RolesVo;
import com.library.rest.api.vo.user.UserVo;

/**
 *
 * @author gdimitrova
 */
public class UserVoExchanger extends VoEntityExchanger<UserVo, User> {

    public final static UserVoExchanger INSTANCE = new UserVoExchanger();

    private UserVoExchanger() {
    }

    @Override
    protected User exchangeFrom(UserVo vo) {
        return new User(vo.getUserName(), vo.getPassword(), vo.getEmail(),  Roles.valueOf(vo.getRole().name()),
                vo.getFirstName(), vo.getSurname(), vo.getLastName(), vo.getPhoneNumber());
    }

    @Override
    protected UserVo exchangeFrom(User e) {
        return new UserVo(e.getUserName(), e.getPassword(), e.getEmail(),RolesVo.valueOf(e.getRole().name()),
                e.getFirstName(), e.getSurname(), e.getLastName(), e.getPhoneNumber());
    }

}
