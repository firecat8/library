package com.library.ui.login;

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
import com.library.ui.R;
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


        username.setText("admin");
        password.setText("admin");

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

        requestQueue = VolleySingelton.getInstance(this).getRequestQueue();
        requestQueue.add(makeRequest());
    }

    private JsonObjectRequest makeRequest() throws JSONException {
        JSONObject request = new JSONObject();
        request.put("username", username.getText().toString());
        request.put("password", password.getText().toString());

        return new JsonObjectRequest(Request.Method.POST, endpointLogin,
                request, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(LoginActivity.this, response.toString(), Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(LoginActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };
    }

}
