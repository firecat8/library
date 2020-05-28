/*
 * EuroRisk Systems (c) Ltd. All rights reserved.
 */
package com.library.dao;

import com.library.domain.Entity;
import java.util.List;

/**
 *
 * @author gdimitrova
 * @param <E>
 */
public interface CrudDao<E extends Entity> {

    public int update(E entity);

    public E save(E entity);

    public List<E> saveAll(List<E> list);

    public void delete(Long id);

    public void deleteAll(List<E> list);

    public E loadById(Long id);

    public List<E> loadAll();

}
