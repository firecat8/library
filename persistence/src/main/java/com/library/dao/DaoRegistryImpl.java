package com.library.dao;

import javax.persistence.EntityManager;

/**
 *
 * @author gdimitrova
 */
public class DaoRegistryImpl implements DaoRegistry {

    private final EntityManager em;

   // private final UserDao userDao;

    public DaoRegistryImpl(EntityManager em) {
        this.em = em;
       // userDao = new UserDaoImpl(em);
    }

    public DaoRegistryImpl() {
        this(EntityManagerFactoryHolder.FACTORY.createEntityManager());
    }

//    @Override
//    public UserDao getUserDao() {
//        return userDao;
//    }


    @Override
    public void beginTransaction() {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
    }

    @Override
    public void rollbackTransaction() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void commitTransaction() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().commit();
        }
    }

}
