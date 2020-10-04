package com.library.bl.rest.impl.service;

import com.library.bl.rest.impl.CrudRestServiceImpl;
import com.library.bl.rest.impl.vo.exchanger.StockSignatureVoExchanger;
import com.library.dao.DaoRegistry;
import com.library.dao.DaoRegistryFactory;
import com.library.dao.StockSignatureDao;
import com.library.domain.book.signature.StockSignature;
import com.library.rest.api.service.StockSignatureRestService;
import com.library.rest.api.vo.book.signature.StockSignatureVo;
import com.library.rest.api.vo.list.StockSignaturesListVo;

/**
 *
 * @author gdimitrova
 */
public class StockSignatureRestServiceImpl extends CrudRestServiceImpl<StockSignatureDao, StockSignatureVo, StockSignature, StockSignaturesListVo>
        implements StockSignatureRestService {

    public StockSignatureRestServiceImpl(DaoRegistryFactory factory) {
        super(factory,
                StockSignatureVoExchanger.INSTANCE,
                StockSignaturesListVo::new,
                DaoRegistry::getStockSignatureDao
        );
    }

}
