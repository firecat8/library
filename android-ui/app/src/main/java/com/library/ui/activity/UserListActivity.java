package com.library.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.library.rest.api.vo.user.UserVo;
import com.library.ui.R;
import com.library.ui.adapter.UserAdapter;
import com.library.ui.view_model.UserViewModel;

import java.util.List;

public class UserListActivity extends AppCompatActivity {
    public static final int ADD_REQUEST = 1;
    public static final int EDIT_REQUEST = 2;

    private UserAdapter userAdapter;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        FloatingActionButton buttonAddNote = findViewById(R.id.button_add_user);
        buttonAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserListActivity.this, AddEditUser.class);
                intent.putExtras(getIntent());
                startActivityForResult(intent, ADD_REQUEST);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.users_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        userAdapter = new UserAdapter();
        recyclerView.setAdapter(userAdapter);

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        getAllUsers();

        userAdapter.setOnItemClickListener(new UserAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(UserVo user) {
                Intent intent = new Intent(UserListActivity.this, AddEditUser.class);

                intent.putExtra(AddEditUser.EXTRA_USER, user);

                startActivityForResult(intent, EDIT_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        getAllUsers();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout_now:
                logoutNow();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void logoutNow() {
        Intent intent = new Intent(UserListActivity.this, LoginActivity.class);
        startActivity(intent);
        setResult(Activity.RESULT_OK);
        finish();
    }

    private void getAllUsers() {
        userViewModel.loadAll().observe(this, new Observer<List<UserVo>>() {
            @Override
            public void onChanged(@Nullable List<UserVo> users) {
                userAdapter.submitList(users);
            }
        });
    }
}
