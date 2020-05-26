package com.library.rest.api.request;

import com.library.domain.book.BookSerie;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class BookSeriesRequest extends EntityListRequest<BookSerie> {

    public BookSeriesRequest(List<BookSerie> entities) {
        super(entities);
    }

}
