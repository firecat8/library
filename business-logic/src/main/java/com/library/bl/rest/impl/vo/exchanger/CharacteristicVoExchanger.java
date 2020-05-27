/*
 * Project library
 */
package com.library.bl.rest.impl.vo.exchanger;

import com.library.domain.book.Characteristic;
import com.library.rest.api.vo.book.CharacteristicVo;

/**
 *
 * @author gdimitrova
 */
public class CharacteristicVoExchanger extends VoEntityExchanger<CharacteristicVo, Characteristic> {

    public final static CharacteristicVoExchanger INSTANCE = new CharacteristicVoExchanger();

    private CharacteristicVoExchanger() {
    }

    @Override
    protected Characteristic exchangeFrom(CharacteristicVo Vo) {
        return new Characteristic(Vo.getName());
    }

    @Override
    protected CharacteristicVo exchangeFrom(Characteristic e) {
        return new CharacteristicVo(e.getName());
    }

}
