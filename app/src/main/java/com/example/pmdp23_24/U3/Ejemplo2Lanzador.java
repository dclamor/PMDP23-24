package com.example.pmdp23_24.U3;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdp23_24.R;

public class Ejemplo2Lanzador extends AppCompatActivity {

    Button btObtenerNumero;
    TextView tvNumero,tvSms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ejemplo2);
        tvNumero= findViewById(R.id.u3Ej2idTVnumero);
        btObtenerNumero=findViewById(R.id.u3Ej2idBtlanza);
        tvSms = findViewById(R.id.u3Ej2idTvSms);
        ActivityResultLauncher<Intent> lanzador = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            // Here, no request code
                            Intent data = result.getData();
                            tvNumero.setText(data.getStringExtra(Ejemplo2Lanzada.CLAVE_NUMERO));
                            tvSms.setText("");
                            tvSms.setTextColor(Color.GREEN);
                            //resultado.setText(data.getStringExtra("DATOS"));
                        } else if (result.getResultCode()==Activity.RESULT_CANCELED) {
                            tvSms.setText("El usuario ha cancelado la operación");
                            tvSms.setTextColor(Color.RED);
                        }else{
                            tvSms.setText("No obtenemos código");
                            tvSms.setTextColor(Color.RED);
                        }
                    }
                }
        );
        btObtenerNumero.setOnClickListener(view ->{
            Intent i = new Intent(this,Ejemplo2Lanzada.class);
            lanzador.launch(i);

        });
    }
}