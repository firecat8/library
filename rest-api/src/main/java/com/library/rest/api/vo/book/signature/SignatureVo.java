package com.library.rest.api.vo.book.signature;

import com.library.rest.api.vo.NamedEntityVo;

/**
 *
 * @author gdimitrova
 */
public abstract class SignatureVo extends NamedEntityVo {

    private String abbreviation;

    public SignatureVo() {
        super();
    }

    public SignatureVo(String abbreviation, String name) {
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
