package com.library.bl.rest.impl.service;

import com.library.bl.rest.impl.CrudRestServiceImpl;
import com.library.bl.rest.impl.vo.exchanger.CharacteristicVoExchanger;
import com.library.dao.CharacteristicDao;
import com.library.dao.DaoRegistry;
import com.library.dao.DaoRegistryFactory;
import com.library.domain.book.Characteristic;
import com.library.rest.api.service.CharacteristicRestService;
import com.library.rest.api.vo.book.CharacteristicVo;
import com.library.rest.api.vo.list.CharacteristicsListVo;

/**
 *
 * @author gdimitrova
 */
public class CharacteristicRestServiceImpl extends CrudRestServiceImpl<CharacteristicDao, CharacteristicVo, Characteristic, CharacteristicsListVo>
        implements CharacteristicRestService {

    public CharacteristicRestServiceImpl(DaoRegistryFactory factory) {
        super(factory,
                CharacteristicVoExchanger.INSTANCE,
                CharacteristicsListVo::new,
                DaoRegistry::getCharacteristicDao
        );
    }

}
