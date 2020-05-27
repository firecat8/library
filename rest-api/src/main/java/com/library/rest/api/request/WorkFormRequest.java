package com.library.rest.api.request;

import com.library.rest.api.vo.book.WorkFormVo;

/**
 *
 * @author gdimitrova
 */
public class WorkFormRequest extends EntityRequest<WorkFormVo> {

    public WorkFormRequest(WorkFormVo entity) {
        super(entity);
    }

}
