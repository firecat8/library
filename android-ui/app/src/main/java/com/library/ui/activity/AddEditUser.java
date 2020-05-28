package com.library.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.android.volley.Response;
import com.library.rest.api.request.UserRequest;
import com.library.rest.api.response.SuccessResponse;
import com.library.rest.api.vo.user.RolesVo;
import com.library.rest.api.vo.user.UserVo;
import com.library.ui.R;
import com.library.ui.Utils;
import com.library.ui.request.RequestFactory;
import com.library.ui.request.URL_CONSTANTS;
import com.library.ui.view_model.UserViewModel;

import java.util.Calendar;

public class AddEditUser extends AppCompatActivity {
    public static final String ROLE = "com.library.user.ROLE";
    public static final String USER = "com.library.user.USER";

    private Calendar date = Calendar.getInstance();
    private UserViewModel userViewModel;

    private EditText reg_date;
    private EditText firstName;
    private EditText surname;
    private EditText lastName;
    private EditText email;
    private EditText phone;
    private EditText username;
    private EditText password;
    private Button addUserButton;
    private String role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        Intent intent = getIntent();
        role = intent.getStringExtra(ROLE);
        date.set(Calendar.SECOND, 0);

        reg_date = findViewById(R.id.reg_date);
        firstName = findViewById(R.id.first_name);
        surname = findViewById(R.id.surname);
        lastName = findViewById(R.id.last_name);
        email = findViewById(R.id.editTextTextEmailAddress);
        phone = findViewById(R.id.editTextPhone);
        username = findViewById(R.id.edit_username);
        password = findViewById(R.id.edit_pass);
        username.setText(Utils.generateUsername("User", 10));
        password.setText(Utils.generatePassword(10));
        addUserButton = findViewById(R.id.add_user_button);

        reg_date.setText(Utils.formatDate(date.getTimeInMillis()));
        reg_date.setVisibility(View.GONE);

        if (role != null && role.equals(RolesVo.READER.name())) {
            setTitle("Reader form");
            addUserButton.setText("Send");
        } else {
            setTitle("Add user");
            addUserButton.setText("Add");
        }

        addUserButton.setOnClickListener(v -> {
            userViewModel.save(makeUserVo()).observe(this, new Observer<UserVo>() {
                @Override
                public void onChanged(@Nullable UserVo insertedUser) {
                    setResult(RESULT_OK, new Intent());
                    finish();
                }
            });
        });


        Toast.makeText(this, "User role " + role, Toast.LENGTH_SHORT).show();
    }


    private UserVo makeUserVo() {
        return new UserVo(
                username.getText().toString(),
                password.getText().toString(),
                email.getText().toString(),
                RolesVo.valueOf(role),
                firstName.getText().toString(),
                surname.getText().toString(),
                lastName.getText().toString(),
                phone.getText().toString(),
                date
        );
    }
}