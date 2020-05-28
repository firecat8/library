package com.library.ui.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.android.volley.Response;
import com.library.rest.api.request.BookRequest;
import com.library.rest.api.response.SuccessResponse;
import com.library.rest.api.vo.book.BookVo;
import com.library.ui.request.RequestFactory;
import com.library.ui.request.URL_CONSTANTS;

import java.util.ArrayList;
import java.util.List;

public class BookViewModel extends AndroidViewModel {
    private MutableLiveData<List<BookVo>> allBookVos;
    private MutableLiveData<BookVo> oneBookVo;
    private MutableLiveData<Boolean> deleteResult;
    private MutableLiveData<Boolean> updateResult;

    public BookViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<BookVo> loadById(Long userId) {

        oneBookVo = new MutableLiveData<>();
        RequestFactory.getInstance(this.getApplication()).makeLoadRequest(
                URL_CONSTANTS.USER_URL,
                userId,
                BookVo.class,
                new Response.Listener<BookVo>() {
                    @Override
                    public void onResponse(BookVo response) {
                        oneBookVo.setValue(response);
                    }
                }
        );
        return oneBookVo;
    }

    public MutableLiveData<BookVo> save(BookVo user) {
        oneBookVo = new MutableLiveData<>();
        RequestFactory.getInstance(this.getApplication()).makeSaveRequest(
                URL_CONSTANTS.USER_URL,
                new BookRequest(user),
                BookVo.class,
                new Response.Listener<BookVo>() {
                    @Override
                    public void onResponse(BookVo response) {
                        oneBookVo.setValue(response);
                    }
                }
        );
        return oneBookVo;
    }

    public MutableLiveData<Boolean> update(BookVo user) {
        updateResult = new MutableLiveData<>();
        RequestFactory.getInstance(this.getApplication()).makeUpdateRequest(
                URL_CONSTANTS.USER_URL,
                new BookRequest(user),
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

    public MutableLiveData<Boolean> delete(BookVo user) {
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

    public MutableLiveData<List<BookVo>> loadAll() {
        allBookVos = new MutableLiveData<>();

        RequestFactory.getInstance(this.getApplication()).makeLoadAllRequest(
                URL_CONSTANTS.USER_URL,
                null,
                ArrayList.class,
                new Response.Listener<ArrayList>() {
                    @Override
                    public void onResponse(ArrayList response) {
                        allBookVos.setValue(response);
                    }
                }
        );

        return allBookVos;
    }
}
