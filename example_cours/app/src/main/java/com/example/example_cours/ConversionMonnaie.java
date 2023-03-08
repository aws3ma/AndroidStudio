package com.example.example_cours;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ConversionMonnaie extends AppCompatActivity {
    private Button convertir;
    private EditText value;
    private RadioGroup rg;
    private TextView res;
    private RadioButton selected,tndToEuro,euroToTnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        value = findViewById(R.id.number_to_convert);
        res = findViewById(R.id.tv_res);
        if(savedInstanceState != null) {
            value.setText(savedInstanceState.getString("value"));
            if(savedInstanceState.getInt("selected")>0) {
                selected = findViewById(savedInstanceState.getInt("selected"));
                selected.setSelected(true);
                 }
        }
        convertir=findViewById(R.id.btn_convertir);

        rg = findViewById(R.id.rg_options);

        tndToEuro = findViewById(R.id.rb_tnd_to_euro);
        euroToTnd = findViewById(R.id.rb_euro_to_tnd);
        convertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!value.getText().toString().equals("")){
                    if (rg.getCheckedRadioButtonId() == R.id.rb_euro_to_tnd) {
                        res.setText((Float.parseFloat(value.getText().toString()) * 3.34f) + "");
                    }
                    if (rg.getCheckedRadioButtonId() == R.id.rb_tnd_to_euro) {
                        res.setText((Float.parseFloat(value.getText().toString()) * 0.3f) + "");
                    }
                    Toast.makeText(ConversionMonnaie.this, res.getText().toString(), Toast.LENGTH_LONG).show();
                }else{
                    AlertDialog.Builder alert = new AlertDialog.Builder(ConversionMonnaie.this);
                    alert.setTitle("Alert");
                    alert.setMessage("remplir le champ svp");
                    alert.setPositiveButton("okay", null);
                    alert.show();
                }

            }
        });
        tndToEuro.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return false;
            }
        });
        tndToEuro.setOnCreateContextMenuListener(this);
        euroToTnd.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return false;
            }
        });
        euroToTnd.setOnCreateContextMenuListener(this);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,1,0,"Dinar → Euro");
        menu.add(0,2,0,"Euro → Dinar");

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 1:{
                Toast.makeText(ConversionMonnaie.this, "3.34", Toast.LENGTH_LONG).show();
            }break;
            case 2:{
                Toast.makeText(ConversionMonnaie.this, "0.3", Toast.LENGTH_LONG).show();
            }
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,0,"C←→F");
        menu.add(0,2,0,"Quitter");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case 1:{
                Intent i = new Intent(this,ConversionTemperature.class);
                startActivity(i);
            }break;
            case 2:{
                finishAffinity();
            }

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        outState.putString("value",value.getText().toString());
        int id = rg.getCheckedRadioButtonId();
        if(id>0)
            outState.putInt("selected",id);
        super.onSaveInstanceState(outState, outPersistentState);

    }
}