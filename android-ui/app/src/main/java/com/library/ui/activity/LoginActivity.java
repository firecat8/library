package com.library.ui.activity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.library.rest.api.vo.user.RolesVo;
import com.library.rest.api.vo.user.UserVo;
import com.library.ui.CashedDetails;
import com.library.ui.R;
import com.library.ui.request.RequestFactory;
import com.library.ui.request.URL_CONSTANTS;

public class LoginActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private CashedDetails details = CashedDetails.INSTANCE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button login = findViewById(R.id.button_submit);
        username = findViewById(R.id.edit_username);
        password = findViewById(R.id.edit_pass);
        username.setText(details.getUsername());
        password.setText(details.getPassword());
        login.setOnClickListener(v -> {
            login();
        });

    }

    private void login() {
        String userName = username.getText().toString();
        String pass = password.getText().toString();
        if (userName.equals("") || pass.equals("")) {
            Toast.makeText(LoginActivity.this, "Invalid username and password! ", Toast.LENGTH_LONG).show();
            return;
        }
        details.setUsername(userName);
        details.setPassword(pass);
        RequestFactory.getInstance(this).makeLoadRequest(
                URL_CONSTANTS.USER_URL,
                username.getText().toString(),
                UserVo.class,
                user -> {
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
        );
    }

    private void goToUserMenu(Class<?> userMenuClass) {
        Intent intent = new Intent(this, userMenuClass);
        startActivity(intent);
    }

}
