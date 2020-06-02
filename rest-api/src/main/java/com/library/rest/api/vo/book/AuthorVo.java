package com.library.rest.api.vo.book;

import com.library.rest.api.vo.DateVo;
import com.library.rest.api.vo.NamedEntityVo;
import java.util.Objects;

/**
 *
 * @author gdimitrova
 */
public class AuthorVo extends NamedEntityVo {

    private String biography;

    private String birthPlace;

    private DateVo birthDate;

    public AuthorVo() {
    }

    public AuthorVo(String name, String biography, String birthPlace, DateVo birthDate) {
        super(name);
        this.biography = biography;
        this.birthPlace = birthPlace;
        this.birthDate = birthDate;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public DateVo getBirthdate() {
        return birthDate;
    }

    public void setBirthdate(DateVo birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.biography);
        hash = 83 * hash + Objects.hashCode(this.birthPlace);
        hash = 83 * hash + Objects.hashCode(this.birthDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AuthorVo other = (AuthorVo) obj;
        if (!Objects.equals(this.biography, other.biography)) {
            return false;
        }
        if (!Objects.equals(this.birthPlace, other.birthPlace)) {
            return false;
        }
        return Objects.equals(this.birthDate, other.birthDate);
    }
}
