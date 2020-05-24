/*
 * Project library
 */
package com.library.dto;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author gdimitrova
 */
@Entity(name = "publishers")
@Table(name = "publishers")
public class PublisherDto extends NamedDto{
    
    public PublisherDto() {
       //Hibernate
    }
    
    public PublisherDto(String name) {
        super(name);
    }
}

