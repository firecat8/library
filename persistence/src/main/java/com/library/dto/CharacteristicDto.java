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
@Entity(name = "characteristics")
@Table(name = "characteristics")
public class CharacteristicDto extends NamedDto{

    public CharacteristicDto() {
    }

    public CharacteristicDto(String name) {
        super(name);
    }
    
}
