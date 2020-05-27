package com.library.bl.rest.impl.book;

import com.library.bl.rest.impl.AbstractRestService;
import com.library.bl.rest.impl.vo.exchanger.AuthorVoExchanger;
import com.library.dao.AuthorDao;
import com.library.dao.DaoRegistry;
import com.library.dao.DaoRegistryFactory;
import com.library.domain.book.Author;
import com.library.rest.api.book.AuthorRestService;
import com.library.rest.api.request.AuthorRequest;
import com.library.rest.api.request.AuthorsRequest;
import com.library.rest.api.vo.book.AuthorVo;
import java.util.Set;
import javax.ws.rs.core.Response;

/**
 *
 * @author gdimitrova
 */
public class AuthorRestServiceImpl extends AbstractRestService<AuthorDao, AuthorVo, Author> implements AuthorRestService {

    public AuthorRestServiceImpl(DaoRegistryFactory factory) {
        super(factory, AuthorVoExchanger.INSTANCE);
    }

    @Override
    protected AuthorDao getDao(DaoRegistry registry) {
        return registry.getAuthorDao();
    }

    @Override
    public Response save(AuthorRequest request) {
        return this.save(request.getEntity());
    }

    @Override
    public Response update(AuthorRequest request) {
        return this.update(request.getEntity());
    }

    @Override
    public Response load(Long id) {
        return this.loadById(id);
    }

    @Override
    public Response saveAll(AuthorsRequest request) {
        return this.saveAll(request.getList());
    }

    @Override
    public Response deleteAll(AuthorsRequest request) {
        return this.deleteAll(request.getList());
    }

    @Override
    protected Set<String> validate(Author entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
