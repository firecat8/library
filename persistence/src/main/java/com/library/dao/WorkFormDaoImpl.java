/*
 * Project library
 */
package com.library.dao;

import com.library.domain.Entity;
import com.library.domain.WorkForm;
import com.library.domain.exchanger.DtoEntityExchanger;
import com.library.dto.WorkFormDto;
import java.util.Map;
import javax.persistence.EntityManager;

/**
 *
 * @author gdimitrova
 */
public class WorkFormDaoImpl extends AbstractCrudDao<WorkFormDto, WorkForm> {

    public WorkFormDaoImpl(Class<WorkFormDto> dtoClass, EntityManager em, DtoEntityExchanger<WorkFormDto, WorkForm> exchanger) {
        super(dtoClass, em, exchanger);
    }

    @Override
    protected Map<String, Object> loadProperties(WorkFormDto newOne) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
