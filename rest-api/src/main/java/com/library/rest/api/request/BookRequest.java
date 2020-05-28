package com.library.rest.api.request;

import com.library.rest.api.vo.book.BookVo;

/**
 *
 * @author gdimitrova
 */
public class BookRequest extends EntityRequest<BookVo> {

    public BookRequest() {
    }

    public BookRequest(BookVo entity) {
        super(entity);
    }

}
