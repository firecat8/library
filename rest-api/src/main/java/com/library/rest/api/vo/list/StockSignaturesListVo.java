package com.library.rest.api.vo.list;

import com.library.rest.api.vo.EntityListVo;
import com.library.rest.api.vo.book.signature.StockSignatureVo;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class StockSignaturesListVo extends EntityListVo<StockSignatureVo>{

    public StockSignaturesListVo() {
    }

    public StockSignaturesListVo(List<StockSignatureVo> entities) {
        super(entities);
    }
    
}
