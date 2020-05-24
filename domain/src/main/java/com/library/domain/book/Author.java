package com.library.domain.book;

import com.library.domain.NamedEntity;
import java.util.Calendar;

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

}
