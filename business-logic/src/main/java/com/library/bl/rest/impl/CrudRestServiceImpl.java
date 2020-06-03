package com.library.bl.rest.impl;

import com.library.bl.rest.impl.vo.exchanger.VoEntityExchanger;
import com.library.dao.CrudDao;
import com.library.dao.DaoRegistry;
import com.library.dao.DaoRegistryFactory;
import com.library.domain.Entity;
import com.library.rest.api.CrudRestService;
import com.library.rest.api.response.SuccessResponse;
import com.library.rest.api.vo.AbstractVo;
import com.library.rest.api.vo.EntityListVo;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.ws.rs.core.Response;

/**
 *
 * @author gdimitrova
 * @param <Dao>
 * @param <Vo>
 * @param <E>
 * @param <ListVo>
 */
public class CrudRestServiceImpl<
        Dao extends CrudDao,
        Vo extends AbstractVo,
        E extends Entity,
        ListVo extends EntityListVo> 
        implements CrudRestService<Vo,ListVo> {

    private static final Logger LOGGER = Logger.getLogger(CrudRestServiceImpl.class.getName());

    private final DaoRegistryFactory factory;
    protected final VoEntityExchanger<Vo, E> exchanger;
    
    private final Function<List<Vo>, ListVo> listVoFactory;
    private final Function<DaoRegistry, CrudDao<E>> daoGetter;

    public CrudRestServiceImpl(DaoRegistryFactory factory, VoEntityExchanger<Vo, E> exchanger, Function<List<Vo>, ListVo> listVoFactory, Function<DaoRegistry, CrudDao<E>> daoGetter) {
        this.factory = factory;
        this.exchanger = exchanger;
        this.listVoFactory = listVoFactory;
        this.daoGetter = daoGetter;
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
    @Override
    public Response save(Vo vo) {
        Set<String> errors = validate(vo);
        if (!errors.isEmpty()) {
            return buildResponse(ErrorCode.VALIDATION, errors);
        }
        E entity = exchanger.exchange(vo);
        return doInTransaction((daoRegistry) -> {
            Entity saved = getDao(daoRegistry).save(entity);
            return Response.ok(saved).build();
        });
    }

    @Override
    public Response update(Vo vo) {
        Set<String> errors = validate(vo);
        if (!errors.isEmpty()) {
            return buildResponse(ErrorCode.VALIDATION, errors);
        }
        E entity = exchanger.exchange(vo);
        return doInTransaction((daoRegistry) -> {
            getDao(daoRegistry).update(entity);
            return Response.ok(new SuccessResponse()).build();
        });
    }

    @Override
    public Response load(Long id) {
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

    @Override
    public Response loadAll() {
        return doInTransaction((daoRegistry) -> {
            List<E> entities = getDao(daoRegistry).loadAll();
            return Response.ok(listVoFactory.apply(exchanger.exchangeEntityList(entities))).build();
        });
    }

    @Override
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

    @Override
    public Response saveAll(ListVo listVo) {
        List<Vo> vos = listVo.getEntities();
        Set<String> errors = validate(vos);
        if (!errors.isEmpty()) {
            return buildResponse(ErrorCode.VALIDATION, errors);
        }
        List<E> list = exchanger.exchangeList(vos);
        return doInTransaction((daoRegistry) -> {
            getDao(daoRegistry).saveAll(list);
            return Response.ok(new SuccessResponse()).build();
        });
    }

    @Override
    public Response deleteAll(ListVo listVo) {
        List<Vo> vos = listVo.getEntities();
        Set<String> errors = validate(vos);
        List<Vo> entities = vos.stream().filter((e) -> {
            return e.getId() == null;
        }).collect(Collectors.toList());
        if (!entities.isEmpty()) {
            errors.add("The list contains entities with null id.");
        }
        if (!errors.isEmpty()) {
            return buildResponse(ErrorCode.VALIDATION, errors);
        }
        List<E> list = exchanger.exchangeList(vos);
        return doInTransaction((daoRegistry) -> {
            getDao(daoRegistry).deleteAll(list);
            return Response.ok(new SuccessResponse()).build();
        });
    }

    protected Response buildResponse(ErrorCode code, Set<String> errors) {
        switch (code) {
            case INTERNAL_ERROR:
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errors).build();

            case NOT_FOUND:
                return Response.status(Response.Status.NOT_FOUND).entity(errors).build();

            case VALIDATION:
                return Response.status(Response.Status.BAD_REQUEST).entity(errors).build();
        }
        return Response.ok(new SuccessResponse()).build();
    }

    protected CrudDao<E> getDao(DaoRegistry registry) {
        return daoGetter.apply(registry);
    }

    protected Set<String> validate(List<Vo> entities) {
        Set<String> errors = new HashSet<>();
        entities.forEach((e) -> {
            errors.addAll(validate(e));
        });
        return errors;
    }
    
    protected Set<String> validate(Vo entity) {
        return entity.validate();
    }
}
