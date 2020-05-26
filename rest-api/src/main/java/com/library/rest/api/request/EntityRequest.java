package com.library.rest.api.request;

/**
 *
 * @author gdimitrova
 * @param <T>
 */
public abstract class EntityRequest<T> {

    private final T entity;

    public EntityRequest(T entity) {
        this.entity = entity;
    }

    public T getEntity() {
        return entity;
    }

}
