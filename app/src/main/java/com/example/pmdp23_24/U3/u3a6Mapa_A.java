package com.example.pmdp23_24.U3;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pmdp23_24.R;

    public class u3a6Mapa_A extends AppCompatActivity {
        public static final String CLAVE_TEXTO = "VALOR_TEXTO";
        TextView tvSms,tvResultado;
        EditText tvEntrada;
        Button btAnalizar;
        ActivityResultLauncher<Intent> lanzador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a6_mapa_a);
        tvSms = findViewById(R.id.u3a6idTvSms);
        tvResultado = findViewById(R.id.u3a6idTvResultado);
        btAnalizar = findViewById(R.id.u3a6idBtAnalizar);
        tvEntrada = findViewById(R.id.u3a6idEtEntrada);
        lanzador = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        String[] caracteres = data.getStringArrayExtra(u3a6Mapa_B.CLAVE_CARACTERES);
                        tvResultado.setText("Caracteres más utilizados:\n");
                        for (String cadena:caracteres
                             ) {
                            tvResultado.setText(tvResultado.getText()+cadena+"\n");
                        }

                        tvSms.setText("Analisís realizado!");
                        tvSms.setTextColor(Color.GREEN);
                    } else {
                        tvSms.setText("El usuario ha cancelado la operación :(");
                        tvSms.setTextColor(Color.RED);
                    }
                });
        btAnalizar.setOnClickListener(view -> {

            Intent i = new Intent(this, u3a6Mapa_B.class);
            i.putExtra(CLAVE_TEXTO,tvEntrada.getText().toString());

            lanzador.launch(i);
        });


    }
}