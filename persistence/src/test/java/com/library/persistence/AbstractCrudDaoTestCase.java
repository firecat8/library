/*
 * EuroRisk Systems (c) Ltd. All rights reserved.
 */
package com.library.persistence;

import com.library.dao.AbstractCrudDao;
import com.library.dao.DaoRegistry;
import com.library.domain.Entity;
import com.library.dto.AbstractDto;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author gdimitrova
 * @param <D>
 * @param <E>
 * @param <Dao>
 */
public abstract class AbstractCrudDaoTestCase<D extends AbstractDto, E extends Entity, Dao extends AbstractCrudDao<D, E>> extends TestCase {

    private TestDbEnvironment dbEnvironment = new TestDbEnvironment();

    @Override
    protected void tearDown() throws Exception {
        dbEnvironment.destroy();

        super.tearDown();
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        dbEnvironment.setUp();

        if (!isRequiredDbDataPreparation()) {
            return;
        }

        try (DaoRegistry daoRegistry = dbEnvironment.makeDaoRegistry()) {
            daoRegistry.beginTransaction();
            prepareDbData(daoRegistry);
            daoRegistry.commitTransaction();
        }
    }

    public void testSave() throws Exception {
        try (DaoRegistry daoRegistry = dbEnvironment.makeDaoRegistry()) {
            daoRegistry.beginTransaction();
            getDao(daoRegistry).save(createEntity());
            daoRegistry.commitTransaction();
        }
    }

    public void testSaveAll() throws Exception {
        try (DaoRegistry daoRegistry = dbEnvironment.makeDaoRegistry()) {
            daoRegistry.beginTransaction();
            getDao(daoRegistry).saveAll(createEntities());
            daoRegistry.commitTransaction();
        }
    }

    public void testLoadById() throws Exception {
        try (DaoRegistry daoRegistry = dbEnvironment.makeDaoRegistry()) {
            daoRegistry.beginTransaction();
            Dao dao = getDao(daoRegistry);
            E expected = dao.save(createEntity());
            E actual = dao.loadById(expected.getId());
            daoRegistry.commitTransaction();
            assertEquals(expected, actual);
        }
    }

    public void testDelete() throws Exception {
        try (DaoRegistry daoRegistry = dbEnvironment.makeDaoRegistry()) {
            daoRegistry.beginTransaction();
            Dao dao = getDao(daoRegistry);
            E expected = dao.save(createEntity());
            dao.delete(expected.getId());
            E actual = dao.loadById(expected.getId());
            daoRegistry.commitTransaction();
            assertNull(actual);
        }
    }

    public void testLoadByIdNotFound() throws Exception {
        try (DaoRegistry daoRegistry = dbEnvironment.makeDaoRegistry()) {
            daoRegistry.beginTransaction();
            E actual = getDao(daoRegistry).loadById(100000L);
            daoRegistry.commitTransaction();
            assertNull(actual);
        }
    }

    abstract protected Dao getDao(DaoRegistry registry);

    abstract protected E createEntity();

    abstract protected List<E> createEntities();

    abstract protected boolean isRequiredDbDataPreparation();

    abstract protected void prepareDbData(DaoRegistry registry);
}
