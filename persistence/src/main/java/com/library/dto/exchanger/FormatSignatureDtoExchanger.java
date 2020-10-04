/*
 * Project library
 */
package com.library.dto.exchanger;

import com.library.domain.book.signature.FormatSignature;
import com.library.dto.FormatSignatureDto;

/**
 *
 * @author gdimitrova
 */
public class FormatSignatureDtoExchanger extends DtoEntityExchanger<FormatSignatureDto, FormatSignature> {

    public final static FormatSignatureDtoExchanger INSTANCE = new FormatSignatureDtoExchanger();

    private FormatSignatureDtoExchanger() {
    }

    @Override
    protected FormatSignature exchangeFrom(FormatSignatureDto dto) {
        return new FormatSignature(dto.getAbbreviation(), dto.getName());
    }

    @Override
    protected FormatSignatureDto exchangeFrom(FormatSignature e) {
        return new FormatSignatureDto(e.getAbbreviation(), e.getName());
    }

}
