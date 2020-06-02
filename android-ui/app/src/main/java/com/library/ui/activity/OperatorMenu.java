package com.library.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.library.rest.api.vo.user.RolesVo;
import com.library.ui.R;

public class OperatorMenu extends AppCompatActivity {

    public static final int ADD_USER_REQUEST = 1;
    public static final int ADD_BOOK_REQUEST = 2;
    public static final int ADD_RENT_BOOK_REQUEST = 3;

    private Button addBookButton;
    private Button rentBookButton;
    private Button addReaderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operator_menu);
        addBookButton = findViewById(R.id.add_new_book_btn);
        rentBookButton = findViewById(R.id.rent_book_btn);
        addReaderButton = findViewById(R.id.add_reader_btn);
        addReaderButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddEditUser.class);
            intent.putExtra(AddEditUser.EXTRA_ROLE, RolesVo.READER);
            intent.putExtra(AddEditUser.EXTRA_MODE, AddEditUser.ADD_READER_FORM_MODE);
            startActivityForResult(intent, ADD_USER_REQUEST);
        });
        addBookButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddEditBook.class);
            intent.putExtra(AddEditBook.EXTRA_MODE, AddEditBook.CREATE_MODE);
            startActivityForResult(intent, ADD_BOOK_REQUEST);
        });
        rentBookButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddEditBookRent.class);
           // intent.putExtra(AddEditBookRent.EXTRA_MODE, AddEditBookRent.);
            startActivityForResult(intent, ADD_RENT_BOOK_REQUEST);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_USER_REQUEST && resultCode == RESULT_OK) {
            Toast.makeText(this, "Successfully saved reader!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (requestCode == ADD_BOOK_REQUEST && resultCode == RESULT_OK) {
            Toast.makeText(this, "Successfully added book!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (requestCode == ADD_RENT_BOOK_REQUEST && resultCode == RESULT_OK) {
            Toast.makeText(this, "Successfully rent book!", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "No event for the menu request", Toast.LENGTH_SHORT).show();
    }

    private void addUserIntent(RolesVo rolesVo) {
        Intent intent = new Intent(this, AddEditUser.class);
        intent.putExtra(AddEditUser.EXTRA_ROLE, rolesVo.name());
        startActivityForResult(intent, ADD_USER_REQUEST);
    }
}
