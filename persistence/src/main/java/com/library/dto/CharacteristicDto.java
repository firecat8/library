/*
 * Project library
 */
package com.library.dto;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author gdimitrova
 */
@Entity(name = "characteristics")
@Table(name = "characteristics")
public class CharacteristicDto extends NamedDto {

    @ManyToMany(mappedBy = "users")
    private Set<UserDto> users = new HashSet<>();

    public CharacteristicDto() {
    }

    public CharacteristicDto(String name) {
        super(name);
    }

}
