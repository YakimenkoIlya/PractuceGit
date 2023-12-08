package com.yakimenko.lessonhomework3fake3;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class AddStoreActivity extends AppCompatActivity {
    private EditText nameEdt, addressEdt;
    private Button okBtn, backBtn;
    private AddStore addStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_provider);

        nameEdt = findViewById(R.id.nameEditText);
        addressEdt = findViewById(R.id.addressEditText);
        okBtn = findViewById(R.id.okBtn);
        backBtn = findViewById(R.id.cancelBtn);

        addStore = new AddStore(AddStoreActivity.this);

        okBtn.setOnClickListener(v -> {

            String storeName = nameEdt.getText().toString();
            String storeAddress = addressEdt.getText().toString();

            if (storeName.isEmpty() || storeAddress.isEmpty()) {
                Toast.makeText(AddStoreActivity.this, "Заполните все поля", Toast.LENGTH_SHORT).show();
                return;
            }

            addStore.addStore(storeAddress, storeName);

            Toast.makeText(AddStoreActivity.this, "Точка сбыта была добавлена", Toast.LENGTH_SHORT).show();
            addressEdt.setText("");
            nameEdt.setText("");
        });

        backBtn.setOnClickListener(v -> {

            Intent i = new Intent(AddStoreActivity.this, GeneralView.class);
            startActivity(i);
        });
    }
}
