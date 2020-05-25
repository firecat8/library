package com.library.dto;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author gdimitrova
 */
@MappedSuperclass
public abstract class AbstractDto implements Serializable {

    @Id
    @GeneratedValue(generator = "id")
    @GenericGenerator(name = "id", strategy = "increment")
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
