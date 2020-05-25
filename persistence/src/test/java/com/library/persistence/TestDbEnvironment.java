/*
 * EuroRisk Systems (c) Ltd. All rights reserved.
 */
package com.library.persistence;

import com.library.dao.AbstractDao;
import com.library.dao.DaoRegistry;
import com.library.dao.DaoRegistryFactory;
import com.library.dao.DaoRegistryFactoryImpl;
import com.library.dao.DaoRegistryImpl;
import com.library.dao.EntityManagerFactoryHolder;
import com.library.domain.Entity;
import com.library.dto.AbstractDto;
import com.library.dto.AuthorDto;
import com.library.dto.BookSerieDto;
import com.library.dto.CharacteristicDto;
import com.library.dto.GenreDto;
import com.library.dto.PublisherDto;
import com.library.dto.WorkFormDto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Table;
import junit.framework.TestCase;

/**
 *
 * @author gdimitrova
 * @param <D>
 * @param <E>
 * @param <Dao>
 */
public class TestDbEnvironment implements DaoRegistryFactory{

    private EntityManagerFactory emFactory;
    private DaoRegistryFactory daoRegistryFactory;
    private List<DaoRegistry> openedDaoRegistries = new ArrayList<>();

    public void setUp() {
        emFactory = EntityManagerFactoryHolder.INSTANCE;
        daoRegistryFactory = new DaoRegistryFactoryImpl(emFactory);
        clearDB();
    }

    public void destroy() throws Exception {
        for (DaoRegistry registry : openedDaoRegistries) {
            try {
                registry.close();
            }
            catch (Throwable th) {
                // log
            }
        }
        openedDaoRegistries.clear();
    }

    @Override
    public DaoRegistry makeDaoRegistry() {
        DaoRegistry registry = daoRegistryFactory.makeDaoRegistry();
        openedDaoRegistries.add(registry);
        return registry;
    }
    

    private void clearDB() {
        EntityManager em = emFactory.createEntityManager();
        try {
            em.getTransaction().begin();
            removeRows(em, resolveTableName(AuthorDto.class));
            removeRows(em, resolveTableName(BookSerieDto.class));
            removeRows(em, resolveTableName(CharacteristicDto.class));
            removeRows(em, resolveTableName(GenreDto.class));
            removeRows(em, resolveTableName(PublisherDto.class));
            removeRows(em, resolveTableName(WorkFormDto.class));
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("\n" + e.getMessage() + "\n");
            if (em.getTransaction() != null) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
    }

    private void removeRows(EntityManager em, String entityName) {
        em.createQuery("delete FROM " + entityName).executeUpdate();
    }

    private String resolveTableName(Class<?> dtoClass) {
        Table t = dtoClass.getAnnotation(Table.class);
        return t == null ? dtoClass.getSimpleName() : t.name();
    }
}
