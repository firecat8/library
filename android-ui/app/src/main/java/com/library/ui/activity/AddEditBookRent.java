package com.library.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.library.ui.R;

public class AddEditBookRent extends AppCompatActivity {

    public static final String EXTRA_MODE = "com.library.book.EXTRA_MODE";
    public static final String EXTRA_BOOK_RENT = "com.library.book.EXTRA_BOOK_RENT";
    public static final String ADD_MODE = "ADD_MODE";
    public static final String EDIT_MODE = "EDIT_MODE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_book_rent);
    }
}