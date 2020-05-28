package com.library.rest.api.request;

import com.library.rest.api.vo.user.UserVo;

/**
 *
 * @author gdimitrova
 */
public class UserRequest extends EntityRequest<UserVo> {

    public UserRequest() {
    }

    public UserRequest(UserVo entity) {
        super(entity);
    }

}
