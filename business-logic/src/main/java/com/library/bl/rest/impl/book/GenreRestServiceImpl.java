package com.library.bl.rest.impl.book;

import com.library.bl.rest.impl.AbstractRestService;
import com.library.bl.rest.impl.vo.exchanger.GenreVoExchanger;
import com.library.dao.DaoRegistry;
import com.library.dao.DaoRegistryFactory;
import com.library.dao.GenreDao;
import com.library.domain.book.Genre;
import com.library.rest.api.book.GenreRestService;
import com.library.rest.api.request.GenreRequest;
import com.library.rest.api.request.GenresRequest;
import com.library.rest.api.vo.book.GenreVo;
import com.library.rest.api.vo.list.GenresListVo;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ws.rs.core.Response;

/**
 *
 * @author gdimitrova
 */
public class GenreRestServiceImpl extends AbstractRestService< GenreDao, GenreVo, Genre,GenresListVo> implements GenreRestService {

    public GenreRestServiceImpl(DaoRegistryFactory factory) {
        super(factory, GenreVoExchanger.INSTANCE);
    }

    @Override
    protected GenreDao getDao(DaoRegistry registry) {
        return registry.getGenreDao();
    }

    @Override
    public Response save(GenreRequest request) {
        return this.save(request.getEntity());
    }

    @Override
    public Response update(GenreRequest request) {
        return this.update(request.getEntity());
    }

    @Override
    public Response load(Long id) {
        return this.loadById(id);
    }

    @Override
    public Response saveAll(GenresRequest request) {
        return this.saveAll(request.getList());
    }

    @Override
    public Response deleteAll(GenresRequest request) {
        return this.deleteAll(request.getList());
    }

    @Override
    protected Set<String> validate(Genre entity) {
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
    protected GenresListVo makeListVo(List<GenreVo> entities) {
        return new GenresListVo(entities);
    }
}
