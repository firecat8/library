package com.library.rest.api.request;

import java.util.List;

/**
 *
 * @author gdimitrova
 * @param <T>
 */
public abstract class EntityListRequest<T> {

    private final List<T> entities;

    public EntityListRequest(List<T> entities) {
        this.entities = entities;
    }

    public List<T> getList() {
        return entities;
    }

}
