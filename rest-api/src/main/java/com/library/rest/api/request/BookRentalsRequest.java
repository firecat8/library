package com.library.rest.api.request;

import com.library.rest.api.vo.book.BookRentalVo;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class BookRentalsRequest extends EntityListRequest<BookRentalVo> {

    public BookRentalsRequest(List<BookRentalVo> entities) {
        super(entities);
    }

}
