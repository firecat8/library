package com.library.bl.rest.impl.book;

import com.library.bl.rest.impl.AbstractRestService;
import com.library.dao.DaoRegistry;
import com.library.dao.DaoRegistryFactory;
import com.library.dao.PublisherDao;
import com.library.domain.book.Publisher;
import com.library.rest.api.book.PublisherRestService;
import com.library.rest.api.request.PublisherRequest;
import com.library.rest.api.request.PublishersRequest;
import java.util.Set;
import javax.ws.rs.core.Response;

/**
 *
 * @author gdimitrova
 */
public class PublisherRestServiceImpl extends AbstractRestService< PublisherDao, Publisher> implements PublisherRestService {

    public PublisherRestServiceImpl(DaoRegistryFactory factory) {
        super(factory);
    }

    @Override
    protected PublisherDao getDao(DaoRegistry registry) {
        return registry.getPublisherDao();
    }

    @Override
    public Response save(PublisherRequest request) {
        return this.save(request.getEntity());
    }

    @Override
    public Response update(PublisherRequest request) {
        return this.update(request.getEntity());
    }

    @Override
    public Response load(Long id) {
        return this.loadById(id);
    }

    @Override
    public Response saveAll(PublishersRequest request) {
        return this.saveAll(request.getList());
    }

    @Override
    public Response deleteAll(PublishersRequest request) {
        return this.deleteAll(request.getList());
    }

    @Override
    protected Set<String> validate(Publisher entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
