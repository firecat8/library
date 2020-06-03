package com.library.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.library.ui.R;
import com.library.ui.adapter.BookRentalAdapter;
import com.library.ui.view_model.BookRentalViewModel;

public class BookRentalListActivity extends AppCompatActivity {
    public static final int CREATE_REQUEST = 1;
    public static final int EDIT_REQUEST = 2;

    private BookRentalAdapter bookRentAdapter;
    private BookRentalViewModel bookRentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_rental_list);

        FloatingActionButton buttonAddNote = findViewById(R.id.button_add_book_rent);
        buttonAddNote.setOnClickListener(v -> {
            Intent intent = new Intent(BookRentalListActivity.this, AddEditBookRent.class);
            intent.putExtras(getIntent());
            startActivityForResult(intent, CREATE_REQUEST);
        });

        RecyclerView recyclerView = findViewById(R.id.book_rental_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        bookRentAdapter = new BookRentalAdapter();
        recyclerView.setAdapter(bookRentAdapter);

        bookRentViewModel = new ViewModelProvider(this).get(BookRentalViewModel.class);
        getAllBookRentals();

        bookRentAdapter.setOnItemClickListener(bookRent -> {
            Intent intent = new Intent(BookRentalListActivity.this, AddEditBookRent.class);

            intent.putExtra(AddEditBookRent.EXTRA_BOOK_RENT, bookRent);

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
        getAllBookRentals();
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
        Intent intent = new Intent(BookRentalListActivity.this, LoginActivity.class);
        startActivity(intent);
        setResult(Activity.RESULT_OK);
        finish();
    }

    private void getAllBookRentals() {
        bookRentViewModel.loadAll().observe(this, bookRents -> bookRentAdapter.submitList(bookRents));
    }
}