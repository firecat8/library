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

import com.library.rest.api.vo.DateVo;
import com.library.rest.api.vo.book.AuthorVo;
import com.library.ui.R;
import com.library.ui.Utils;
import com.library.ui.view_model.AuthorViewModel;

import java.util.Calendar;

public class AddEditAuthor extends AppCompatActivity {
    public static final String EXTRA_MODE = "com.library.book.EXTRA_MODE";
    public static final String EXTRA_AUTHOR = "com.library.book.EXTRA_AUTHOR";
    public static final String CREATE_MODE = "CREATE_MODE";
    public static final String ADD_MODE = "ADD_MODE";
    public static final String EDIT_MODE = "EDIT_MODE";
    public static final String TAG = "AddEditAuthor";

    private AuthorViewModel authorViewModel;
    private EditText authorName;
    private EditText birthDate;
    private EditText birthPlace;
    private EditText biography;
    private Button addButton;
    private Button editButton;

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
        editButton = findViewById(R.id.update_author_button);
        Button backButton = findViewById(R.id.back_button);

        Intent intent = getIntent();
        String mode = intent.getStringExtra(EXTRA_MODE);
        if (mode == null)
            throw new RuntimeException("Missing work mode!");
        switch (mode) {
            case CREATE_MODE:
                addButton.setVisibility(View.VISIBLE);
                addButton.setOnClickListener(v -> {
                    AuthorVo author = makeAuthor();
                    if (author == null) {
                        return;
                    }
                    authorViewModel.save(author).observe(this, authorVo -> {
                        Intent resultIntent = new Intent();
                        resultIntent.putExtra(EXTRA_AUTHOR, authorVo);
                        setResult(RESULT_OK, resultIntent);
                        finish();
                    });
                });
                break;
            case ADD_MODE:
                addButton.setVisibility(View.VISIBLE);
                AuthorVo authorVo = (AuthorVo) intent.getSerializableExtra(EXTRA_AUTHOR);
                makeUnchangeableEditTexts(authorVo);
                addButton.setOnClickListener(v -> {
                    Log.i(TAG, "\nButton for ADD_MODE is clicked\n");
                    Intent addIntent = new Intent();
                    addIntent.putExtra(EXTRA_AUTHOR, authorVo);
                    setResult(RESULT_OK, addIntent);
                    finish();
                });
                backButton.setVisibility(View.VISIBLE);
                backButton.setOnClickListener(v -> {
                    Log.i(TAG, "\nButton back for ADD_MODE is clicked\n");
                    setResult(RESULT_CANCELED, new Intent());
                    finish();
                });
                break;
            case EDIT_MODE:
                editButton.setVisibility(View.VISIBLE);
                AuthorVo author = (AuthorVo) intent.getSerializableExtra(EXTRA_AUTHOR);
                fillData(author);
                editButton.setOnClickListener(v -> {
                    AuthorVo created = makeAuthor();
                    if (created == null) {
                        return;
                    }
                    created.setId(author.getId());
                    authorViewModel.update(created).observe(this, updated -> {
                        Intent resultIntent = new Intent();
                        resultIntent.putExtra(EXTRA_AUTHOR, updated);
                        setResult(RESULT_OK, resultIntent);
                        finish();
                    });
                });
                break;
            default:
                throw new RuntimeException("Missing or not valid mode!");
        }
    }

    private void fillData(AuthorVo authorVo) {
        authorName.setText(authorVo.getName());
        biography.setText(authorVo.getBiography());
        birthPlace.setText(authorVo.getBirthPlace());
        if (authorVo.getBirthDate() != null) {
            birthDate.setText(Utils.formatDate(authorVo.getBirthDate().convetToCalendar().getTimeInMillis()));
        }
    }

    private void makeUnchangeableEditTexts(AuthorVo authorVo) {
        Utils.makeUnchangeable(authorName, authorVo.getName());
        Utils.makeUnchangeable(biography, authorVo.getBiography());
        Utils.makeUnchangeable(birthPlace, authorVo.getBirthPlace());
        String date = authorVo.getBirthDate() != null ?
                Utils.formatDate(authorVo.getBirthDate().convetToCalendar().getTimeInMillis())
                : "";
        Utils.makeUnchangeable(birthDate, date);
    }

    private AuthorVo makeAuthor() {
        String name = authorName.getText().toString();
        if (name.isEmpty()) {
            Toast.makeText(this, "Required author name!", Toast.LENGTH_SHORT).show();
            return null;
        }
        String date = birthDate.getText().toString();
        Long birthInMS = date.isEmpty() ? null : Utils.parseDate(date);
        Calendar birth = Calendar.getInstance();
        if (birthInMS != null) {
            birth.setTimeInMillis(birthInMS);
        }
        return new AuthorVo(
                authorName.getText().toString(),
                biography.getText().toString(),
                birthPlace.getText().toString(),
                birthInMS != null ? new DateVo(birth) : null
        );
    }
}