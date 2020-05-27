package com.library.rest.api.request;

import com.library.rest.api.vo.book.BookSerieVo;

/**
 *
 * @author gdimitrova
 */
public class BookSerieRequest extends EntityRequest<BookSerieVo> {

    public BookSerieRequest(BookSerieVo entity) {
        super(entity);
    }

}
