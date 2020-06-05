package com.library.ui.view_model;

import android.app.Application;

import androidx.annotation.NonNull;

import com.library.rest.api.vo.book.CharacteristicVo;
import com.library.rest.api.vo.list.CharacteristicsListVo;
import com.library.ui.request.URL_CONSTANTS;

public class CharacteristicViewModel extends AbstractViewModel<CharacteristicVo, CharacteristicsListVo> {

    public CharacteristicViewModel(@NonNull Application application) {
        super(CharacteristicVo.class, CharacteristicsListVo.class, URL_CONSTANTS.CHARACTERISTIC_URL, application);
    }

}
