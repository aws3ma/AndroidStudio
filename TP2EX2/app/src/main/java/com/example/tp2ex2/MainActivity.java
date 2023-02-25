package com.example.tp2ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    final String USER="admin";
    final String PASSWORD="admin";
    EditText login,password;
    Button ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ok=findViewById(R.id.btnOk);
        login = findViewById(R.id.etdLogin);
        password = findViewById(R.id.etdPassword);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(USER.equals(login.getText().toString()) && PASSWORD.equals(password.getText().toString())){
                    Intent i=new Intent(getApplicationContext(),InscriptionActivity.class);
                    i.putExtra("user",USER);
                    startActivity(i);
                }
            }
        });

    }
}