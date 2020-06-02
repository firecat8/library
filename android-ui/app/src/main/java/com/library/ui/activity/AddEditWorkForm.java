package com.library.ui.activity;

import android.content.Intent;

import com.library.rest.api.request.WorkFormRequest;
import com.library.rest.api.vo.book.WorkFormVo;
import com.library.rest.api.vo.list.WorkFormsListVo;
import com.library.ui.view_model.WorkFormViewModel;

public class AddEditWorkForm extends AddEditNamedEntity<WorkFormVo, WorkFormsListVo, WorkFormRequest, WorkFormViewModel> {
    public AddEditWorkForm() {
        super(WorkFormViewModel.class,"Work form");
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
