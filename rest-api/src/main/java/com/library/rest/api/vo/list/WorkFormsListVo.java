package com.library.rest.api.vo.list;

import com.library.rest.api.vo.EntityListVo;
import com.library.rest.api.vo.book.WorkFormVo;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class WorkFormsListVo extends EntityListVo<WorkFormVo>{

    public WorkFormsListVo() {
    }

    public WorkFormsListVo(List<WorkFormVo> entities) {
        super(entities);
    }
    
}
