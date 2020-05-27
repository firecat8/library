package com.library.rest.api.request;

import com.library.rest.api.vo.book.GenreVo;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class GenresRequest extends EntityListRequest<GenreVo> {

    public GenresRequest(List<GenreVo> entities) {
        super(entities);
    }

}
