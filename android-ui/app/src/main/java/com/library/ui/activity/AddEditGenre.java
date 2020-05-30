package com.library.ui.activity;

import android.content.Intent;

import com.library.rest.api.request.GenreRequest;
import com.library.rest.api.vo.book.GenreVo;
import com.library.ui.view_model.GenreViewModel;

public class AddEditGenre extends AddEditNamedEntity<GenreVo, GenreRequest, GenreViewModel> {
    public AddEditGenre() {
        super(GenreViewModel.class);
    }

    @Override
    protected GenreVo getEntity(Intent intent) {
        return (GenreVo) intent.getSerializableExtra(EXTRA_ENTITY);
    }

    @Override
    protected GenreVo makeEntity(String name) {
        return new GenreVo(name);
    }
}
