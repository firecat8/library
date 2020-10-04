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
@Entity(name = "stock_signatures")
@Table(name = "stock_signatures")
public class StockSignatureDto extends SignatureDto {

    public StockSignatureDto() {
        //Hibernate
    }

    public StockSignatureDto(String abbreviation, String name) {
        super(abbreviation, name);
    }

}
