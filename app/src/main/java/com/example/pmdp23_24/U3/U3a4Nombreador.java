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

public class U3a4Nombreador extends AppCompatActivity {

    public static final String CLAVE_EDICION = "NOMBREAEDITAR";
    TextView tvSms, tvNombre;
    Button btEditar;
    ActivityResultLauncher<Intent> lanzador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a4_nombreador);
        tvNombre = findViewById(R.id.u3a4IdTvNombre);
        tvSms = findViewById((R.id.u3a4bIdlTvSms));
        btEditar = findViewById(R.id.u3a4IdbtEditar);
        lanzador = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            // Here, no request code
                            Intent data = result.getData();
                            tvNombre.setText(data.getStringExtra(u3a4Nombreadorb.CLAVE_NOMBRE));
                            if (data.getStringExtra(u3a4Nombreadorb.CLAVE_NOMBRE).equals("")) {
                                tvSms.setText("Nombre Limpiado");
                                tvSms.setTextColor(Color.GREEN);
                            }
                        } else if (result.getResultCode() == Activity.RESULT_CANCELED) {
                            tvSms.setText("El usuario ha cancelado la operación");
                            tvSms.setTextColor(Color.RED);

                        } else {
                            tvSms.setText("No se seleccionó una opción");
                            tvSms.setTextColor(Color.RED);
                        }
                    }
                }
        );

        btEditar.setOnClickListener(view -> {
            Intent i = new Intent(this, u3a4Nombreadorb.class);
            i.putExtra(CLAVE_EDICION, tvNombre.getText().toString());
            lanzador.launch(i);

        });
    }
}