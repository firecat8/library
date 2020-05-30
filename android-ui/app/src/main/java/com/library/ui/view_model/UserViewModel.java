package com.library.ui.view_model;

import android.app.Application;

import androidx.annotation.NonNull;

import com.library.rest.api.request.UserRequest;
import com.library.rest.api.vo.user.UserVo;
import com.library.ui.request.URL_CONSTANTS;

public class UserViewModel extends AbstractViewModel<UserVo, UserRequest> {

    public UserViewModel(@NonNull Application application) {
        super(UserVo.class, URL_CONSTANTS.USER_URL, application);
    }

    @Override
    protected UserRequest getEntityRequest(UserVo userVo) {
        return new UserRequest(userVo);
    }
}