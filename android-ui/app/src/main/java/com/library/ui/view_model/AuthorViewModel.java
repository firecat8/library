package com.library.ui.view_model;

import android.app.Application;

import androidx.annotation.NonNull;

import com.library.rest.api.request.AuthorRequest;
import com.library.rest.api.vo.book.AuthorVo;
import com.library.ui.request.URL_CONSTANTS;

public class AuthorViewModel extends AbstractViewModel<AuthorVo, AuthorRequest> {

    public AuthorViewModel(@NonNull Application application) {
        super(AuthorVo.class, URL_CONSTANTS.AUTHOR_URL, application);
    }

    @Override
    protected AuthorRequest makeEntityRequest(AuthorVo authorVo) {
        return new AuthorRequest(authorVo);
    }
}
