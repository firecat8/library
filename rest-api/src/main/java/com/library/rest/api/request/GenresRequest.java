package com.library.rest.api.request;

import com.library.domain.book.Genre;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class GenresRequest extends EntityListRequest<Genre> {

    public GenresRequest(List<Genre> entities) {
        super(entities);
    }

}
