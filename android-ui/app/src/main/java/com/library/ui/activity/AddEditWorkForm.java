package com.library.ui.activity;

import android.content.Intent;

import com.library.rest.api.request.WorkFormRequest;
import com.library.rest.api.vo.book.WorkFormVo;
import com.library.ui.view_model.WorkFormViewModel;

public class AddEditWorkForm extends AddEditNamedEntity<WorkFormVo, WorkFormRequest, WorkFormViewModel> {
    public AddEditWorkForm() {
        super(WorkFormViewModel.class);
    }

    @Override
    protected WorkFormVo getEntity(Intent intent) {
        return (WorkFormVo) intent.getSerializableExtra(EXTRA_ENTITY);
    }

    @Override
    protected WorkFormVo makeEntity(String name) {
        return new WorkFormVo(name);
    }
}
