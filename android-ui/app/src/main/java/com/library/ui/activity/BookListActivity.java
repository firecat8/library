package com.library.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.library.ui.R;
import com.library.ui.adapter.BookAdapter;
import com.library.ui.view_model.BookViewModel;

public class BookListActivity extends AppCompatActivity {
    public static final int CREATE_REQUEST = 1;
    public static final int EDIT_REQUEST = 2;

    private BookAdapter bookAdapter;
    private BookViewModel bookViewModel;
    private Intent mainIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        mainIntent = getIntent();

        String mode = mainIntent.getStringExtra(AddEditAuthor.EXTRA_MODE);
        FloatingActionButton buttonAddNote = findViewById(R.id.button_add_book);
        buttonAddNote.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddEditBook.class);
            intent.putExtras(getIntent());
            startActivityForResult(intent, CREATE_REQUEST);
        });
        if (mode.equals(AddEditBook.RENT_MODE) || mode.equals(AddEditBook.ARCHIVE_MODE)) {
            buttonAddNote.setVisibility(View.GONE);
        }

        RecyclerView recyclerView = findViewById(R.id.book_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        bookAdapter = new BookAdapter();
        recyclerView.setAdapter(bookAdapter);

        bookViewModel = new ViewModelProvider(this).get(BookViewModel.class);
        getAllBooks();

        bookAdapter.setOnItemClickListener(book -> {
            Intent intent = new Intent(BookListActivity.this, AddEditBook.class);

            intent.putExtras(mainIntent);
            intent.putExtra(AddEditBook.EXTRA_BOOK, book);

            startActivityForResult(intent, EDIT_REQUEST);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CREATE_REQUEST && resultCode == RESULT_CANCELED) {
            return;
        }
        if (requestCode == EDIT_REQUEST && resultCode == RESULT_CANCELED) {
            return;
        }
        String mode = mainIntent.getStringExtra(AddEditAuthor.EXTRA_MODE);
        if (requestCode == CREATE_REQUEST && resultCode == RESULT_OK) {
            if (!mode.equals(AddEditBook.CREATE_MODE)) {
                setResult(RESULT_OK, data);
                finish();
                return;
            }
            Toast.makeText(this, "Successfully added!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (requestCode == EDIT_REQUEST && resultCode == RESULT_OK) {
            if (!mode.equals(AddEditBook.EDIT_MODE)) {
                setResult(RESULT_OK, data);
                finish();
                return;
            }
            Toast.makeText(this, "Successfully changed!", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "No request", Toast.LENGTH_SHORT).show();
        getAllBooks();
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

    private void getAllBooks() {
        bookViewModel.loadAll().observe(this, books -> bookAdapter.submitList(books));
    }
}