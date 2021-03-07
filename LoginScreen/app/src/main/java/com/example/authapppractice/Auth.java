package com.example.authapppractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Auth extends AppCompatActivity {
    TextView successEnter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        successEnter = findViewById(R.id.succussEnter);
        Intent intent = getIntent();
        String name = intent.getStringExtra("login");

        successEnter.setText(name+", вы успешно авторизировались!");
    }
}
