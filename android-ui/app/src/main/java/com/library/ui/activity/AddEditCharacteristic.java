package com.library.ui.activity;

import android.content.Intent;

import com.library.rest.api.vo.book.CharacteristicVo;
import com.library.rest.api.vo.list.CharacteristicsListVo;
import com.library.ui.view_model.CharacteristicViewModel;

public class AddEditCharacteristic extends AddEditNamedEntity<CharacteristicVo, CharacteristicsListVo, CharacteristicViewModel> {
    public AddEditCharacteristic() {
        super(CharacteristicViewModel.class, "Characteristic");
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
