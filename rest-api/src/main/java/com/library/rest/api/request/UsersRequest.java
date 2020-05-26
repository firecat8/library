package com.library.rest.api.request;

import com.library.domain.user.User;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class UsersRequest extends EntityListRequest<User> {

    public UsersRequest(List<User> entities) {
        super(entities);
    }

}
