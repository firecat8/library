/*
 * EuroRisk Systems (c) Ltd. All rights reserved.
 */
package com.library.persistence;

import com.library.dao.DaoRegistry;
import com.library.dao.DaoRegistryFactory;
import com.library.dao.DaoRegistryFactoryImpl;
import com.library.dto.AuthorDto;
import com.library.dto.BookDto;
import com.library.dto.BookRentalDto;
import com.library.dto.BookSerieDto;
import com.library.dto.CharacteristicDto;
import com.library.dto.FormatSignatureDto;
import com.library.dto.GenreDto;
import com.library.dto.PublisherDto;
import com.library.dto.StockSignatureDto;
import com.library.dto.UserDto;
import com.library.dto.WorkFormDto;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Table;

/**
 *
 * @author gdimitrova
 */
public class TestDbEnvironment implements DaoRegistryFactory {

    private final static Logger LOGGER = Logger.getLogger(TestDbEnvironment.class.getName());

    private EntityManagerFactory emFactory;

    private DaoRegistryFactory daoRegistryFactory;

    private final List<DaoRegistry> openedDaoRegistries = new ArrayList<>();

    public void setUp() {
        if (emFactory == null) {
            emFactory = createFactory();
        }
        daoRegistryFactory = new DaoRegistryFactoryImpl(emFactory);
        clearDB();
    }

    public void destroy() throws Exception {
        for (DaoRegistry registry : openedDaoRegistries) {
            try {
                registry.close();
            } catch (Throwable th) {
                LOGGER.log(Level.SEVERE, th.getMessage());
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
            removeRows(em, resolveTableName(BookRentalDto.class));
            removeRows(em, resolveTableName(BookDto.class));
            removeRows(em, resolveTableName(AuthorDto.class));
            removeRows(em, resolveTableName(BookSerieDto.class));
            removeRows(em, resolveTableName(CharacteristicDto.class));
            removeRows(em, resolveTableName(GenreDto.class));
            removeRows(em, resolveTableName(PublisherDto.class));
            removeRows(em, resolveTableName(UserDto.class));
            removeRows(em, resolveTableName(WorkFormDto.class));
            removeRows(em, resolveTableName(StockSignatureDto.class));
            removeRows(em, resolveTableName(FormatSignatureDto.class));
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

    private EntityManagerFactory createFactory() {
        return Persistence.createEntityManagerFactory("com.library");
    }
}
