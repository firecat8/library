package com.library.rest.api.vo.list;

import com.library.rest.api.vo.EntityListVo;
import com.library.rest.api.vo.book.signature.FormatSignatureVo;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class FormatSignaturesListVo extends EntityListVo<FormatSignatureVo> {

    public FormatSignaturesListVo() {
    }

    public FormatSignaturesListVo(List<FormatSignatureVo> entities) {
        super(entities);
    }

}
