package com.example.tp2ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InscriptionActivity extends AppCompatActivity {
    Button valider;
    EditText nom,prenom,age;
    TextView bonjour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        valider = findViewById(R.id.btnValider);
        nom = findViewById(R.id.etdNom);
        prenom = findViewById(R.id.etdPrenom);
        age = findViewById(R.id.etdAge);
        bonjour = findViewById(R.id.tvBonjour);
        Intent i = getIntent();
        bonjour.setText("Bonjour "+i.getStringExtra("user"));
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert=new AlertDialog.Builder(InscriptionActivity.this);
                alert.setTitle("Nom");
                alert.setMessage(nom.getText().toString());
                alert.setPositiveButton("next", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AlertDialog.Builder alert2=new AlertDialog.Builder(InscriptionActivity.this);
                        alert2.setTitle("Prenom");
                        alert2.setMessage(prenom.getText().toString());
                        alert2.setPositiveButton("next", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                AlertDialog.Builder alert3=new AlertDialog.Builder(InscriptionActivity.this);
                                alert3.setTitle("Age");
                                alert3.setMessage(age.getText().toString());
                                alert3.setPositiveButton("finish", null);
                                alert3.show();
                            }
                        });
                        alert2.show();
                    }
                });
                alert.show();
            }
        });

    }
}