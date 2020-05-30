package com.library.ui.view_model;

import android.app.Application;

import androidx.annotation.NonNull;

import com.library.rest.api.request.CharacteristicRequest;
import com.library.rest.api.vo.book.CharacteristicVo;
import com.library.ui.request.URL_CONSTANTS;

public class CharacteristicViewModel extends AbstractViewModel<CharacteristicVo, CharacteristicRequest> {

    public CharacteristicViewModel(@NonNull Application application) {
        super(CharacteristicVo.class, URL_CONSTANTS.CHARACTERISTIC_URL, application);
    }

    @Override
    protected CharacteristicRequest makeEntityRequest(CharacteristicVo characteristicVo) {
        return new CharacteristicRequest(characteristicVo);
    }
}
