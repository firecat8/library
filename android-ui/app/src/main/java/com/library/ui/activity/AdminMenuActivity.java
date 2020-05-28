package com.library.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.library.rest.api.vo.user.RolesVo;
import com.library.ui.R;

public class AdminMenuActivity extends AppCompatActivity {

    public static final int ADD_USER_REQUEST = 1;

    private Button addAdminButton;
    private Button addOperatorButton;
    private Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_menu_activity);

        addAdminButton = findViewById(R.id.add_admin__btn);
        addOperatorButton = findViewById(R.id.add_op_btn);
        logoutButton = findViewById(R.id.logout_btn);

        addAdminButton.setOnClickListener(v -> {
            addUserIntent(RolesVo.ADMINISTRATOR);
        });
        addOperatorButton.setOnClickListener(v -> {
            addUserIntent(RolesVo.OPERATOR);
        });
        logoutButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_USER_REQUEST && resultCode == RESULT_OK) {
            Toast.makeText(this, "Successfully saved user!", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, "No event for the user", Toast.LENGTH_SHORT).show();
    }

    private void addUserIntent(RolesVo rolesVo) {
        Intent intent = new Intent(this, AddUser.class);
        intent.putExtra(AddUser.ROLE, rolesVo.name());
        startActivityForResult(intent, ADD_USER_REQUEST);
    }
}
