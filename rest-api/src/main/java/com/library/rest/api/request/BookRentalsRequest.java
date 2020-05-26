package com.library.rest.api.request;

import com.library.domain.book.BookRental;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class BookRentalsRequest extends EntityListRequest<BookRental> {

    public BookRentalsRequest(List<BookRental> entities) {
        super(entities);
    }

}
