package com.library.rest.api.request;

import com.library.domain.book.Book;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class BooksRequest extends EntityListRequest<Book> {

    public BooksRequest(List<Book> entities) {
        super(entities);
    }

}
