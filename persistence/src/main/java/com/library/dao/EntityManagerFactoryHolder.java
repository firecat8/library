/*
 * EuroRisk Systems (c) Ltd. All rights reserved.
 */
package com.library.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author gdimitrova
 */
public class EntityManagerFactoryHolder {

    public final static EntityManagerFactory INSTANCE = createFactory();

    private static EntityManagerFactory createFactory() {
        EntityManagerFactory factory = null;
        factory = Persistence.createEntityManagerFactory("com.library");
        return factory;
    }

}
