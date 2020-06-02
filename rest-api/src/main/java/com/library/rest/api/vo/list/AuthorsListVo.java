package com.library.rest.api.vo.list;

import com.library.rest.api.vo.EntityListVo;
import com.library.rest.api.vo.book.AuthorVo;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class AuthorsListVo extends EntityListVo<AuthorVo>{

    public AuthorsListVo() {
    }

    public AuthorsListVo(List<AuthorVo> entities) {
        super(entities);
    }
    
}
