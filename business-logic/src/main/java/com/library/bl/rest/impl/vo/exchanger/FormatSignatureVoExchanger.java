/*
 * Project library
 */
package com.library.bl.rest.impl.vo.exchanger;

import com.library.domain.book.signature.FormatSignature;
import com.library.rest.api.vo.book.signature.FormatSignatureVo;

/**
 *
 * @author gdimitrova
 */
public class FormatSignatureVoExchanger extends VoEntityExchanger<FormatSignatureVo, FormatSignature> {

    public final static FormatSignatureVoExchanger INSTANCE = new FormatSignatureVoExchanger();

    private FormatSignatureVoExchanger() {
    }

    @Override
    protected FormatSignature exchangeFrom(FormatSignatureVo Vo) {
        return new FormatSignature(Vo.getAbbreviation(), Vo.getName());
    }

    @Override
    protected FormatSignatureVo exchangeFrom(FormatSignature e) {
        return new FormatSignatureVo(e.getAbbreviation(), e.getName());
    }

}
