package com.example.pmdp23_24.U3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.pmdp23_24.R;



public class Ejemplo2Lanzada extends AppCompatActivity {
    public static final String CLAVE_NUMERO = "LOQUESEA";
    Button btAceptar,btCancelar;
    EditText etNumero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ejemplo2_lanzada);
        btAceptar = findViewById(R.id.u3Ej2idBtAceptar);
        btCancelar = findViewById(R.id.u3Ej2idBtCancelar);
        etNumero = findViewById(R.id.editTextText);
        btAceptar.setOnClickListener(view -> {
            Intent data = new Intent();
            data.putExtra(CLAVE_NUMERO,etNumero.getText().toString());
            setResult(Activity.RESULT_OK,data);
            //no hacer startActivity
            finish();
        });
        btCancelar.setOnClickListener(view -> {


            setResult(Activity.RESULT_CANCELED);
            //no hacer startActivity
            finish();
        });
    }
}