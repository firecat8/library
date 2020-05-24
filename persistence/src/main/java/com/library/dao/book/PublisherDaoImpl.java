/*
 * Project library
 */
package com.library.dao.book;

import com.library.dao.AbstractCrudDao;
import com.library.dao.PublisherDao;
import com.library.domain.book.Publisher;
import com.library.dto.PublisherDto;
import com.library.dto.exchanger.PublisherDtoExchanger;
import java.util.Map;
import javax.persistence.EntityManager;

/**
 *
 * @author gdimitrova
 */
public class PublisherDaoImpl extends AbstractCrudDao<PublisherDto, Publisher> implements PublisherDao {

    public PublisherDaoImpl(EntityManager em) {
        super(PublisherDto.class, em, PublisherDtoExchanger.INSTANCE);
    }

    @Override
    protected Map<String, Object> loadProperties(PublisherDto newOne) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
