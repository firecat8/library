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
@Entity(name = "book_series")
@Table(name = "book_series")
public class BookSerieDto extends NamedDto{

    public BookSerieDto() {
    }

    public BookSerieDto(String name) {
        super(name);
    }
    
}
