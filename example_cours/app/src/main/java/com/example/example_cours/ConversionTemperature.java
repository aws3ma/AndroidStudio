package com.example.example_cours;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class ConversionTemperature extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_temperature);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,0,"Euro←→Dinar");
        menu.add(0,2,0,"Quitter");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case 1:{
                Intent i = new Intent(this,ConversionMonnaie.class);
                startActivity(i);
            }break;
            case 2:{
                finishAffinity();
            }

        }
        return super.onOptionsItemSelected(item);
    }
}