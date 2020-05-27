package com.library.rest.api.request;

import com.library.rest.api.vo.book.BookVo;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class BooksRequest extends EntityListRequest<BookVo> {

    public BooksRequest(List<BookVo> entities) {
        super(entities);
    }

}
