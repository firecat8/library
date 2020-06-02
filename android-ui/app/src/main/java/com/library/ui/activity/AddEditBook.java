package com.library.ui.activity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.library.rest.api.vo.book.AuthorVo;
import com.library.rest.api.vo.book.BookSerieVo;
import com.library.rest.api.vo.book.BookStatesVo;
import com.library.rest.api.vo.book.BookStatusVo;
import com.library.rest.api.vo.book.BookVo;
import com.library.rest.api.vo.book.CharacteristicVo;
import com.library.rest.api.vo.book.GenreVo;
import com.library.rest.api.vo.book.PublisherVo;
import com.library.rest.api.vo.book.WorkFormVo;
import com.library.ui.R;
import com.library.ui.view_model.BookViewModel;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AddEditBook extends AppCompatActivity {
    public static final String EXTRA_BOOK = "com.library.book.EXTRA_BOOK";
    public static final String EXTRA_MODE = "com.library.book.EXTRA_MODE";
    public static final String CREATE_MODE = "CREATE_MODE";
    public static final String ADD_MODE = "ADD_MODE";
    public static final String EDIT_MODE = "EDIT_MODE";
    public static final String ARCHIVE_MODE = "ARCHIVE_MODE";
    public static final String DELETE_MODE = "DELETE_MODE";
    public static final String RENT_MODE = "RENT_MODE";
    public static final String TAG = "AddEditBook";

    public static final int ADD_AUTHOR_REQUEST = 1;
    public static final int ADD_PUBLISHER_REQUEST = 2;
    public static final int ADD_GENRE_REQUEST = 3;
    public static final int ADD_BOOK_SERIE_REQUEST = 4;
    public static final int ADD_CHARACTERISTIC_REQUEST = 5;
    public static final int ADD_WORK_FORM_REQUEST = 6;

    private BookViewModel bookViewModel;
    private EditText inventoryNumber;
    private EditText title;
    private EditText yearText;

    private EditText authorName;
    private EditText isbn;
    private EditText genreName;
    private EditText workFormName;
    private EditText publisherName;
    private EditText characteristicName;
    private EditText bookSerieName;
    private ImageButton authorSearch;
    private ImageButton publisherSearch;
    private ImageButton genreSearch;
    private ImageButton characteristicSearch;
    private ImageButton bookSerieSearch;
    private ImageButton workFormSearch;

    private AuthorVo author;
    private PublisherVo publisher;
    private BookSerieVo bookSerie;
    private WorkFormVo workForm;
    private List<GenreVo> genres = new ArrayList<>();
    private List<CharacteristicVo> characteristics = new ArrayList<>();

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
        genreName = findViewById(R.id.genre_text);
        workFormName = findViewById(R.id.work_form_text);
        publisherName = findViewById(R.id.publisher_text);
        characteristicName = findViewById(R.id.characteristic_text);
        bookSerieName = findViewById(R.id.book_serie_text);
        workFormSearch = findViewById(R.id.work_form_search);

        Button addBookButton = findViewById(R.id.add_btn);
        Button archiveBookButton = findViewById(R.id.archive_btn);
        Button discardBookButton = findViewById(R.id.discard_btn);
        Button returnBookButton = findViewById(R.id.return_btn);
        Button rentBookButton = findViewById(R.id.rent_book_btn);

        authorSearch = findViewById(R.id.author_search);
        publisherSearch = findViewById(R.id.publisher_search);
        genreSearch = findViewById(R.id.genre_search);
        characteristicSearch = findViewById(R.id.characteristic_search);
        bookSerieSearch = findViewById(R.id.book_serie_search);

        authorSearch.setOnClickListener(v -> {
            Intent intent = new Intent(this, AuthorListActivity.class);
            intent.putExtra(AddEditBookRent.EXTRA_MODE, AddEditBookRent.ADD_MODE);
            startActivityForResult(intent, ADD_AUTHOR_REQUEST);
        });
        workFormSearch.setOnClickListener(v -> {
            Intent intent = new Intent(this, WorkFormListActivity.class);
            intent.putExtra(AddEditWorkForm.EXTRA_MODE, AddEditWorkForm.ADD_MODE);
            startActivityForResult(intent, ADD_WORK_FORM_REQUEST);
        });

        publisherSearch.setOnClickListener(v -> {
            Intent intent = new Intent(this, PublisherListActivity.class);
            intent.putExtra(AddEditPublisher.EXTRA_MODE, AddEditPublisher.ADD_MODE);
            startActivityForResult(intent, ADD_PUBLISHER_REQUEST);
        });

        genreSearch.setOnClickListener(v -> {
            Intent intent = new Intent(this, GenreListActivity.class);
            intent.putExtra(AddEditGenre.EXTRA_MODE, AddEditGenre.ADD_MODE);
            startActivityForResult(intent, ADD_GENRE_REQUEST);
        });

        characteristicSearch.setOnClickListener(v -> {
            Intent intent = new Intent(this, CharacteristicListActivity.class);
            intent.putExtra(AddEditCharacteristic.EXTRA_MODE, AddEditCharacteristic.ADD_MODE);
            startActivityForResult(intent, ADD_CHARACTERISTIC_REQUEST);
        });

        bookSerieSearch.setOnClickListener(v -> {
            Intent intent = new Intent(this, BookSerieListActivity.class);
            intent.putExtra(AddEditBookSerie.EXTRA_MODE, AddEditBookSerie.ADD_MODE);
            startActivityForResult(intent, ADD_BOOK_SERIE_REQUEST);
        });

        Intent intent = getIntent();
        String mode = intent.getStringExtra(EXTRA_MODE);
        BookVo bookVo = (BookVo) intent.getSerializableExtra(EXTRA_BOOK);
        if (bookVo != null) {
            fillData(bookVo);
        }

        if (mode == null)
            throw new RuntimeException("Missing work mode!");
        switch (mode) {
            case CREATE_MODE:
                inventoryNumber.setVisibility(View.GONE);
                addBookButton.setVisibility(View.VISIBLE);
                addBookButton.setOnClickListener(v -> {
                    bookViewModel.save(makeBookVo(BookStatesVo.NEW, BookStatusVo.AVAILABLE)).observe(this, savedBook -> {
                        setResult(RESULT_OK, new Intent());
                        finish();
                    });
                });
                break;
            case ARCHIVE_MODE:
                if (bookVo == null) {
                    throw new RuntimeException("Missing book for editing!");
                }
                hideSearches();
                archiveBookButton.setVisibility(View.VISIBLE);
                archiveBookButton.setOnClickListener(v -> {
                    bookViewModel.update(makeBookVo(BookStatesVo.OLD, BookStatusVo.READING_ROOM)).observe(this, savedBook -> {
                        setResult(RESULT_OK, new Intent());
                        finish();
                    });
                });
                break;
            case EDIT_MODE:
                if (bookVo == null) {
                    throw new RuntimeException("Missing book for editing!");
                }
                break;
            case RENT_MODE:
                if (bookVo == null) {
                    throw new RuntimeException("Missing book for renting!");
                }
                hideSearches();
                rentBookButton.setVisibility(View.VISIBLE);
                rentBookButton.setOnClickListener(v -> {
                    Intent rentIntent = new Intent();
                    rentIntent.putExtra(EXTRA_BOOK, bookVo);
                    setResult(RESULT_OK, rentIntent);
                    finish();
                });
                break;
            case DELETE_MODE:
                if (bookVo == null) {
                    throw new RuntimeException("Missing book for discarding!");
                }
                hideSearches();
                discardBookButton.setVisibility(View.VISIBLE);
                discardBookButton.setOnClickListener(v -> {
                    bookViewModel.delete(bookVo).observe(this, isDeleted -> {
                        setResult(RESULT_OK, new Intent());
                        finish();
                    });
                });
                break;
            default:
                throw new RuntimeException("Missing or not valid mode!");
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_AUTHOR_REQUEST && resultCode == RESULT_OK) {
            author = (AuthorVo) data.getSerializableExtra(AddEditAuthor.EXTRA_AUTHOR);
            if (author == null) {
                Toast.makeText(this, "Not added author!", Toast.LENGTH_SHORT).show();
                return;
            }
            authorName.setText(author.getName());
            Log.i(TAG, "\nMode is Successfully added author!\n");
            return;
        }
        if (requestCode == ADD_PUBLISHER_REQUEST && resultCode == RESULT_OK) {
            publisher = (PublisherVo) data.getSerializableExtra(AddEditPublisher.EXTRA_ENTITY);
            if (publisher == null) {
                Toast.makeText(this, "Not added publisher!", Toast.LENGTH_SHORT).show();
                return;
            }
            publisherName.setText(publisher.getName());
            Log.i(TAG, "\nMode is Successfully added publisher!\n");
            return;
        }
        if (requestCode == ADD_GENRE_REQUEST && resultCode == RESULT_OK) {
            GenreVo genre = (GenreVo) data.getSerializableExtra(AddEditGenre.EXTRA_ENTITY);
            if (genre == null) {
                Toast.makeText(this, "Not added book genre!", Toast.LENGTH_SHORT).show();
                return;
            }
            genreName.setText(genre.getName());
            genres.set(0, genre);
            Log.i(TAG, "\nMode is Successfully added book genre!\n");
            return;
        }
        if (requestCode == ADD_CHARACTERISTIC_REQUEST && resultCode == RESULT_OK) {
            CharacteristicVo characteristic = (CharacteristicVo) data.getSerializableExtra(AddEditCharacteristic.EXTRA_ENTITY);
            if (characteristic == null) {
                Toast.makeText(this, "Not added characteristic!", Toast.LENGTH_SHORT).show();
                return;
            }
            characteristicName.setText(characteristic.getName());
            characteristics.set(0, characteristic);
            Log.i(TAG, "\nMode is Successfully added characteristic!\n");
            return;
        }
        if (requestCode == ADD_WORK_FORM_REQUEST && resultCode == RESULT_OK) {
            workForm = (WorkFormVo) data.getSerializableExtra(AddEditWorkForm.EXTRA_ENTITY);
            if (workForm == null) {
                Toast.makeText(this, "Not added work form!", Toast.LENGTH_SHORT).show();
                return;
            }
            workFormName.setText(workForm.getName());
            Log.i(TAG, "\nSuccessfully added work form!\n");
            return;
        }
        if (requestCode == ADD_BOOK_SERIE_REQUEST && resultCode == RESULT_OK) {
            bookSerie = (BookSerieVo) data.getSerializableExtra(AddEditBookSerie.EXTRA_ENTITY);
            if (bookSerie == null) {
                Toast.makeText(this, "Not added book serie!", Toast.LENGTH_SHORT).show();
                return;
            }
            bookSerieName.setText(bookSerie.getName());
            Log.i(TAG, "\nSuccessfully added book serie!\n");
            return;
        }
        Toast.makeText(this, "No result", Toast.LENGTH_SHORT).show();
    }

    private void fillData(BookVo book) {
        inventoryNumber.setText(book.getInventoryNumber());
        title.setText(book.getTitle());
        yearText.setText(book.getPublishYear().toString());
        authorName.setText(book.getAuthor().getName());
        isbn.setText(book.getISBN());
        workFormName.setText(book.getForm().getName());
        publisherName.setText(book.getPublisher().getName());
        bookSerieName.setText(book.getSerie().getName());
        List<GenreVo> genres = book.getGenres();
        if (!genres.isEmpty()) {
            genreName.setText(genres.get(0).getName());
        }
        List<CharacteristicVo> characteristics = book.getCharacteristics();
        if (!characteristics.isEmpty()) {
            characteristicName.setText(characteristics.get(0).getName());
        }
    }

    private void hideSearches() {
        authorSearch.setVisibility(View.GONE);
        publisherSearch.setVisibility(View.GONE);
        genreSearch.setVisibility(View.GONE);
        bookSerieSearch.setVisibility(View.GONE);
        characteristicSearch.setVisibility(View.GONE);
        workFormSearch.setVisibility(View.GONE);
    }

    private BookVo makeBookVo(BookStatesVo state, BookStatusVo status) {
        BookVo book = new BookVo(
                title.getText().toString(),
                UUID.randomUUID().toString(),
                state,
                status,
                publisher,
                Year.parse(yearText.getText().toString()),
                workForm,
                author,
                bookSerie,
                inventoryNumber.getText().toString(),
                isbn.getText().toString()
        );
        book.setGenres(genres);
        book.setCharacteristics(characteristics);
        return book;
    }
}