package com.library.ui.view_model;

import android.app.Application;

import androidx.annotation.NonNull;

import com.library.rest.api.request.BookRequest;
import com.library.rest.api.vo.book.BookVo;
import com.library.ui.request.URL_CONSTANTS;

public class BookViewModel extends AbstractViewModel<BookVo, BookRequest> {

    public BookViewModel(@NonNull Application application) {
        super(BookVo.class, URL_CONSTANTS.BOOK_URL, application);
    }

    @Override
    protected BookRequest makeEntityRequest(BookVo bookVo) {
        return new BookRequest(bookVo);
    }
}