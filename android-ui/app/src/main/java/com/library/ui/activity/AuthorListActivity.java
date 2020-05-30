package com.library.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

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
    public static final int ADD_REQUEST = 1;
    public static final int EDIT_REQUEST = 2;

    private AuthorAdapter authorAdapter;
    private AuthorViewModel authorViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_list);

        FloatingActionButton buttonAddNote = findViewById(R.id.button_add_author);
        buttonAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AuthorListActivity.this, AddEditAuthor.class);
                intent.putExtra(AddEditAuthor.EXTRA_MODE, AddEditAuthor.ADD_MODE);
                startActivityForResult(intent, ADD_REQUEST);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.author_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        authorAdapter = new AuthorAdapter();
        recyclerView.setAdapter(authorAdapter);

        authorViewModel = new ViewModelProvider(this).get(AuthorViewModel.class);
        getAllAuthors();

        authorAdapter.setOnItemClickListener(new AuthorAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(AuthorVo author) {
                Intent intent = new Intent(AuthorListActivity.this, AddEditAuthor.class);

                intent.putExtra(AddEditAuthor.EXTRA_MODE, AddEditAuthor.EDIT_MODE);
                intent.putExtra(AddEditAuthor.EXTRA_AUTHOR, author);

                startActivityForResult(intent, EDIT_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

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