package com.library.rest.api.request;

import com.library.domain.book.Author;

/**
 *
 * @author gdimitrova
 */
public class AuthorRequest extends EntityRequest<Author> {

    public AuthorRequest(Author entity) {
        super(entity);
    }

}
