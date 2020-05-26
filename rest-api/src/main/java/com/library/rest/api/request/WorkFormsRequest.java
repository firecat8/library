package com.library.rest.api.request;

import com.library.domain.book.WorkForm;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class WorkFormsRequest extends EntityListRequest<WorkForm> {

    public WorkFormsRequest(List<WorkForm> entities) {
        super(entities);
    }

}
