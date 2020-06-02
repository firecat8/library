package com.library.ui.activity;

import android.content.Intent;

import com.library.rest.api.request.PublisherRequest;
import com.library.rest.api.vo.book.PublisherVo;
import com.library.rest.api.vo.list.PublishersListVo;
import com.library.ui.view_model.PublisherViewModel;

public class AddEditPublisher extends AddEditNamedEntity<PublisherVo, PublishersListVo, PublisherRequest, PublisherViewModel> {
    public AddEditPublisher() {
        super(PublisherViewModel.class,"Publisher");
    }

    @Override
    protected PublisherVo getEntity(Intent intent) {
        return (PublisherVo) intent.getSerializableExtra(EXTRA_ENTITY);
    }

    @Override
    protected PublisherVo makeEntity(String name) {
        return new PublisherVo(name);
    }
}
