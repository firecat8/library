package com.library.domain.ddc;

/**
 *
 * @author gdimitrova
 */
public class DeweyClassSection {

    private final String code;

    private final String name;

    public DeweyClassSection(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

}
