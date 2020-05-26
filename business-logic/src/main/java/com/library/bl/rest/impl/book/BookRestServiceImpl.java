package com.library.bl.rest.impl.book;

import com.library.bl.rest.impl.AbstractRestService;
import com.library.dao.BookDao;
import com.library.dao.DaoRegistry;
import com.library.dao.DaoRegistryFactory;
import com.library.domain.book.Book;
import com.library.rest.api.book.BookRestService;
import com.library.rest.api.request.BookRequest;
import com.library.rest.api.request.BooksRequest;
import java.util.Set;
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
    public Response save(BookRequest request) {
        return this.save(request.getEntity());
    }

    @Override
    public Response update(BookRequest request) {
        return this.update(request.getEntity());
    }

    @Override
    public Response load(Long id) {
        return this.loadById(id);
    }

    @Override
    public Response saveAll(BooksRequest request) {
        return this.saveAll(request.getList());
    }

    @Override
    public Response deleteAll(BooksRequest request) {
        return this.deleteAll(request.getList());
    }

    @Override
    protected Set<String> validate(Book entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
