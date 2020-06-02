package com.library.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.library.ui.R;
import com.library.ui.adapter.CharacteristicAdapter;
import com.library.ui.view_model.CharacteristicViewModel;

public class CharacteristicListActivity extends AppCompatActivity {

    public static final int CREATE_REQUEST = 1;
    public static final int EDIT_REQUEST = 2;

    private CharacteristicAdapter characteristicAdapter;
    private CharacteristicViewModel characteristicViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characteristic_list);

        FloatingActionButton buttonAddNote = findViewById(R.id.button_add_characteristic);
        buttonAddNote.setOnClickListener(v -> {
            Intent intent = new Intent(CharacteristicListActivity.this, AddEditCharacteristic.class);
            intent.putExtras(getIntent());
            startActivityForResult(intent, CREATE_REQUEST);
        });

        RecyclerView recyclerView = findViewById(R.id.book_series_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        characteristicAdapter = new CharacteristicAdapter();
        recyclerView.setAdapter(characteristicAdapter);

        characteristicViewModel = new ViewModelProvider(this).get(CharacteristicViewModel.class);
        getAllCharacteristics();

        characteristicAdapter.setOnItemClickListener(characteristic -> {
            Intent intent = new Intent(CharacteristicListActivity.this, AddEditCharacteristic.class);

            intent.putExtra(AddEditCharacteristic.EXTRA_ENTITY, characteristic);

            startActivityForResult(intent, EDIT_REQUEST);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        getAllCharacteristics();
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
        Intent intent = new Intent(CharacteristicListActivity.this, LoginActivity.class);
        startActivity(intent);
        setResult(Activity.RESULT_OK);
        finish();
    }

    private void getAllCharacteristics() {
        characteristicViewModel.loadAll().observe(this, characteristics -> characteristicAdapter.submitList(characteristics));
    }
}