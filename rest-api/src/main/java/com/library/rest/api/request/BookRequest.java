package com.library.rest.api.request;

import com.library.domain.book.Book;

/**
 *
 * @author gdimitrova
 */
public class BookRequest extends EntityRequest<Book> {

    public BookRequest(Book entity) {
        super(entity);
    }

}
