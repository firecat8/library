package com.library.ui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.library.rest.api.request.LoginRequest;
import com.library.rest.api.vo.user.UserVo;
import com.library.ui.R;
import com.library.ui.request.RequestFactory;
import com.library.ui.request.URL_CONSTANTS;
import com.library.ui.volley.VolleySingelton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    RequestQueue requestQueue;
    String endpointLogin = "http://10.0.2.2:8000/user/login";
    private EditText username;
    private EditText password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.button_submit);
        username = findViewById(R.id.edit_username);
        password = findViewById(R.id.edit_pass);

        login.setOnClickListener(v -> {
            try {
                login();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });

    }


    private void login() throws JSONException {
        if (username.getText().equals("") || password.getText().equals("")) {
            Toast.makeText(LoginActivity.this, "Invalid username and password! ", Toast.LENGTH_LONG).show();
            return;
        }
        RequestFactory.getInstance(this).makeLoginRequest(URL_CONSTANTS.USER_URL,
                new LoginRequest(username.getText().toString(),password.getText().toString()),
                new Response.Listener<UserVo>() {
            @Override
            public void onResponse(UserVo response) {
                Toast.makeText(LoginActivity.this, response.getFirstName(), Toast.LENGTH_LONG).show();
            }
        });
    }

}
