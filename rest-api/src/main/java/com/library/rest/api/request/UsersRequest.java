package com.library.rest.api.request;

import com.library.rest.api.vo.user.UserVo;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class UsersRequest extends EntityListRequest<UserVo> {

    public UsersRequest() {
    }

    public UsersRequest(List<UserVo> entities) {
        super(entities);
    }

}
