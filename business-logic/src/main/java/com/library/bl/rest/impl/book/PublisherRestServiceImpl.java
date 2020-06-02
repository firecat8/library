package com.library.bl.rest.impl.book;

import com.library.bl.rest.impl.AbstractRestService;
import com.library.bl.rest.impl.vo.exchanger.PublisherVoExchanger;
import com.library.dao.DaoRegistry;
import com.library.dao.DaoRegistryFactory;
import com.library.dao.PublisherDao;
import com.library.domain.book.Publisher;
import com.library.rest.api.book.PublisherRestService;
import com.library.rest.api.request.PublisherRequest;
import com.library.rest.api.request.PublishersRequest;
import com.library.rest.api.vo.book.PublisherVo;
import com.library.rest.api.vo.list.PublishersListVo;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ws.rs.core.Response;

/**
 *
 * @author gdimitrova
 */
public class PublisherRestServiceImpl extends AbstractRestService< PublisherDao, PublisherVo, Publisher,PublishersListVo> implements PublisherRestService {

    public PublisherRestServiceImpl(DaoRegistryFactory factory) {
        super(factory, PublisherVoExchanger.INSTANCE);
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
    protected PublishersListVo makeListVo(List<PublisherVo> entities) {
        return new PublishersListVo(entities);
    }

}
