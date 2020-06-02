package com.library.bl.rest.impl.book;

import com.library.bl.rest.impl.AbstractRestService;
import com.library.bl.rest.impl.vo.exchanger.BookRentalVoExchanger;
import com.library.dao.BookRentalDao;
import com.library.dao.DaoRegistry;
import com.library.dao.DaoRegistryFactory;
import com.library.domain.book.BookRental;
import com.library.rest.api.book.BookRentalRestService;
import com.library.rest.api.request.BookRentalRequest;
import com.library.rest.api.request.BookRentalsRequest;
import com.library.rest.api.vo.book.BookRentalVo;
import com.library.rest.api.vo.list.BooksRentalListVo;
import java.util.List;
import java.util.Set;
import javax.ws.rs.core.Response;

/**
 *
 * @author gdimitrova
 */
public class BookRentalRestServiceImpl extends AbstractRestService<BookRentalDao, BookRentalVo, BookRental,BooksRentalListVo> implements BookRentalRestService {

    public BookRentalRestServiceImpl(DaoRegistryFactory factory) {
        super(factory, BookRentalVoExchanger.INSTANCE);
    }

    @Override
    protected BookRentalDao getDao(DaoRegistry registry) {
       return registry.getBookRentalDao();
    }

    @Override
    protected Set<String> validate(BookRental entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response save(BookRentalRequest request) {
      return this.save(request.getEntity());
    }

    @Override
    public Response update(BookRentalRequest request) {
        return this.update(request.getEntity());
    }

    @Override
    public Response load(Long id) {
        return this.loadById(id);
    }

    @Override
    public Response saveAll(BookRentalsRequest request) {
        return this.saveAll(request.getList());
    }

    @Override
    public Response deleteAll(BookRentalsRequest request) {
        return this.deleteAll(request.getList());
    }

    @Override
    protected BooksRentalListVo makeListVo(List<BookRentalVo> entities) {
        return new BooksRentalListVo(entities);
    }
    
}
