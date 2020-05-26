package com.library.bl.rest.impl.book;

import com.library.bl.rest.impl.AbstractRestService;
import com.library.dao.BookSerieDao;
import com.library.dao.DaoRegistry;
import com.library.dao.DaoRegistryFactory;
import com.library.domain.book.BookSerie;
import com.library.rest.api.book.BookSerieRestService;
import com.library.rest.api.request.BookSerieRequest;
import com.library.rest.api.request.BookSeriesRequest;
import java.util.Set;
import javax.ws.rs.core.Response;

/**
 *
 * @author gdimitrova
 */
public class BookSerieRestServiceImpl extends AbstractRestService<BookSerieDao, BookSerie> implements BookSerieRestService {

    public BookSerieRestServiceImpl(DaoRegistryFactory factory) {
        super(factory);
    }

  
    @Override
    protected BookSerieDao getDao(DaoRegistry registry) {
        return registry.getBookSerieDao();
    }

    @Override
    public Response save(BookSerieRequest request) {
        return this.save(request.getEntity());
    }

    @Override
    public Response update(BookSerieRequest request) {
        return this.update(request.getEntity());
    }

    @Override
    public Response load(Long id) {
        return this.loadById(id);
    }

    @Override
    public Response saveAll(BookSeriesRequest request) {
        return this.saveAll(request.getList());
    }

    @Override
    public Response deleteAll(BookSeriesRequest request) {
        return this.deleteAll(request.getList());
    }

    @Override
    protected Set<String> validate(BookSerie entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
