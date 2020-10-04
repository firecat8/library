package com.library.bl.rest.impl.service;

import com.library.bl.rest.impl.CrudRestServiceImpl;
import com.library.bl.rest.impl.vo.exchanger.FormatSignatureVoExchanger;
import com.library.dao.DaoRegistry;
import com.library.dao.DaoRegistryFactory;
import com.library.dao.FormatSignatureDao;
import com.library.domain.book.signature.FormatSignature;
import com.library.rest.api.service.FormatSignatureRestService;
import com.library.rest.api.vo.book.signature.FormatSignatureVo;
import com.library.rest.api.vo.list.FormatSignaturesListVo;

/**
 *
 * @author gdimitrova
 */
public class FormatSignatureRestServiceImpl extends CrudRestServiceImpl<FormatSignatureDao, FormatSignatureVo, FormatSignature, FormatSignaturesListVo>
        implements FormatSignatureRestService {

    public FormatSignatureRestServiceImpl(DaoRegistryFactory factory) {
        super(factory,
                FormatSignatureVoExchanger.INSTANCE,
                FormatSignaturesListVo::new,
                DaoRegistry::getFormatSignatureDao
        );
    }

}
