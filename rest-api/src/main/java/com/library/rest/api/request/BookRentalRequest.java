package com.library.rest.api.request;

import com.library.domain.book.BookRental;

/**
 *
 * @author gdimitrova
 */
public class BookRentalRequest extends EntityRequest<BookRental> {

    public BookRentalRequest(BookRental entity) {
        super(entity);
    }

}
