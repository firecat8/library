package com.library.ui.view_model;

import android.app.Application;

import androidx.annotation.NonNull;

import com.library.rest.api.request.WorkFormRequest;
import com.library.rest.api.vo.book.WorkFormVo;
import com.library.rest.api.vo.list.WorkFormsListVo;
import com.library.ui.request.URL_CONSTANTS;

public class WorkFormViewModel extends AbstractViewModel<WorkFormVo, WorkFormsListVo, WorkFormRequest> {

    public WorkFormViewModel(@NonNull Application application) {
        super(WorkFormVo.class, WorkFormsListVo.class, URL_CONSTANTS.WORK_FORM_URL, application);
    }

    @Override
    protected WorkFormRequest makeEntityRequest(WorkFormVo workFormVo) {
        return new WorkFormRequest(workFormVo);
    }
}