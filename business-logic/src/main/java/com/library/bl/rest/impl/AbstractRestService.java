package com.library.bl.rest.impl;

import com.library.dao.CrudDao;
import com.library.dao.DaoRegistry;
import com.library.dao.DaoRegistryFactory;
import com.library.domain.Entity;
import com.library.rest.api.response.SuccessResponse;
import java.util.List;
import java.util.function.Function;
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

    protected final DaoRegistryFactory factory;

    public AbstractRestService(DaoRegistryFactory factory) {
        this.factory = factory;
    }

    protected synchronized final Response doInTransaction(Function<DaoRegistry, Response> work) {
        try (DaoRegistry daoRegistry = factory.makeDaoRegistry();) {
            daoRegistry.beginTransaction();
            Response resp = work.apply(daoRegistry);
            daoRegistry.commitTransaction();
            return resp;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
            return null;
        }
    }

    public Response update(E oldOne) {
        return doInTransaction((daoRegistry) -> {
            getDao(daoRegistry).update(oldOne);
            return Response.ok(new SuccessResponse()).build();
        });
    }

    public Response save(E entity) {
        return doInTransaction((daoRegistry) -> {
            getDao(daoRegistry).save(entity);
            return Response.ok(new SuccessResponse()).build();
        });
    }

    public Response delete(Long id) {
        return doInTransaction((daoRegistry) -> {
            getDao(daoRegistry).delete(id);
            return Response.ok(new SuccessResponse()).build();
        });
    }

    public Response deleteAll(List<E> list) {
        return doInTransaction((daoRegistry) -> {
            getDao(daoRegistry).deleteAll(list);
            return Response.ok(new SuccessResponse()).build();
        });
    }

    public Response loadById(Long id) {
        return doInTransaction((daoRegistry) -> {
            Entity loaded = getDao(daoRegistry).loadById(id);
            return Response.ok(loaded).build();
        });
    }

    protected abstract Dao getDao(DaoRegistry registry);
}
