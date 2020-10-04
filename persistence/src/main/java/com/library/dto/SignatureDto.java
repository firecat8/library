/*
 * Project library
 */
package com.library.dto;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author gdimitrova
 */
@MappedSuperclass
public abstract class SignatureDto extends NamedDto {
    
    @Column(name = "abbreviation", unique = true, nullable = false)
    private String abbreviation;

    public SignatureDto() {
        //Hibernate
    }

    public SignatureDto(String abbreviation, String name) {
        super(name);
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
    
    
}

