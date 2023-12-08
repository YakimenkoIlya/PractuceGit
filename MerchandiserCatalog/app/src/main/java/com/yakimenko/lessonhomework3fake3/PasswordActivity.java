package com.yakimenko.lessonhomework3fake3;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class PasswordActivity extends AppCompatActivity {

    private EditText passwordEdt;
    private Button okBtn;
    private final String PASSWORD = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_word);

        passwordEdt = findViewById(R.id.editTextTextPassword);
        okBtn = findViewById(R.id.okPasswordBtn);

        okBtn.setOnClickListener(v -> {

            if(passwordEdt.getText().toString().equals(PASSWORD)){

                Intent i = new Intent(PasswordActivity.this, GeneralView.class);
                startActivity(i);
            }
            else {

                Toast.makeText(PasswordActivity.this, "Пароль не верный", Toast.LENGTH_SHORT).show();
            }
        });
    }
}