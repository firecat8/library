package com.library.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.library.rest.api.vo.book.AuthorVo;
import com.library.rest.api.vo.user.UserVo;
import com.library.ui.R;
import com.library.ui.Utils;
import com.library.ui.view_model.AuthorViewModel;

import java.util.Calendar;

public class AddEditAuthor extends AppCompatActivity {
    public static final String EXTRA_MODE = "com.library.book.EXTRA_MODE";
    public static final String EXTRA_AUTHOR = "com.library.book.EXTRA_AUTHOR";
    public static final String ADD_MODE = "ADD_MODE";
    public static final String EDIT_MODE = "EDIT_MODE";

    private AuthorViewModel authorViewModel;
    private EditText authorName;
    private EditText birthDate;
    private EditText birthPlace;
    private EditText biography;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_author);

        authorViewModel = new ViewModelProvider(this).get(AuthorViewModel.class);

        authorName = findViewById(R.id.author_name);
        birthDate = findViewById(R.id.birth_date);
        birthPlace = findViewById(R.id.birth_place);
        biography = findViewById(R.id.biography);
        addButton = findViewById(R.id.add_author_button);
        addButton.setOnClickListener(v -> {
            authorViewModel.save(makeAuthor()).observe(this, insertedUser -> {
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
                AuthorVo author =(AuthorVo) intent.getSerializableExtra(EXTRA_AUTHOR);
                handleEditMode(author);
                break;
            default:
                throw new RuntimeException("Missing or not valid mode!");
        }
    }

    private void handleEditMode(AuthorVo author) {
    }

    private void handleAddMode() {
    }

    private AuthorVo makeAuthor() {
        Long birthInMS = Utils.parseDate(birthDate.getText().toString());
        Calendar birth = Calendar.getInstance();
        if (birthInMS != null) {
            birth.setTimeInMillis(birthInMS);
        }
        return new AuthorVo(
                authorName.getText().toString(),
                biography.getText().toString(),
                birthPlace.getText().toString(),
                birthInMS != null ? birth : null
        );
    }
}