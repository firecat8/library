package com.library.rest.api.request;

import com.library.rest.api.vo.book.WorkFormVo;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class WorkFormsRequest extends EntityListRequest<WorkFormVo> {

    public WorkFormsRequest(List<WorkFormVo> entities) {
        super(entities);
    }

}
