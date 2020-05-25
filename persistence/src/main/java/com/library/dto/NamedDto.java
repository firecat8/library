package com.library.dto;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author gdimitrova
 */
@MappedSuperclass
public abstract class NamedDto extends AbstractDto {

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    public NamedDto() {
        //Hibernate
    }

    public NamedDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
