package com.library.bl.rest.impl.book;

import com.library.bl.rest.impl.AbstractRestService;
import com.library.bl.rest.impl.vo.exchanger.BookSerieVoExchanger;
import com.library.dao.BookSerieDao;
import com.library.dao.DaoRegistry;
import com.library.dao.DaoRegistryFactory;
import com.library.domain.book.BookSerie;
import com.library.rest.api.book.BookSerieRestService;
import com.library.rest.api.request.BookSerieRequest;
import com.library.rest.api.request.BookSeriesRequest;
import com.library.rest.api.vo.book.BookSerieVo;
import com.library.rest.api.vo.list.BookSeriesListVo;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ws.rs.core.Response;

/**
 *
 * @author gdimitrova
 */
public class BookSerieRestServiceImpl extends AbstractRestService<BookSerieDao, BookSerieVo, BookSerie, BookSeriesListVo> implements BookSerieRestService {

    public BookSerieRestServiceImpl(DaoRegistryFactory factory) {
        super(factory, BookSerieVoExchanger.INSTANCE);
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
        Set<String> errors = new HashSet<>();
        if (entity.getName().isBlank()) {
            errors.add("Blank name.");
        }
        if (entity.getName().isEmpty()) {
            errors.add("Empty name.");
        }
        return errors;
    }

    @Override
    protected BookSeriesListVo makeListVo(List<BookSerieVo> entities) {
        return new BookSeriesListVo(entities);
    }

}
