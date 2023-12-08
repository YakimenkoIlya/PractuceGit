package com.yakimenko.lessonhomework3fake3;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class AddProductActivity extends AppCompatActivity {
    private EditText nameEdt, typeEdt, providerEdt, storeEdt;
    private Button okBtn, backBtn;
    private AddProduct addProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        nameEdt = findViewById(R.id.productNameEditText);
        typeEdt = findViewById(R.id.typeEditText);
        providerEdt = findViewById(R.id.providerEditText);
        storeEdt = findViewById(R.id.storeEditText);

        okBtn = findViewById(R.id.okBtn);
        backBtn = findViewById(R.id.cancelBtn);

        addProduct = new AddProduct(AddProductActivity.this);

        okBtn.setOnClickListener(v -> {

            String name = nameEdt.getText().toString();
            String type = typeEdt.getText().toString();
            String provider = providerEdt.getText().toString();
            String store = storeEdt.getText().toString();

            if (name.isEmpty() || type.isEmpty() || provider.isEmpty() || store.isEmpty()) {
                Toast.makeText(AddProductActivity.this, "Заполните все поля", Toast.LENGTH_SHORT).show();
                return;
            }

            addProduct.addProduct(store, provider, type, name);

            Toast.makeText(AddProductActivity.this, "Товар был добавлен", Toast.LENGTH_SHORT).show();
            typeEdt.setText("");
            nameEdt.setText("");
            providerEdt.setText("");
            storeEdt.setText("");
        });

        backBtn.setOnClickListener(v -> {

            Intent i = new Intent(AddProductActivity.this, GeneralView.class);
            startActivity(i);
        });
    }
}