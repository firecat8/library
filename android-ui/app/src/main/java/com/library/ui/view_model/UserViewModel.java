package com.library.ui.view_model;

import android.app.Application;

import androidx.annotation.NonNull;

import com.library.rest.api.vo.list.UsersListVo;
import com.library.rest.api.vo.user.UserVo;
import com.library.ui.request.URL_CONSTANTS;

public class UserViewModel extends AbstractViewModel<UserVo, UsersListVo> {

    public UserViewModel(@NonNull Application application) {
        super(UserVo.class,UsersListVo.class, URL_CONSTANTS.USER_URL, application);
    }
}