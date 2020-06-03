package com.library.rest.api.vo;

import java.io.Serializable;

/**
 *
 * @author gdimitrova
 */
public abstract class AbstractVo implements Serializable,Validatable {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
