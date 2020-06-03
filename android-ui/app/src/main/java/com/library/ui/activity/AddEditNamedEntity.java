package com.library.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.library.rest.api.request.EntityRequest;
import com.library.rest.api.vo.EntityListVo;
import com.library.rest.api.vo.NamedEntityVo;
import com.library.ui.R;
import com.library.ui.view_model.AbstractViewModel;

public abstract class AddEditNamedEntity<E extends NamedEntityVo, ListVo extends EntityListVo<E>, Req extends EntityRequest<E>, EntityViewModel extends AbstractViewModel<E, ListVo, Req>> extends AppCompatActivity {
    public static final String EXTRA_MODE = "com.library.named.entity.EXTRA_MODE";
    public static final String EXTRA_ENTITY = "com.library.named.entity.EXTRA_ENTITY";
    public static final String CREATE_MODE = "CREATE_MODE";
    public static final String EDIT_MODE = " EDIT_MODE";
    public static final String ADD_MODE = " ADD_MODE";
    public static final String TAG = "AddEditNamedEntity";
    public Class<EntityViewModel> modelClass;

    private EntityViewModel entityViewModel;
    private EditText name;
    private String title;

    public AddEditNamedEntity() {
    }

    public AddEditNamedEntity(Class<EntityViewModel> modelClass, String title) {
        super();
        this.modelClass = modelClass;
        this.title = title;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_named_entity);
        setTitle(title);

        entityViewModel = new ViewModelProvider(this).get(modelClass);

        name = findViewById(R.id.name_text);
        Button addButton = findViewById(R.id.add_entity_button);
        Button editButton = findViewById(R.id.edit_entity_button);
        Button backButton=findViewById(R.id.back_button);

        Intent intent = getIntent();
        String mode = intent.getStringExtra(EXTRA_MODE);
        Log.i(TAG, "\nMode is " + mode + "\n");
        if (mode == null)
            throw new RuntimeException("Missing work mode!");
        switch (mode) {
            case CREATE_MODE:
                addButton.setOnClickListener(v -> {
                    Log.i(TAG, "\nButton for CREATE_MODE is clicked\n");
                    String entityName = name.getText().toString();
                    if (entityName.isEmpty()) {
                        Toast.makeText(this, "Name is empty", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    entityViewModel.save(makeEntity(entityName))
                            .observe(this, entity -> {
                                Intent addIntent = new Intent();
                                addIntent.putExtra(EXTRA_ENTITY, entity);
                                setResult(RESULT_OK, addIntent);
                                finish();
                            });
                });
                break;
            case ADD_MODE:
                E entityForAdding = getEntity(intent);
                name.setText(entityForAdding.getName());
                name.setTextIsSelectable(true);
                name.setAutofillHints("");
                name.setFocusable(false);
                addButton.setOnClickListener(v -> {
                    Log.i(TAG, "\nButton for ADD_MODE is clicked\n");
                    Intent addIntent = new Intent();
                    addIntent.putExtra(EXTRA_ENTITY, entityForAdding);
                    setResult(RESULT_OK, addIntent);
                    finish();
                });
                backButton.setVisibility(View.VISIBLE);
                backButton.setOnClickListener(v -> {
                    Log.i(TAG, "\nButton back for ADD_MODE is clicked\n");
                    setResult(RESULT_CANCELED,  new Intent());
                    finish();
                });
                break;
            case EDIT_MODE:
                addButton.setVisibility(View.GONE);
                editButton.setVisibility(View.VISIBLE);
                E e = getEntity(intent);
                name.setText(e.getName());
                editButton.setOnClickListener(v -> {
                    Log.i(TAG, "\nButton for EDIT_MODE is clicked\n");
                    String newName = name.getText().toString();
                    if (newName.isEmpty()) {
                        Toast.makeText(this, "Name is empty", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    e.setName(newName);
                    entityViewModel.update(e)
                            .observe(this, entity -> {
                                Intent updateIntent = new Intent();
                                updateIntent.putExtra(EXTRA_ENTITY, entity);
                                setResult(RESULT_OK, updateIntent);
                                finish();
                            });
                });
                break;
            default:
                throw new RuntimeException("Missing or not valid mode!");
        }
    }

    protected abstract E getEntity(Intent intent);

    protected abstract E makeEntity(String name);
}