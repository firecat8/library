/*
 * Project library
 */
package com.library.dto.exchanger;

import com.library.domain.user.User;
import com.library.dto.UserDto;

/**
 *
 * @author gdimitrova
 */
public class UserDtoExchanger extends DtoEntityExchanger<UserDto, User> {

    public final static UserDtoExchanger INSTANCE = new UserDtoExchanger();

    private UserDtoExchanger() {
    }

    @Override
    protected User exchangeFrom(UserDto dto) {
        return new User(dto.getUserName(), dto.getPassword(), dto.getEmail(), dto.getRole(),
                dto.getFirstName(), dto.getSurname(), dto.getLastName(), dto.getPhoneNumber());
    }

    @Override
    protected UserDto exchangeFrom(User e) {
        return new UserDto(e.getUserName(), e.getPassword(), e.getEmail(), e.getRole(),
                e.getFirstName(), e.getSurname(), e.getLastName(), e.getPhoneNumber());
    }

}
