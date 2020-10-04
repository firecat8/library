package com.library.domain.book.signature;

import com.library.domain.NamedEntity;

/**
 *
 * @author gdimitrova
 */
public abstract class Signature extends NamedEntity {

    private String abbreviation;

    public Signature(String abbreviation, String name) {
        super(name);
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
