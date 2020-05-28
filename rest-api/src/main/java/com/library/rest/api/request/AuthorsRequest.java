package com.library.rest.api.request;

import com.library.rest.api.vo.book.AuthorVo;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class AuthorsRequest extends EntityListRequest<AuthorVo> {

    public AuthorsRequest() {
    }

    public AuthorsRequest(List<AuthorVo> entities) {
        super(entities);
    }

}
