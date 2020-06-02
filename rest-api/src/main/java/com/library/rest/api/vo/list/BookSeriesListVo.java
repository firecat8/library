package com.library.rest.api.vo.list;

import com.library.rest.api.vo.EntityListVo;
import com.library.rest.api.vo.book.BookSerieVo;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class BookSeriesListVo extends EntityListVo<BookSerieVo>{

    public BookSeriesListVo() {
    }

    public BookSeriesListVo(List<BookSerieVo> entities) {
        super(entities);
    }
    
}
