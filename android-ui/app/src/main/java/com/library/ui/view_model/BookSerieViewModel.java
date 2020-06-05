package com.library.ui.view_model;

import android.app.Application;

import androidx.annotation.NonNull;

import com.library.rest.api.vo.book.BookSerieVo;
import com.library.rest.api.vo.list.BookSeriesListVo;
import com.library.ui.request.URL_CONSTANTS;

public class BookSerieViewModel extends AbstractViewModel<BookSerieVo, BookSeriesListVo> {

    public BookSerieViewModel(@NonNull Application application) {
        super(BookSerieVo.class, BookSeriesListVo.class, URL_CONSTANTS.BOOK_SERIE_URL, application);
    }
}
