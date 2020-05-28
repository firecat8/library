package com.library.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.library.rest.api.vo.book.BookStatesVo;
import com.library.rest.api.vo.book.BookStatusVo;
import com.library.rest.api.vo.book.BookVo;
import com.library.rest.api.vo.book.PublisherVo;
import com.library.ui.R;
import com.library.ui.view_model.BookViewModel;

import java.time.Year;
import java.util.UUID;

public class AddEditBook extends AppCompatActivity {
    private BookViewModel bookViewModel;
    private EditText inventoryNumber;
    private EditText title;
    private EditText yearText;

    private EditText authorName;
    private EditText isbn;
    private EditText genre;
    private EditText workForm;
    private Button addBookButton;
    private Button archiveBookButton;
    private Button discardBookButton;
    private Button returnBookButton;
    private Button rentBookButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_book);

        bookViewModel = new ViewModelProvider(this).get(BookViewModel.class);

        inventoryNumber = findViewById(R.id.inventory_number_text);
        title = findViewById(R.id.title_text);
        yearText = findViewById(R.id.year_text);
        authorName = findViewById(R.id.author_text);
        isbn = findViewById(R.id.ISBN_text);
        genre = findViewById(R.id.genre_text);
        workForm = findViewById(R.id.work_form_text);
        addBookButton = findViewById(R.id.add_btn);
        archiveBookButton = findViewById(R.id.archive_btn);
        discardBookButton = findViewById(R.id.discard_btn);
        returnBookButton = findViewById(R.id.retrun_btn);
        rentBookButton = findViewById(R.id.rent_book_btn);
/*
        addBookButton.setOnClickListener(v -> {
            bookViewModel.save(makeBookVo()).observe(this, new Observer<BookVo>() {
                @Override
                public void onChanged(@Nullable BookVo insertedUser) {
                    setResult(RESULT_OK, new Intent());
                    finish();
                }
            });
        });*/
    }
/*
    private BookVo makeBookVo() {
        //String title, String signature, BookStatesVo state, BookStatusVo status, PublisherVo publisher,
        // Year publishYear, WorkFormVo form, AuthorVo author, BookSerieVo serie, String inventoryNumber, String ISBN) {
        BookVo book = new BookVo(
                title.getText().toString(),
                UUID.randomUUID().toString(),
                BookStatesVo.NEW,
                BookStatusVo.AVAILABLE,
                new PublisherVo(""),
                Year.parse(yearText.getText().toString()),
                workForm.getText().toString(),
                ne
        );
        return book;
    }*/
}