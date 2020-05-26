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
@Entity(name = "genres")
@Table(name = "genres")
public class GenreDto extends NamedDto {

    @ManyToMany(mappedBy = "genres")
    private Set<BookDto> books = new HashSet<>();

    public GenreDto() {
    }

    public GenreDto(String name) {
        super(name);
    }

}
