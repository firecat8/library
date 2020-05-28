package com.library.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Response;
import com.library.rest.api.request.LoginRequest;
import com.library.rest.api.vo.user.RolesVo;
import com.library.rest.api.vo.user.UserVo;
import com.library.ui.R;
import com.library.ui.request.RequestFactory;
import com.library.ui.request.URL_CONSTANTS;


public class LoginActivity extends AppCompatActivity {
    public static final int ADD_USER_REQUEST = 1;
    private EditText username;
    private EditText password;
    private Button login;
    private Button regFormButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.button_submit);
        regFormButton = findViewById(R.id.reg_form_btn);
        username = findViewById(R.id.edit_username);
        password = findViewById(R.id.edit_pass);
        username.setText("User6646220453");
        password.setText("8NKLVcM1cu");
        login.setOnClickListener(v -> {
            login();
        });
        regFormButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddEditUser.class);
            intent.putExtra(AddEditUser.ROLE, RolesVo.READER);
            startActivityForResult(intent, ADD_USER_REQUEST);
        });

    }


    private void login() {
        if (username.getText().toString().equals("") || password.getText().toString().equals("")) {
            Toast.makeText(LoginActivity.this, "Invalid username and password! ", Toast.LENGTH_LONG).show();
            return;
        }
        RequestFactory.getInstance(this).makeLoginRequest(
                URL_CONSTANTS.USER_URL,
                new LoginRequest(username.getText().toString(), password.getText().toString()),
                new Response.Listener<UserVo>() {
                    @Override
                    public void onResponse(UserVo user) {
                        RolesVo role = user.getRole();
                        Toast.makeText(LoginActivity.this, " user role " + user.getRole().name(), Toast.LENGTH_LONG).show();
                        if (role.ordinal() == RolesVo.ADMINISTRATOR.ordinal()) {
                            goToUserMenu(AdminMenuActivity.class);
                            return;
                        }
                        if (role.ordinal() == RolesVo.OPERATOR.ordinal()) {
                            goToUserMenu(OperatorMenu.class);
                            return;
                        }
                        if (role.ordinal() == RolesVo.READER.ordinal()) {
                            return;
                        }
                        Toast.makeText(LoginActivity.this, "Unrecognized user role " + user.getRole().name(), Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    private void goToUserMenu(Class<?> userMenuClass) {
        Intent intent = new Intent(this, userMenuClass);
        startActivity(intent);
    }

}
