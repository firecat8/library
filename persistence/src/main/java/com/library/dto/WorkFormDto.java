package com.library.dto;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author gdimitrova
 */
@Entity(name = "work_forms")
@Table(name = "work_forms")
public class WorkFormDto extends NamedDto{

    public WorkFormDto() {
       //Hibernate
    }
    
    public WorkFormDto(String name) {
        super(name);
    }
    
}
