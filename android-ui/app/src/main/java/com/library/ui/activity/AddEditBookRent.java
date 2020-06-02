package com.library.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.library.ui.R;

public class AddEditBookRent extends AppCompatActivity {

    public static final String EXTRA_MODE = "com.library.book.EXTRA_MODE";
    public static final String EXTRA_BOOK_RENT = "com.library.book.EXTRA_BOOK_RENT";
    public static final String CREATE_MODE = "CREATE_MODE";
    public static final String ADD_MODE = " ADD_MODE";
    public static final String EDIT_MODE = "EDIT_MODE";

    public static final int ADD_BOOK_REQUEST = 1;
    public static final int ADD_READER_REQUEST = 1;

    private EditText bookText;
    private EditText readerText;
    private ImageButton bookSearch;
    private ImageButton readerSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_book_rent);
        bookText = findViewById(R.id.book_text);
        readerText = findViewById(R.id.reader_text);
        bookSearch = findViewById(R.id.book_search);
        readerSearch = findViewById(R.id.reader_search);
        Spinner spinner = (Spinner) findViewById(R.id.book_rent_types_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.book_rent_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //.add(Calendar.DATE, 30);
        bookSearch.setOnClickListener(v -> {
            Intent intent = new Intent(this, BookListActivity.class);
            intent.putExtra(AddEditBook.EXTRA_MODE, AddEditBook.ADD_MODE);
            startActivityForResult(intent, ADD_BOOK_REQUEST);
        });
        readerSearch.setOnClickListener(v -> {
            Intent intent = new Intent(this, UserListActivity.class);
            intent.putExtra(AddEditBookRent.EXTRA_MODE, AddEditBookRent.ADD_MODE);
            startActivityForResult(intent, ADD_READER_REQUEST);
        });
    }

   /* public void selectDate(final Calendar date, final EditText editDateText) {
        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                date.set(year, monthOfYear, dayOfMonth);

            }
        }, date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DATE)).show();
    }*/
}