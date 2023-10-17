package com.example.pmdp23_24.U3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.pmdp23_24.R;

public class u3a1aLanza extends AppCompatActivity {
    public static final String INFO_NOMBRE="CLAVE_NOMBRE";
    Button btLanza;
    EditText etNombre;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ut3a1a);
        etNombre = findViewById(R.id.u3a1idEtnombre);
        btLanza = findViewById(R.id.u3a1aBtLanzador);
        btLanza.setOnClickListener(view -> {
            Intent i = new Intent(this, u3a1bLanzada.class);
            i.putExtra(INFO_NOMBRE,etNombre.getText().toString());
            startActivity(i);
        });
    }
}