/*
 * Project library
 */
package com.library.dao.book;

import com.library.dao.AbstractCrudDao;
import com.library.dao.StockSignatureDao;
import com.library.domain.book.signature.StockSignature;
import com.library.dto.StockSignatureDto;
import com.library.dto.exchanger.StockSignatureDtoExchanger;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;

/**
 *
 * @author gdimitrova
 */
public class StockSignatureDaoImpl extends AbstractCrudDao<StockSignatureDto, StockSignature> implements StockSignatureDao {

    public StockSignatureDaoImpl(EntityManager em) {
        super(StockSignatureDto.class, em, StockSignatureDtoExchanger.INSTANCE);
    }

    @Override
    protected Map<String, Object> loadProperties(StockSignatureDto newOne) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", newOne.getName());
        map.put("abbreviation", newOne.getAbbreviation());
        return map;
    }
}
