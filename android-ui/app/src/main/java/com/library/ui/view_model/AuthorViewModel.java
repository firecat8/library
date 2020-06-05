package com.library.ui.view_model;

import android.app.Application;

import androidx.annotation.NonNull;

import com.library.rest.api.vo.book.AuthorVo;
import com.library.rest.api.vo.list.AuthorsListVo;
import com.library.ui.request.URL_CONSTANTS;

public class AuthorViewModel extends AbstractViewModel<AuthorVo, AuthorsListVo> {

    public AuthorViewModel(@NonNull Application application) {
        super(AuthorVo.class, AuthorsListVo.class, URL_CONSTANTS.AUTHOR_URL, application);
    }

}
