package com.library.rest.api.request;

import com.library.domain.book.Genre;

/**
 *
 * @author gdimitrova
 */
public class GenreRequest extends EntityRequest<Genre> {

    public GenreRequest(Genre entity) {
        super(entity);
    }

}
