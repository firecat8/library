package com.library.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.library.ui.R;
import com.library.ui.adapter.WorkFormAdapter;
import com.library.ui.view_model.WorkFormViewModel;

public class WorkFormListActivity extends AppCompatActivity {
    public static final int ADD_REQUEST = 1;
    public static final int EDIT_REQUEST = 2;

    private WorkFormAdapter workFormAdapter;
    private WorkFormViewModel workFormViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_form_list);

        FloatingActionButton buttonAddNote = findViewById(R.id.button_add_work_form);
        buttonAddNote.setOnClickListener(v -> {
            Intent intent = new Intent(WorkFormListActivity.this, AddEditWorkForm.class);
            intent.putExtras(getIntent());
            startActivityForResult(intent, ADD_REQUEST);
        });

        RecyclerView recyclerView = findViewById(R.id.book_series_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        workFormAdapter = new WorkFormAdapter();
        recyclerView.setAdapter(workFormAdapter);

        workFormViewModel = new ViewModelProvider(this).get(WorkFormViewModel.class);
        getAllWorkForms();

        workFormAdapter.setOnItemClickListener(workForm -> {
            Intent intent = new Intent(WorkFormListActivity.this, AddEditWorkForm.class);

            intent.putExtra(AddEditWorkForm.EXTRA_ENTITY, workForm);

            startActivityForResult(intent, EDIT_REQUEST);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        getAllWorkForms();
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
        Intent intent = new Intent(WorkFormListActivity.this, LoginActivity.class);
        startActivity(intent);
        setResult(Activity.RESULT_OK);
        finish();
    }

    private void getAllWorkForms() {
        workFormViewModel.loadAll().observe(this, workForms -> workFormAdapter.submitList(workForms));
    }
}