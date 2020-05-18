/*
 * Project library
 */
package com.library.dto.exchanger;

import com.library.domain.Characteristic;
import com.library.dto.CharacteristicDto;

/**
 *
 * @author gdimitrova
 */
public class CharacteristicDtoExchanger extends DtoEntityExchanger<CharacteristicDto, Characteristic> {

    @Override
    protected Characteristic exchangeFrom(CharacteristicDto dto) {
        return new Characteristic(dto.getName());
    }

    @Override
    protected CharacteristicDto exchangeFrom(Characteristic e) {
        return new CharacteristicDto(e.getName());
    }

}
