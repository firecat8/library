/*
 * Project library
 */
package com.library.dao.book;

import com.library.dao.AbstractCrudDao;
import com.library.dao.FormatSignatureDao;
import com.library.domain.book.signature.FormatSignature;
import com.library.dto.FormatSignatureDto;
import com.library.dto.exchanger.FormatSignatureDtoExchanger;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;

/**
 *
 * @author gdimitrova
 */
public class FormatSignatureDaoImpl extends AbstractCrudDao<FormatSignatureDto, FormatSignature> implements FormatSignatureDao {

    public FormatSignatureDaoImpl(EntityManager em) {
        super(FormatSignatureDto.class, em, FormatSignatureDtoExchanger.INSTANCE);
    }

    @Override
    protected Map<String, Object> loadProperties(FormatSignatureDto newOne) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", newOne.getName());
        map.put("abbreviation", newOne.getAbbreviation());
        return map;
    }
}
