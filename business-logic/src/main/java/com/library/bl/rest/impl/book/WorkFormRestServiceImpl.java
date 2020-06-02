package com.library.bl.rest.impl.book;

import com.library.bl.rest.impl.AbstractRestService;
import com.library.bl.rest.impl.vo.exchanger.WorkFormVoExchanger;
import com.library.dao.DaoRegistry;
import com.library.dao.DaoRegistryFactory;
import com.library.dao.WorkFormDao;
import com.library.domain.book.WorkForm;
import com.library.rest.api.book.WorkFormRestService;
import com.library.rest.api.request.WorkFormRequest;
import com.library.rest.api.request.WorkFormsRequest;
import com.library.rest.api.vo.book.WorkFormVo;
import com.library.rest.api.vo.list.WorkFormsListVo;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ws.rs.core.Response;

/**
 *
 * @author gdimitrova
 */
public class WorkFormRestServiceImpl extends AbstractRestService<WorkFormDao, WorkFormVo, WorkForm, WorkFormsListVo> implements WorkFormRestService {

    public WorkFormRestServiceImpl(DaoRegistryFactory factory) {
        super(factory, WorkFormVoExchanger.INSTANCE);
    }

    @Override
    protected WorkFormDao getDao(DaoRegistry registry) {
        return registry.getWorkFormDao();
    }

    @Override
    public Response save(WorkFormRequest request) {
        return this.save(request.getEntity());
    }

    @Override
    public Response update(WorkFormRequest request) {
        return this.update(request.getEntity());
    }

    @Override
    public Response load(Long id) {
        return this.loadById(id);
    }

    @Override
    public Response saveAll(WorkFormsRequest request) {
        return this.saveAll(request.getList());
    }

    @Override
    public Response deleteAll(WorkFormsRequest request) {
        return this.deleteAll(request.getList());
    }

    @Override
    protected Set<String> validate(WorkForm entity) {
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
    protected WorkFormsListVo makeListVo(List<WorkFormVo> entities) {
        return new WorkFormsListVo(entities);
    }

}
