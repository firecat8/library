package com.library.bl.rest.impl;

import com.library.dao.CrudDao;
import com.library.dao.DaoRegistry;
import com.library.dao.DaoRegistryFactory;
import com.library.domain.Entity;
import com.library.rest.api.response.SuccessResponse;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

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
            Set<String> errors = new HashSet<>();
            errors.add(ex.getMessage());
            return buildResponse(ErrorCode.INTERNAL_ERROR, errors);
        }
    }

    public Response save(E entity) {
        Set<String> errors = validate(entity);
        if (!errors.isEmpty()) {
            return buildResponse(ErrorCode.VALIDATION, errors);
        }
        return doInTransaction((daoRegistry) -> {
            getDao(daoRegistry).save(entity);
            return Response.ok(new SuccessResponse()).build();
        });
    }

    public Response update(E entity) {
        Set<String> errors = validate(entity);
        if (!errors.isEmpty()) {
            return buildResponse(ErrorCode.VALIDATION, errors);
        }
        return doInTransaction((daoRegistry) -> {
            getDao(daoRegistry).update(entity);
            return Response.ok(new SuccessResponse()).build();
        });
    }

    public Response delete(Long id) {
        if (id == null) {
            Set<String> errors = new HashSet<>();
            errors.add("Not valid id, Id is null ");
            return buildResponse(ErrorCode.VALIDATION, errors);
        }
        return doInTransaction((daoRegistry) -> {
            getDao(daoRegistry).delete(id);
            return Response.ok(new SuccessResponse()).build();
        });
    }

    public Response saveAll(List<E> list) {
        Set<String> errors = validate(list);
        if (!errors.isEmpty()) {
            return buildResponse(ErrorCode.VALIDATION, errors);
        }
        return doInTransaction((daoRegistry) -> {
            getDao(daoRegistry).saveAll(list);
            return Response.ok(new SuccessResponse()).build();
        });
    }

    public Response deleteAll(List<E> list) {
        Set<String> errors = validate(list);
        List<E> entities = list.stream().filter((e) -> {
            return e.getId() == null;
        }).collect(Collectors.toList());
        if (!entities.isEmpty()) {
            errors.add("The list contains entities with null id.");
        }
        if (!errors.isEmpty()) {
            return buildResponse(ErrorCode.VALIDATION, errors);
        }
        return doInTransaction((daoRegistry) -> {
            getDao(daoRegistry).deleteAll(list);
            return Response.ok(new SuccessResponse()).build();
        });
    }

    public Response loadById(Long id) {
        if (id == null) {
            Set<String> errors = new HashSet<>();
            errors.add("Not valid id, Id is null ");
            return buildResponse(ErrorCode.VALIDATION, errors);
        }
        return doInTransaction((daoRegistry) -> {
            Entity loaded = getDao(daoRegistry).loadById(id);
            return Response.ok(loaded).build();
        });
    }

    protected Response buildResponse(ErrorCode code, Set<String> errors) {
        switch (code) {
            case INTERNAL_ERROR:
                return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errors).build();

            case NOT_FOUND:
                return Response.status(Status.NOT_FOUND).entity(errors).build();

            case VALIDATION:
                return Response.status(Status.BAD_REQUEST).entity(errors).build();
        }
        return Response.ok(new SuccessResponse()).build();
    }

    protected Set<String> validate(List<E> entities) {
        Set<String> errors = new HashSet<>();
        entities.forEach((e) -> {
            errors.addAll(validate(e));
        });
        return errors;
    }

    protected abstract Dao getDao(DaoRegistry registry);

    protected abstract Set<String> validate(E entity);

}
