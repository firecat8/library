package com.library.rest.api.vo.list;

import com.library.rest.api.vo.EntityListVo;
import com.library.rest.api.vo.book.CharacteristicVo;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class CharacteristicsListVo  extends EntityListVo<CharacteristicVo>{

    public CharacteristicsListVo() {
    }

    public CharacteristicsListVo(List<CharacteristicVo> entities) {
        super(entities);
    }
    
}
