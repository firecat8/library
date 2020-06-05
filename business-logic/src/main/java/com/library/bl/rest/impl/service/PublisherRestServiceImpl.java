package com.library.bl.rest.impl.service;

import com.library.bl.rest.impl.CrudRestServiceImpl;
import com.library.bl.rest.impl.vo.exchanger.PublisherVoExchanger;
import com.library.dao.DaoRegistry;
import com.library.dao.DaoRegistryFactory;
import com.library.dao.PublisherDao;
import com.library.domain.book.Publisher;
import com.library.rest.api.service.PublisherRestService;
import com.library.rest.api.vo.book.PublisherVo;
import com.library.rest.api.vo.list.PublishersListVo;

/**
 *
 * @author gdimitrova
 */
public class PublisherRestServiceImpl extends CrudRestServiceImpl<PublisherDao, PublisherVo, Publisher, PublishersListVo>
        implements PublisherRestService {

    public PublisherRestServiceImpl(DaoRegistryFactory factory) {
        super(factory,
                PublisherVoExchanger.INSTANCE,
                PublishersListVo::new,
                DaoRegistry::getPublisherDao
        );
    }

}
