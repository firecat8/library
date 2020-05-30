package com.library.ui.activity;

import android.content.Intent;

import com.library.rest.api.request.BookSerieRequest;
import com.library.rest.api.vo.book.BookSerieVo;
import com.library.ui.view_model.BookSerieViewModel;

public class AddEditBookSerie extends AddEditNamedEntity<BookSerieVo, BookSerieRequest, BookSerieViewModel> {
    public AddEditBookSerie() {
        super(BookSerieViewModel.class);
    }

    @Override
    protected BookSerieVo getEntity(Intent intent) {
        return (BookSerieVo) intent.getSerializableExtra(EXTRA_ENTITY);
    }

    @Override
    protected BookSerieVo makeEntity(String name) {
        return new BookSerieVo(name);
    }
}
