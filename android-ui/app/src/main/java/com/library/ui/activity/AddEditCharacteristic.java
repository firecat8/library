package com.library.ui.activity;

import android.content.Intent;

import com.library.rest.api.request.CharacteristicRequest;
import com.library.rest.api.vo.book.CharacteristicVo;
import com.library.ui.view_model.CharacteristicViewModel;

public class AddEditCharacteristic extends AddEditNamedEntity<CharacteristicVo, CharacteristicRequest, CharacteristicViewModel> {
    public AddEditCharacteristic() {
        super(CharacteristicViewModel.class);
    }

    @Override
    protected CharacteristicVo getEntity(Intent intent) {
        return (CharacteristicVo) intent.getSerializableExtra(EXTRA_ENTITY);
    }

    @Override
    protected CharacteristicVo makeEntity(String name) {
        return new CharacteristicVo(name);
    }
}
