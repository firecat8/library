package com.library.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.library.ui.R;
import com.library.ui.adapter.BookSerieAdapter;
import com.library.ui.view_model.BookSerieViewModel;

public class BookSerieListActivity extends AppCompatActivity {
    public static final int CREATE_REQUEST = 1;
    public static final int EDIT_REQUEST = 2;

    private BookSerieAdapter bookSerieAdapter;
    private BookSerieViewModel bookSerieViewModel;
    private Intent mainIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_serie_list);

        mainIntent = getIntent();
        FloatingActionButton buttonAddNote = findViewById(R.id.button_add_book_serie);
        buttonAddNote.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddEditBookSerie.class);
            intent.putExtra(AddEditBookSerie.EXTRA_MODE, AddEditBookSerie.CREATE_MODE);
            startActivityForResult(intent, CREATE_REQUEST);
        });

        RecyclerView recyclerView = findViewById(R.id.book_series_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        bookSerieAdapter = new BookSerieAdapter();
        recyclerView.setAdapter(bookSerieAdapter);

        bookSerieViewModel = new ViewModelProvider(this).get(BookSerieViewModel.class);
        getAllBookSeries();

        bookSerieAdapter.setOnItemClickListener(bookSerie -> {
            Intent intent = new Intent(BookSerieListActivity.this, AddEditBookSerie.class);

            intent.putExtras(mainIntent);
            intent.putExtra(AddEditBookSerie.EXTRA_ENTITY, bookSerie);

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
        String mode = mainIntent.getStringExtra(AddEditBookSerie.EXTRA_MODE);
        if (requestCode == CREATE_REQUEST && resultCode == RESULT_OK) {
            if (mode.equals(AddEditBookSerie.ADD_MODE)) {
                setResult(RESULT_OK, data);
                finish();
                return;
            }
            Toast.makeText(this, "Successfully added !", Toast.LENGTH_SHORT).show();
            return;
        }
        if (requestCode == EDIT_REQUEST && resultCode == RESULT_OK) {
            if (mode.equals(AddEditBookSerie.ADD_MODE)) {
                setResult(RESULT_OK, data);
                finish();
                return;
            }
            Toast.makeText(this, "Successfully changed !", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "No request", Toast.LENGTH_SHORT).show();
        getAllBookSeries();
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
        Intent intent = new Intent(BookSerieListActivity.this, LoginActivity.class);
        startActivity(intent);
        setResult(Activity.RESULT_OK);
        finish();
    }

    private void getAllBookSeries() {
        bookSerieViewModel.loadAll().observe(this, bookSeries -> bookSerieAdapter.submitList(bookSeries));
    }
}