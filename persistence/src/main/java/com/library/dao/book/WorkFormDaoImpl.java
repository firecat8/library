/*
 * Project library
 */
package com.library.dao.book;

import com.library.dao.AbstractCrudDao;
import com.library.dao.WorkFormDao;
import com.library.domain.book.WorkForm;
import com.library.dto.WorkFormDto;
import com.library.dto.exchanger.WorkFormDtoExchanger;
import java.util.Map;
import javax.persistence.EntityManager;

/**
 *
 * @author gdimitrova
 */
public class WorkFormDaoImpl extends AbstractCrudDao<WorkFormDto, WorkForm> implements WorkFormDao {

    public WorkFormDaoImpl(EntityManager em) {
        super(WorkFormDto.class, em, WorkFormDtoExchanger.INSTANCE);
    }

    @Override
    protected Map<String, Object> loadProperties(WorkFormDto newOne) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
