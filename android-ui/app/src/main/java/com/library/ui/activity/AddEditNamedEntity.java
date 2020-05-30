package com.library.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.library.rest.api.request.EntityRequest;
import com.library.rest.api.vo.NamedEntityVo;
import com.library.ui.R;
import com.library.ui.view_model.AbstractViewModel;

public abstract class AddEditNamedEntity<E extends NamedEntityVo, Req extends EntityRequest<E>, EntityViewModel extends AbstractViewModel<E, Req>> extends AppCompatActivity {
    public static final String EXTRA_MODE = "com.library.book.EXTRA_MODE";
    public static final String EXTRA_ENTITY = "com.library.book.EXTRA_ENTITY";
    public static final String ADD_MODE = "ADD_MODE";
    public static final String EDIT_MODE = "EDIT_MODE";
    public final Class<EntityViewModel> modelClass;

    private EntityViewModel entityViewModel;
    private EditText name;
    private Button addButton;

    public AddEditNamedEntity(Class<EntityViewModel> modelClass) {
        super();
        this.modelClass = modelClass;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_named_entity);

        entityViewModel = new ViewModelProvider(this).get(modelClass);

        name = findViewById(R.id.name_text);
        addButton = findViewById(R.id.add_entity_button);
        addButton.setOnClickListener(v -> {
            entityViewModel.save(makeEntity(name.getText().toString()))
                    .observe(this, entity -> {
                        setResult(RESULT_OK, new Intent());
                        finish();
                    });
        });
        Intent intent = getIntent();
        String mode = intent.getStringExtra(EXTRA_MODE);
        if (mode == null)
            throw new RuntimeException("Missing work mode!");
        switch (mode) {
            case ADD_MODE:
                handleAddMode();
                break;
            case EDIT_MODE:
                E e = getEntity(intent);
                handleEditMode(e);
                break;
            default:
                throw new RuntimeException("Missing or not valid mode!");
        }
    }

    private void handleEditMode(E entity) {
    }

    private void handleAddMode() {
    }

    protected abstract E getEntity(Intent intent);

    protected abstract E makeEntity(String name);
}