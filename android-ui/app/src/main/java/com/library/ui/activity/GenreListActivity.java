package com.library.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.library.ui.R;
import com.library.ui.adapter.GenreAdapter;
import com.library.ui.view_model.GenreViewModel;

public class GenreListActivity extends AppCompatActivity {
    public static final int ADD_REQUEST = 1;
    public static final int EDIT_REQUEST = 2;

    private GenreAdapter genreAdapter;
    private GenreViewModel genreViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre_list);

        FloatingActionButton buttonAddNote = findViewById(R.id.button_add_genre);
        buttonAddNote.setOnClickListener(v -> {
            Intent intent = new Intent(GenreListActivity.this, AddEditGenre.class);
            intent.putExtras(getIntent());
            startActivityForResult(intent, ADD_REQUEST);
        });

        RecyclerView recyclerView = findViewById(R.id.book_series_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        genreAdapter = new GenreAdapter();
        recyclerView.setAdapter(genreAdapter);

        genreViewModel = new ViewModelProvider(this).get(GenreViewModel.class);
        getAllGenres();

        genreAdapter.setOnItemClickListener(genre -> {
            Intent intent = new Intent(GenreListActivity.this, AddEditGenre.class);

            intent.putExtra(AddEditGenre.EXTRA_ENTITY, genre);

            startActivityForResult(intent, EDIT_REQUEST);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        getAllGenres();
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
        Intent intent = new Intent(GenreListActivity.this, LoginActivity.class);
        startActivity(intent);
        setResult(Activity.RESULT_OK);
        finish();
    }

    private void getAllGenres() {
        genreViewModel.loadAll().observe(this, genres -> genreAdapter.submitList(genres));
    }
}