package com.library.ui.view_model;

import android.app.Application;

import androidx.annotation.NonNull;

import com.library.rest.api.request.WorkFormRequest;
import com.library.rest.api.vo.book.WorkFormVo;
import com.library.ui.request.URL_CONSTANTS;

public class WorkFormViewModel extends AbstractViewModel<WorkFormVo, WorkFormRequest> {

    public WorkFormViewModel(@NonNull Application application) {
        super(WorkFormVo.class, URL_CONSTANTS.WORK_FORM_URL, application);
    }

    @Override
    protected WorkFormRequest getEntityRequest(WorkFormVo workFormVo) {
        return new WorkFormRequest(workFormVo);
    }
}