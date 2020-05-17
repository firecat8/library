package com.library.dto;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author gdimitrova
 */
@Entity(name = "genres")
@Table(name = "genres")
public class GenreDto extends NamedDto{

    public GenreDto() {
    }

    public GenreDto(String name) {
        super(name);
    }
    
}
