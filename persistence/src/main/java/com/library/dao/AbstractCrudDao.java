package com.library.dao;

import com.library.domain.Entity;
import com.library.dto.AbstractDto;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.library.domain.exchanger.EntityExchanger;

/**
 *
 * @author gdimitrova
 * @param <D>
 * @param <E>
 */
public abstract class AbstractCrudDao<D extends AbstractDto, E extends Entity> extends AbstractDao<D, E> implements CrudDao<E> {

    protected AbstractCrudDao(Class<D> dtoClass, EntityManager em, EntityExchanger<D, E> exchanger) {
        super(dtoClass, em, exchanger);
    }

    @Override
    public E save(E entity) {
        return save(exchanger.exchange(entity));
    }

    @Override
    public List<E> saveAll(List<E> list) {
        return saveOrUpdateAll(exchanger.exchangeEntityList(list));
    }

    @Override
    public int update(E e) {
        return super.update(exchanger.exchange(e), new HashMap<>());
    }

    @Override
    public void delete(Long id) {
        CriteriaBuilder cb = getCriteriaBuilder();
        CriteriaDelete<D> delete = cb.createCriteriaDelete(dtoClassName);
        Root<D> root = delete.from(dtoClassName);
        delete.where(cb.equal(root.get("id"), id));
        em.createQuery(delete).executeUpdate();
    }

    @Override
    public void deleteAll(List<E> list) {
        list.forEach((e) -> {
            delete(e.getId());
//            em.remove(e);
        });
    }

    @Override
    public E loadById(Long id) {
        return getResult("id", id);
    }

    @Override
    public List<E> loadAll() {
        CriteriaBuilder cb = getCriteriaBuilder();
        CriteriaQuery<D> query = cb.createQuery(dtoClassName);
        query.select(query.from(dtoClassName));
        return exchangeResults(em.createQuery(query).getResultList());
    }

    protected void persistEntity(D entity) {
        em.persist(entity);
    }

    protected List<E> saveOrUpdateAll(List<D> entities) {
        entities.forEach((e) -> {
            saveOrUpdate(e);
        });
        return exchanger.exchangeList(entities);
    }

    protected void mergeEntity(D entity) {
        em.merge(entity);
    }

    protected Long saveOrUpdate(D entity) {
        if (entity.getId() == null) {
            persistEntity(entity);
            return entity.getId();
        }
        if (entity.getId() != null || entity.getId() > 0) {
            mergeEntity(entity);
            return entity.getId();
        }
        persistEntity(entity);
        return entity.getId();
    }

    public E save(D entity) {
        saveOrUpdate(entity);
        return exchanger.exchange(entity);
    }
}
