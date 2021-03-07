package com.example.authapppractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.SQLOutput;

public class MainActivity extends AppCompatActivity {
    EditText editLogin;
    EditText editPassword;
    Button btn_auth;
    TextView textinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editLogin = findViewById(R.id.editLogin);
        editPassword = findViewById(R.id.editPassword);
        textinfo = findViewById(R.id.textinfo);
        btn_auth = findViewById(R.id.btn_auth);
        // btn_auth.setOnClickListener(thi);
    }

    public void onClick(View v){
        Intent intent = new Intent(this, Auth.class);
        intent.putExtra("login", editLogin.getText().toString());
        intent.putExtra("pass", editPassword.getText().toString());
        String login = intent.getStringExtra("login");
        String pass = intent.getStringExtra("pass");

        if(login.equals("Torusaynim") && pass.equals("qwerty3228"))
        {
        startActivity(intent);}
        else textinfo.setText("Неправильный логин или пароль!");
    }
}
