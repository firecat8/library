package com.library.rest.api.request;

import com.library.domain.book.BookSerie;

/**
 *
 * @author gdimitrova
 */
public class BookSerieRequest extends EntityRequest<BookSerie> {

    public BookSerieRequest(BookSerie entity) {
        super(entity);
    }

}
