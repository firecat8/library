package com.library.ui.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.android.volley.Response;
import com.library.rest.api.request.UserRequest;
import com.library.rest.api.response.SuccessResponse;
import com.library.rest.api.vo.user.UserVo;
import com.library.ui.request.RequestFactory;
import com.library.ui.request.URL_CONSTANTS;

import java.util.ArrayList;
import java.util.List;

public class UserViewModel extends AndroidViewModel {
    private MutableLiveData<List<UserVo>> allUserVos;
    private MutableLiveData<UserVo> oneUserVo;
    private MutableLiveData<Boolean> deleteResult;
    private MutableLiveData<Boolean> updateResult;

    public UserViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<UserVo> loadById(Long userId) {

        oneUserVo = new MutableLiveData<>();
        RequestFactory.getInstance(this.getApplication()).makeLoadRequest(
                URL_CONSTANTS.USER_URL,
                userId,
                UserVo.class,
                new Response.Listener<UserVo>() {
                    @Override
                    public void onResponse(UserVo response) {
                        oneUserVo.setValue(response);
                    }
                }
        );
        return oneUserVo;
    }

    public MutableLiveData<UserVo> save(UserVo user) {
        oneUserVo = new MutableLiveData<>();
        RequestFactory.getInstance(this.getApplication()).makeSaveRequest(
                URL_CONSTANTS.USER_URL,
                new UserRequest(user),
                UserVo.class,
                new Response.Listener<UserVo>() {
                    @Override
                    public void onResponse(UserVo response) {
                        oneUserVo.setValue(response);
                    }
                }
        );
        return oneUserVo;
    }

    public MutableLiveData<Boolean> update(UserVo user) {
        updateResult = new MutableLiveData<>();
        RequestFactory.getInstance(this.getApplication()).makeUpdateRequest(
                URL_CONSTANTS.USER_URL,
                new UserRequest(user),
                SuccessResponse.class,
                new Response.Listener<SuccessResponse>() {
                    @Override
                    public void onResponse(SuccessResponse response) {
                        updateResult.setValue(true);
                    }
                }
        );
        return updateResult;
    }

    public MutableLiveData<Boolean> delete(UserVo user) {
        deleteResult = new MutableLiveData<>();
        RequestFactory.getInstance(this.getApplication()).makeDeleteRequest(
                URL_CONSTANTS.USER_URL,
                user.getId(),
                SuccessResponse.class,
                new Response.Listener<SuccessResponse>() {
                    @Override
                    public void onResponse(SuccessResponse response) {
                        deleteResult.setValue(true);
                    }
                }
        );
        return deleteResult;
    }

    public MutableLiveData<List<UserVo>> loadAll() {
        allUserVos = new MutableLiveData<>();

        RequestFactory.getInstance(this.getApplication()).makeLoadAllRequest(
                URL_CONSTANTS.USER_URL,
                null,
                ArrayList.class,
                new Response.Listener<ArrayList>() {
                    @Override
                    public void onResponse(ArrayList response) {
                        allUserVos.setValue(response);
                    }
                }
        );

        return allUserVos;
    }
}
