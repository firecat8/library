package com.library.rest.api.request;

import com.library.rest.api.vo.book.AuthorVo;

/**
 *
 * @author gdimitrova
 */
public class AuthorRequest extends EntityRequest<AuthorVo> {

    public AuthorRequest(AuthorVo entity) {
        super(entity);
    }

}
