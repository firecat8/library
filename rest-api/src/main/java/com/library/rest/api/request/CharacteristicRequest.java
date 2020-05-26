package com.library.rest.api.request;

import com.library.domain.book.Characteristic;

/**
 *
 * @author gdimitrova
 */
public class CharacteristicRequest extends EntityRequest<Characteristic> {

    public CharacteristicRequest(Characteristic entity) {
        super(entity);
    }

}
