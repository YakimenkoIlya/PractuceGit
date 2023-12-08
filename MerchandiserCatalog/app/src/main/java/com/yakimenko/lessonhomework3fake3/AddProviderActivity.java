package com.yakimenko.lessonhomework3fake3;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class AddProviderActivity extends AppCompatActivity {
    private EditText nameEdt, addressEdt;
    private Button okBtn, backBtn;
    private AddProvider addProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_provider);

        nameEdt = findViewById(R.id.nameEditText);
        addressEdt = findViewById(R.id.addressEditText);
        okBtn = findViewById(R.id.okBtn);
        backBtn = findViewById(R.id.cancelBtn);

        addProvider = new AddProvider(AddProviderActivity.this);

        okBtn.setOnClickListener(v -> {

            String providerName = nameEdt.getText().toString();
            String providerAddress = addressEdt.getText().toString();

            if (providerName.isEmpty() || providerAddress.isEmpty()) {
                Toast.makeText(AddProviderActivity.this, "Заполните все поля", Toast.LENGTH_SHORT).show();
                return;
            }

            addProvider.addProvider(providerAddress, providerName);

            Toast.makeText(AddProviderActivity.this, "Поставщик был добавлен", Toast.LENGTH_SHORT).show();
            addressEdt.setText("");
            nameEdt.setText("");
        });

        backBtn.setOnClickListener(v -> {

            Intent i = new Intent(AddProviderActivity.this, GeneralView.class);
                startActivity(i);
        });
    }
}