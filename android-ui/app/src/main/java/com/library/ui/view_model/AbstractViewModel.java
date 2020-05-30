package com.library.ui.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.android.volley.Response;
import com.library.rest.api.request.EntityRequest;
import com.library.rest.api.response.SuccessResponse;
import com.library.rest.api.vo.AbstractVo;
import com.library.ui.request.RequestFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractViewModel<Entity extends AbstractVo, Req extends EntityRequest> extends AndroidViewModel {
    private final Class entityClass;
    private final String url;
    private MutableLiveData<List<Entity>> allEntities;
    private MutableLiveData<Entity> oneEntity;
    private MutableLiveData<Boolean> deleteResult;
    private MutableLiveData<Boolean> updateResult;

    public AbstractViewModel(Class entityClass, String url, @NonNull Application application) {
        super(application);
        this.entityClass = entityClass;
        this.url = url;
    }

    public MutableLiveData<Entity> loadById(Long id) {
        oneEntity = new MutableLiveData<>();
        RequestFactory.getInstance(this.getApplication()).makeLoadRequest(
                url,
                id,
                entityClass,
                (Response.Listener<Entity>) response -> oneEntity.setValue(response)
        );
        return oneEntity;
    }

    public MutableLiveData<Entity> save(Entity entity) {
        oneEntity = new MutableLiveData<>();
        RequestFactory.getInstance(this.getApplication()).makeSaveRequest(
                url,
                makeEntityRequest(entity),
                entityClass,
                (Response.Listener<Entity>) response -> oneEntity.setValue(response)
        );
        return oneEntity;
    }

    public MutableLiveData<Boolean> update(Entity entity) {
        updateResult = new MutableLiveData<>();
        RequestFactory.getInstance(this.getApplication()).makeUpdateRequest(
                url,
                makeEntityRequest(entity),
                SuccessResponse.class,
                response -> updateResult.setValue(true)
        );
        return updateResult;
    }

    public MutableLiveData<Boolean> delete(Entity entity) {
        deleteResult = new MutableLiveData<>();
        RequestFactory.getInstance(this.getApplication()).makeDeleteRequest(
                url,
                entity.getId(),
                SuccessResponse.class,
                response -> deleteResult.setValue(true)
        );
        return deleteResult;
    }

    public MutableLiveData<List<Entity>> loadAll() {
        allEntities = new MutableLiveData<>();

        RequestFactory.getInstance(this.getApplication()).makeLoadAllRequest(
                url,
                null,
                ArrayList.class,
                response -> allEntities.setValue(response)
        );

        return allEntities;
    }

    protected abstract Req makeEntityRequest(Entity entity);
}
