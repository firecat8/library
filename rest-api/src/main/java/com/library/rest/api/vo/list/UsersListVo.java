package com.library.rest.api.vo.list;

import com.library.rest.api.vo.EntityListVo;
import com.library.rest.api.vo.user.UserVo;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class UsersListVo extends EntityListVo<UserVo>{

    public UsersListVo() {
    }

    public UsersListVo(List<UserVo> entities) {
        super(entities);
    }
    
}
