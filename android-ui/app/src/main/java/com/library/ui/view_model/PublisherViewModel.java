package com.library.ui.view_model;

import android.app.Application;

import androidx.annotation.NonNull;

import com.library.rest.api.vo.book.PublisherVo;
import com.library.rest.api.vo.list.PublishersListVo;
import com.library.ui.request.URL_CONSTANTS;

public class PublisherViewModel extends AbstractViewModel<PublisherVo, PublishersListVo> {

    public PublisherViewModel(@NonNull Application application) {
        super(PublisherVo.class, PublishersListVo.class, URL_CONSTANTS.PUBLISHER_URL, application);
    }
}
