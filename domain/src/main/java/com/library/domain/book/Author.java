package com.library.domain.book;

import com.library.domain.NamedEntity;
import java.util.Calendar;
import java.util.Objects;

/**
 *
 * @author gdimitrova
 */
public class Author extends NamedEntity {

    private String biography;

    private String birthPlace;

    private Calendar birthDate;

    public Author(String name, String biography, String birthPlace, Calendar birthDate) {
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

    public Calendar getBirthdate() {
        return birthDate;
    }

    public void setBirthdate(Calendar birthDate) {
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
        final Author other = (Author) obj;
        if (!Objects.equals(this.biography, other.biography)) {
            return false;
        }
        if (!Objects.equals(this.birthPlace, other.birthPlace)) {
            return false;
        }
        return Objects.equals(this.birthDate, other.birthDate);
    }
}
