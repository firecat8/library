package com.library.dto;

import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author gdimitrova
 */
@Entity(name = "authors")
@Table(name = "authors")
public class AuthorDto extends NamedDto {

    public static final String BIOGRAPHY = "biography";

    public static final String BIRTH_PLACE = "birth_place";

    public static final String BIRTH_DATE = "birth_date";

    public static final String BIOGRAPHY_PROP = BIOGRAPHY;

    public static final String BIRTH_PLACE_PROP = "birthPlace";

    public static final String BIRTH_DATE_PROP = "birthDate";

    @Column(name = BIOGRAPHY)
    private String biography;

    @Column(name = BIRTH_PLACE)
    private String birthPlace;

    @Column(name = BIRTH_DATE)
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar birthDate;

    public AuthorDto() {
        //Hibernate
    }

    public AuthorDto(String name, String biography, String birthPlace, Calendar birthDate) {
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
