package com.library.rest.api.request;

import com.library.rest.api.vo.book.GenreVo;

/**
 *
 * @author gdimitrova
 */
public class GenreRequest extends EntityRequest<GenreVo> {

    public GenreRequest(GenreVo entity) {
        super(entity);
    }

}
