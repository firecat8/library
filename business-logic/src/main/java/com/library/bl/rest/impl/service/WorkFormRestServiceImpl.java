package com.library.bl.rest.impl.service;

import com.library.bl.rest.impl.CrudRestServiceImpl;
import com.library.bl.rest.impl.vo.exchanger.WorkFormVoExchanger;
import com.library.dao.DaoRegistry;
import com.library.dao.DaoRegistryFactory;
import com.library.dao.WorkFormDao;
import com.library.domain.book.WorkForm;
import com.library.rest.api.service.WorkFormRestService;
import com.library.rest.api.vo.book.WorkFormVo;
import com.library.rest.api.vo.list.WorkFormsListVo;

/**
 *
 * @author gdimitrova
 */
public class WorkFormRestServiceImpl extends CrudRestServiceImpl<WorkFormDao, WorkFormVo, WorkForm, WorkFormsListVo> implements WorkFormRestService{

    public WorkFormRestServiceImpl(DaoRegistryFactory factory) {
        super(factory,
                WorkFormVoExchanger.INSTANCE,
                WorkFormsListVo::new,
                DaoRegistry::getWorkFormDao);
    }

}
