/*
 * Project library
 */
package com.library.dao.book;

import com.library.dao.AbstractCrudDao;
import com.library.dao.CharacteristicDao;
import com.library.domain.book.Characteristic;
import com.library.dto.CharacteristicDto;
import com.library.dto.exchanger.CharacteristicDtoExchanger;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;

/**
 *
 * @author gdimitrova
 */
public class CharacteristicDaoImpl extends AbstractCrudDao<CharacteristicDto, Characteristic> implements CharacteristicDao {

    public CharacteristicDaoImpl(EntityManager em) {
        super(CharacteristicDto.class, em, CharacteristicDtoExchanger.INSTANCE);
    }

    @Override
    protected Map<String, Object> loadProperties(CharacteristicDto newOne) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", newOne.getName());
        return map;
    }

}
