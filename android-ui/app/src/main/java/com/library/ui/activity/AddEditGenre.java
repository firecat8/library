package com.library.ui.activity;

import android.content.Intent;

import com.library.rest.api.vo.book.GenreVo;
import com.library.rest.api.vo.list.GenresListVo;
import com.library.ui.view_model.GenreViewModel;

public class AddEditGenre extends AddEditNamedEntity<GenreVo, GenresListVo, GenreViewModel> {
    public AddEditGenre() {
        super(GenreViewModel.class, "Genre");
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
