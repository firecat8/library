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
import com.library.ui.adapter.PublisherAdapter;
import com.library.ui.view_model.PublisherViewModel;

public class PublisherListActivity extends AppCompatActivity {
    public static final int ADD_REQUEST = 1;
    public static final int EDIT_REQUEST = 2;

    private PublisherAdapter publisherAdapter;
    private PublisherViewModel publisherViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publisher_list);

        FloatingActionButton buttonAddNote = findViewById(R.id.button_add_publisher);
        buttonAddNote.setOnClickListener(v -> {
            Intent intent = new Intent(PublisherListActivity.this, AddEditPublisher.class);
            intent.putExtras(getIntent());
            startActivityForResult(intent, ADD_REQUEST);
        });

        RecyclerView recyclerView = findViewById(R.id.book_series_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        publisherAdapter = new PublisherAdapter();
        recyclerView.setAdapter(publisherAdapter);

        publisherViewModel = new ViewModelProvider(this).get(PublisherViewModel.class);
        getAllPublishers();

        publisherAdapter.setOnItemClickListener(publisher -> {
            Intent intent = new Intent(PublisherListActivity.this, AddEditPublisher.class);

            intent.putExtra(AddEditPublisher.EXTRA_ENTITY, publisher);

            startActivityForResult(intent, EDIT_REQUEST);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        getAllPublishers();
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
        Intent intent = new Intent(PublisherListActivity.this, LoginActivity.class);
        startActivity(intent);
        setResult(Activity.RESULT_OK);
        finish();
    }

    private void getAllPublishers() {
        publisherViewModel.loadAll().observe(this, publishers -> publisherAdapter.submitList(publishers));
    }
}