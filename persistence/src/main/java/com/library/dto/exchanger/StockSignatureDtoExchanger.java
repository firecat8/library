/*
 * Project library
 */
package com.library.dto.exchanger;

import com.library.domain.book.signature.StockSignature;
import com.library.dto.StockSignatureDto;

/**
 *
 * @author gdimitrova
 */
public class StockSignatureDtoExchanger extends DtoEntityExchanger<StockSignatureDto, StockSignature> {

    public final static StockSignatureDtoExchanger INSTANCE = new StockSignatureDtoExchanger();

    private StockSignatureDtoExchanger() {
    }

    @Override
    protected StockSignature exchangeFrom(StockSignatureDto dto) {
        return new StockSignature(dto.getAbbreviation(), dto.getName());
    }

    @Override
    protected StockSignatureDto exchangeFrom(StockSignature e) {
        return new StockSignatureDto(e.getAbbreviation(), e.getName());
    }

}
