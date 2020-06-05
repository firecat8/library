package com.library.ui.view_model;

import android.app.Application;

import androidx.annotation.NonNull;

import com.library.rest.api.vo.book.WorkFormVo;
import com.library.rest.api.vo.list.WorkFormsListVo;
import com.library.ui.request.URL_CONSTANTS;

public class WorkFormViewModel extends AbstractViewModel<WorkFormVo, WorkFormsListVo> {

    public WorkFormViewModel(@NonNull Application application) {
        super(WorkFormVo.class, WorkFormsListVo.class, URL_CONSTANTS.WORK_FORM_URL, application);
    }
}