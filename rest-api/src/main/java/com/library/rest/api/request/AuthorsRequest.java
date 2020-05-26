package com.library.rest.api.request;

import com.library.domain.book.Author;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class AuthorsRequest extends EntityListRequest<Author> {

    public AuthorsRequest(List<Author> entities) {
        super(entities);
    }

}
