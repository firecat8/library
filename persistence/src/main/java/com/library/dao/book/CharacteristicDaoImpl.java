/*
 * Project library
 */
package com.library.dao.book;

import com.library.dao.AbstractCrudDao;
import com.library.dao.CharacteristicDao;
import com.library.domain.Characteristic;
import com.library.dto.CharacteristicDto;
import com.library.dto.exchanger.CharacteristicDtoExchanger;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
