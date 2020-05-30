package com.library.ui.view_model;

import android.app.Application;

import androidx.annotation.NonNull;

import com.library.rest.api.request.PublisherRequest;
import com.library.rest.api.vo.book.PublisherVo;
import com.library.ui.request.URL_CONSTANTS;

public class PublisherViewModel extends AbstractViewModel<PublisherVo, PublisherRequest> {

    public PublisherViewModel(@NonNull Application application) {
        super(PublisherVo.class, URL_CONSTANTS.PUBLISHER_URL, application);
    }

    @Override
    protected PublisherRequest makeEntityRequest(PublisherVo publisherVo) {
        return new PublisherRequest(publisherVo);
    }
}
