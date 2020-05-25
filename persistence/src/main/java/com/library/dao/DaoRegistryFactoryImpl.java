/*
 * Project library
 */
package com.library.dao;

import javax.persistence.EntityManagerFactory;

/**
 *
 * @author gdimitrova
 */
public class DaoRegistryFactoryImpl implements DaoRegistryFactory {

    private final EntityManagerFactory factory;

    public DaoRegistryFactoryImpl(EntityManagerFactory factory) {
        this.factory = factory;
    }
    

    @Override
    public DaoRegistry makeDaoRegistry() {
        return new DaoRegistryImpl(factory.createEntityManager());
    }

}
