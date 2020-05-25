package com.library.bl.rest.impl.book;

import com.library.bl.rest.impl.AbstractRestService;
import com.library.dao.BookDao;
import com.library.dao.DaoRegistry;
import com.library.dao.DaoRegistryFactory;
import com.library.domain.book.Book;
import com.library.rest.api.book.BookRestService;
import com.library.rest.api.request.AddBookRequest;
import javax.ws.rs.core.Response;

/**
 *
 * @author gdimitrova
 */
public class BookRestServiceImpl extends AbstractRestService<BookDao, Book> implements BookRestService {

    public BookRestServiceImpl(DaoRegistryFactory factory) {
        super(factory);
    }

    @Override
    protected BookDao getDao(DaoRegistry registry) {
        return registry.getBookDao();
    }

    @Override
    public Response add(AddBookRequest request) {
        return save(request.getValue());
    }

}
