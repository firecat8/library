package com.library.ui.view_model;

import android.app.Application;

import androidx.annotation.NonNull;

import com.library.rest.api.request.GenreRequest;
import com.library.rest.api.vo.book.GenreVo;
import com.library.rest.api.vo.list.GenresListVo;
import com.library.ui.request.URL_CONSTANTS;

public class GenreViewModel extends AbstractViewModel<GenreVo, GenresListVo, GenreRequest> {

    public GenreViewModel(@NonNull Application application) {
        super(GenreVo.class, GenresListVo.class, URL_CONSTANTS.GENRE_URL, application);
    }

    @Override
    protected GenreRequest makeEntityRequest(GenreVo genreVo) {
        return new GenreRequest(genreVo);
    }
}