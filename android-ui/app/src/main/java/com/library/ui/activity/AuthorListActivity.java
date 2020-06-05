package com.library.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.library.rest.api.vo.book.AuthorVo;
import com.library.ui.R;
import com.library.ui.adapter.AuthorAdapter;
import com.library.ui.view_model.AuthorViewModel;

import java.util.List;

public class AuthorListActivity extends AppCompatActivity {
    public static final int CREATE_REQUEST = 1;
    public static final int EDIT_REQUEST = 2;

    private AuthorAdapter authorAdapter;
    private AuthorViewModel authorViewModel;

    private Intent mainIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_list);
        mainIntent = getIntent();

        FloatingActionButton buttonAddNote = findViewById(R.id.button_add_author);
        buttonAddNote.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddEditAuthor.class);
            intent.putExtra(AddEditAuthor.EXTRA_MODE, AddEditAuthor.CREATE_MODE);
            startActivityForResult(intent, CREATE_REQUEST);
        });

        RecyclerView recyclerView = findViewById(R.id.author_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        authorAdapter = new AuthorAdapter();
        recyclerView.setAdapter(authorAdapter);

        authorViewModel = new ViewModelProvider(this).get(AuthorViewModel.class);
        getAllAuthors();

        authorAdapter.setOnItemClickListener(author -> {
            Intent intent = new Intent(this, AddEditAuthor.class);

            intent.putExtras(mainIntent);
            intent.putExtra(AddEditAuthor.EXTRA_AUTHOR, author);

            startActivityForResult(intent, EDIT_REQUEST);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CREATE_REQUEST && resultCode == RESULT_CANCELED ) {
            return;
        }
        if (requestCode == EDIT_REQUEST && resultCode == RESULT_CANCELED) {
            return;
        }
        String mode = mainIntent.getStringExtra(AddEditAuthor.EXTRA_MODE);
        if (requestCode == CREATE_REQUEST && resultCode == RESULT_OK ) {
            if (mode.equals(AddEditAuthor.ADD_MODE)) {
                setResult(RESULT_OK, data);
                finish();
                return;
            }
            Toast.makeText(this, "Successfully added!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (requestCode == EDIT_REQUEST && resultCode == RESULT_OK) {
            if (mode.equals(AddEditAuthor.ADD_MODE)) {
                setResult(RESULT_OK, data);
                finish();
                return;
            }
            Toast.makeText(this, "Successfully changed!", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "No request", Toast.LENGTH_SHORT).show();
        getAllAuthors();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout_now:
                logoutNow();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void logoutNow() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        setResult(Activity.RESULT_OK);
        finish();
    }

    private void getAllAuthors() {
        authorViewModel.loadAll().observe(this, new Observer<List<AuthorVo>>() {
            @Override
            public void onChanged(@Nullable List<AuthorVo> authors) {
                authorAdapter.submitList(authors);
            }
        });
    }
}