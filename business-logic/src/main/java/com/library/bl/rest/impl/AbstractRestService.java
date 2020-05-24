package com.library.bl.rest.impl;

import com.library.dao.CrudDao;
import com.library.dao.DaoRegistry;
import com.library.domain.Entity;
import com.library.rest.api.response.SuccessResponse;
import java.util.List;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Response;

/**
 *
 * @author gdimitrova
 * @param <Dao>
 */
public abstract class AbstractRestService<Dao extends CrudDao, E extends Entity> {

    private static final Logger LOGGER = Logger.getLogger(AbstractRestService.class.getName());

    protected final DaoRegistry daoRegistry;

    public AbstractRestService(DaoRegistry daoRegistry) {
        this.daoRegistry = daoRegistry;
    }

    protected synchronized final Response doInTransaction(Supplier< Response> work) {
        try {
            daoRegistry.beginTransaction();
            Response resp = work.get();
            daoRegistry.commitTransaction();
            return resp;
        } catch (Exception ex) {
            daoRegistry.rollbackTransaction();
            LOGGER.log(Level.SEVERE, ex.getMessage());
            return null;
        }
    }

    public Response update(E oldOne) {
        return doInTransaction(() -> {
            getDao().update(oldOne);
            return Response.ok(new SuccessResponse()).build();
        });
    }

    public Response save(E entity) {
        return doInTransaction(() -> {
            getDao().save(entity);
            return Response.ok(new SuccessResponse()).build();
        });
    }

    public Response delete(Long id) {
        return doInTransaction(() -> {
            getDao().delete(id);
            return Response.ok(new SuccessResponse()).build();
        });
    }

    public Response deleteAll(List<E> list) {
        return doInTransaction(() -> {
            getDao().deleteAll(list);
            return Response.ok(new SuccessResponse()).build();
        });
    }

    public Response loadById(Long id) {
        return doInTransaction(() -> {
            Entity loaded = getDao().loadById(id);
            return Response.ok(loaded).build();
        });
    }

    protected abstract Dao getDao();
}
