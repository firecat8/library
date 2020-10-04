/*
 * Project library
 */
package com.library.bl.rest.impl.vo.exchanger;

import com.library.domain.book.signature.StockSignature;
import com.library.rest.api.vo.book.signature.StockSignatureVo;

/**
 *
 * @author gdimitrova
 */
public class StockSignatureVoExchanger extends VoEntityExchanger<StockSignatureVo, StockSignature> {

    public final static StockSignatureVoExchanger INSTANCE = new StockSignatureVoExchanger();

    private StockSignatureVoExchanger() {
    }

    @Override
    protected StockSignature exchangeFrom(StockSignatureVo Vo) {
        return new StockSignature(Vo.getAbbreviation(), Vo.getName());
    }

    @Override
    protected StockSignatureVo exchangeFrom(StockSignature e) {
        return new StockSignatureVo(e.getAbbreviation(), e.getName());
    }

}
