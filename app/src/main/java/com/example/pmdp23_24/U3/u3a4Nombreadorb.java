package com.example.pmdp23_24.U3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.pmdp23_24.R;

import org.w3c.dom.Text;

public class u3a4Nombreadorb extends AppCompatActivity {

    public static final String CLAVE_NOMBRE ="LOQUESEA" ;
    EditText etNombre;
    Button btAceptar,btCancelar,btLimpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a4_nombreadorb);
        etNombre= findViewById(R.id.u3a4bIdEtNombre);
        btAceptar= findViewById(R.id.u3a4bIdlbtAceptar);
        btCancelar= findViewById(R.id.u3a4bIdlbtCancelar);
        btLimpiar= findViewById(R.id.u3a4bIdlbtLimpiar);
        Bundle info = getIntent().getExtras();
        String nombre = info.getString(U3a4Nombreador.CLAVE_EDICION);
        etNombre.setText(nombre);

        btAceptar.setOnClickListener(view ->{
            Intent data = new Intent();
            data.putExtra(CLAVE_NOMBRE,etNombre.getText().toString());
            setResult(Activity.RESULT_OK,data);
            //no hacer startActivity
            finish();
        });
        btLimpiar.setOnClickListener(view ->{
            Intent data = new Intent();
            etNombre.setText("");
            data.putExtra(CLAVE_NOMBRE,etNombre.getText().toString());
            setResult(Activity.RESULT_OK,data);
            //no hacer startActivity
            finish();
        });
        btCancelar.setOnClickListener(view ->{

            setResult(Activity.RESULT_CANCELED);
            //no hacer startActivity
            finish();
        });
    }
}