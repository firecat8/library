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
@Entity(name = "format_signatures")
@Table(name = "format_signatures")
public class FormatSignatureDto extends SignatureDto{

    public FormatSignatureDto() {
        //Hibernate
    }

    public FormatSignatureDto(String abbreviation, String name) {
        super(abbreviation, name);
    }
    
}
