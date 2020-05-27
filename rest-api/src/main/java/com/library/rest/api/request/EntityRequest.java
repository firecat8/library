package com.library.rest.api.request;

import java.io.Serializable;

/**
 *
 * @author gdimitrova
 * @param <T>
 */
public abstract class EntityRequest<T> implements Serializable{

    private final T entity;

    public EntityRequest(T entity) {
        this.entity = entity;
    }

    public T getEntity() {
        return entity;
    }

}
