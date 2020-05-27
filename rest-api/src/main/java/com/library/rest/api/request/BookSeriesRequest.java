package com.library.rest.api.request;

import com.library.rest.api.vo.book.BookSerieVo;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class BookSeriesRequest extends EntityListRequest<BookSerieVo> {

    public BookSeriesRequest(List<BookSerieVo> entities) {
        super(entities);
    }

}
