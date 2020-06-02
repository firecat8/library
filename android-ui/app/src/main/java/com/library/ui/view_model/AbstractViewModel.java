package com.library.ui.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.library.rest.api.request.EntityRequest;
import com.library.rest.api.response.SuccessResponse;
import com.library.rest.api.vo.AbstractVo;
import com.library.rest.api.vo.EntityListVo;
import com.library.ui.request.RequestFactory;

import java.util.List;

public abstract class AbstractViewModel<Entity extends AbstractVo, ListVo extends EntityListVo<Entity>, Req extends EntityRequest<Entity>> extends AndroidViewModel {
    private final Class<Entity> entityClass;
    private final Class<ListVo> entityListClass;
    private final String url;
    private MutableLiveData<List<Entity>> allEntities;
    private MutableLiveData<Entity> oneEntity;
    private MutableLiveData<Boolean> deleteResult;
    private MutableLiveData<Boolean> updateResult;

    public AbstractViewModel(Class<Entity> entityClass, Class<ListVo> entityListClass, String url, @NonNull Application application) {
        super(application);
        this.entityClass = entityClass;
        this.entityListClass = entityListClass;
        this.url = url;
    }

    public MutableLiveData<Entity> loadById(Long id) {
        oneEntity = new MutableLiveData<>();
        RequestFactory.getInstance(this.getApplication()).makeLoadRequest(
                url,
                id,
                entityClass,
                response -> oneEntity.setValue(response)
        );
        return oneEntity;
    }

    public MutableLiveData<Entity> save(Entity entity) {
        oneEntity = new MutableLiveData<>();
        RequestFactory.getInstance(this.getApplication()).makeSaveRequest(
                url,
                makeEntityRequest(entity),
                entityClass,
                response -> oneEntity.setValue(response)
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
                entityListClass,
                response -> allEntities.setValue(response.getEntities())
        );

        return allEntities;
    }

    protected abstract Req makeEntityRequest(Entity entity);
}
