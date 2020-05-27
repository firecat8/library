package com.library.rest.api.request;

import com.library.rest.api.vo.book.CharacteristicVo;

/**
 *
 * @author gdimitrova
 */
public class CharacteristicRequest extends EntityRequest<CharacteristicVo> {

    public CharacteristicRequest(CharacteristicVo entity) {
        super(entity);
    }

}
