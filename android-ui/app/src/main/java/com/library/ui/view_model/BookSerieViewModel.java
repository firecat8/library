package com.library.ui.view_model;

import android.app.Application;

import androidx.annotation.NonNull;

import com.library.rest.api.request.BookSerieRequest;
import com.library.rest.api.vo.book.BookSerieVo;
import com.library.ui.request.URL_CONSTANTS;

public class BookSerieViewModel extends AbstractViewModel<BookSerieVo, BookSerieRequest> {

    public BookSerieViewModel(@NonNull Application application) {
        super(BookSerieVo.class, URL_CONSTANTS.BOOK_SERIE_URL, application);
    }

    @Override
    protected BookSerieRequest makeEntityRequest(BookSerieVo bookSerieVo) {
        return new BookSerieRequest(bookSerieVo);
    }
}
