package com.library.rest.api.request;

import com.library.rest.api.vo.book.BookRentalVo;

/**
 *
 * @author gdimitrova
 */
public class BookRentalRequest extends EntityRequest<BookRentalVo> {

    public BookRentalRequest(BookRentalVo entity) {
        super(entity);
    }

}
