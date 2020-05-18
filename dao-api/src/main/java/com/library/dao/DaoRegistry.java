package com.library.dao;

/**
 *
 * @author gdimitrova
 */
public interface DaoRegistry {

    public void beginTransaction();

    public void rollbackTransaction();

    public void commitTransaction();
}
