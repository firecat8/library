package com.library.bl.rest.impl.book;

import com.library.bl.rest.impl.AbstractRestService;
import com.library.dao.BookDao;
import com.library.dao.DaoRegistry;
import com.library.domain.book.Book;
import com.library.rest.api.book.BookRestService;
import com.library.rest.api.request.AddBookRequest;
import javax.ws.rs.core.Response;

/**
 *
 * @author gdimitrova
 */
public class BookRestServiceImpl extends AbstractRestService<BookDao, Book> implements BookRestService {

    public BookRestServiceImpl(DaoRegistry daoRegistry) {
        super(daoRegistry);
    }

    @Override
    protected BookDao getDao() {
        return daoRegistry.getBookDao();
    }

    @Override
    public Response add(AddBookRequest request) {
        return save(request.getValue());
    }

}
