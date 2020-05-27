package com.library.rest.api.request;

import com.library.rest.api.vo.book.CharacteristicVo;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class CharacteristicsRequest extends EntityListRequest<CharacteristicVo> {

    public CharacteristicsRequest(List<CharacteristicVo> entities) {
        super(entities);
    }

}
