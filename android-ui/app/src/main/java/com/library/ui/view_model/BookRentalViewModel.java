package com.library.ui.view_model;

import android.app.Application;

import androidx.annotation.NonNull;

import com.library.rest.api.request.BookRentalRequest;
import com.library.rest.api.vo.book.BookRentalVo;
import com.library.rest.api.vo.list.BooksRentalListVo;
import com.library.ui.request.URL_CONSTANTS;

public class BookRentalViewModel extends AbstractViewModel<BookRentalVo, BooksRentalListVo, BookRentalRequest> {

    public BookRentalViewModel(@NonNull Application application) {
        super(BookRentalVo.class, BooksRentalListVo.class, URL_CONSTANTS.BOOK_RENTAL_URL, application);
    }

    @Override
    protected BookRentalRequest makeEntityRequest(BookRentalVo bookRentalVo) {
        return new BookRentalRequest(bookRentalVo);
    }
}