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
            Intent intent = new Intent(this, AddUser.class);
            intent.putExtra(AddUser.ROLE, RolesVo.READER);
            startActivityForResult(intent, ADD_USER_REQUEST);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_USER_REQUEST && resultCode == RESULT_OK) {
            Toast.makeText(this, "Successfully saved reader!", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "No event for the reader", Toast.LENGTH_SHORT).show();
    }

    private void addUserIntent(RolesVo rolesVo) {
        Intent intent = new Intent(this, AddUser.class);
        intent.putExtra(AddUser.ROLE, rolesVo.name());
        startActivityForResult(intent, ADD_USER_REQUEST);
    }
}
