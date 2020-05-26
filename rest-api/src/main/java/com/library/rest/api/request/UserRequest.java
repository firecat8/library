package com.library.rest.api.request;

import com.library.domain.user.User;

/**
 *
 * @author gdimitrova
 */
public class UserRequest extends EntityRequest<User> {

    public UserRequest(User entity) {
        super(entity);
    }

}
