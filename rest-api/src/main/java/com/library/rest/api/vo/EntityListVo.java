package com.library.rest.api.vo;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public abstract class EntityListVo<T> implements Serializable{

    private List<T> entities;

    public EntityListVo() {
    }

    public EntityListVo(List<T> entities) {
        this.entities = entities;
    }

    public List<T> getEntities() {
        return entities;
    }

}
