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

    public void update(E oldOne);

    public void save(E entity);

    public void saveAll(List<E> list);

    public void delete(Long id);

    public void deleteAll(List<E> list);

    public E loadById(Long id);

}
