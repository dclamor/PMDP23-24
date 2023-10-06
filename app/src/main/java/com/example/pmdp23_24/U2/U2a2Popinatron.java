package com.example.pmdp23_24.U2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.pmdp23_24.R;

public class U2a2Popinatron extends AppCompatActivity {

    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt0, btC, btR, btCalcular;
    TextView tvPropina, tvFinal;
    RadioButton rbExc, rbBien, rbMal;

    View.OnClickListener manejador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u2a2_propinator);
        bt1 = findViewById(R.id.u2aPbt1);
        bt2 = findViewById(R.id.u2aPbt2);
        bt3 = findViewById(R.id.u2aPbt3);
        bt4 = findViewById(R.id.u2aPbt4);
        bt5 = findViewById(R.id.u2aPbt5);
        bt6 = findViewById(R.id.u2aPbt6);
        bt7 = findViewById(R.id.u2aPbt7);
        bt8 = findViewById(R.id.u2aPbt8);
        bt9 = findViewById(R.id.u2aPbt9);
        bt0 = findViewById(R.id.u2aPbt0);
        btC = findViewById(R.id.u2aPbtc);
        btR = findViewById(R.id.u2aPbtr);
        btCalcular = findViewById((R.id.u2apCalcular));
        tvPropina = findViewById(R.id.u2aPtvProp);
        tvFinal = findViewById(R.id.u2aPtvFin);
        rbExc = findViewById(R.id.u2aPRbEx);
        rbBien = findViewById(R.id.u2aPRbBu);
        rbMal = findViewById(R.id.u2aPRbMa);

        manejador = ( View pulsar) -> {
            Button boton = (Button)pulsar;
            if (pulsar == btC){
                tvPropina.setText("");
            }else if (pulsar == btR){
                String numeroActual = tvPropina.getText().toString();
                String cadenaFinal = numeroActual.substring(0, (numeroActual.length()-1));
                tvPropina.setText(cadenaFinal);
            }else{
                tvPropina.append(boton.getText());
            }

        };
        bt0.setOnClickListener(manejador);
        bt1.setOnClickListener(manejador);
        bt2.setOnClickListener(manejador);
        bt3.setOnClickListener(manejador);
        bt4.setOnClickListener(manejador);
        bt5.setOnClickListener(manejador);
        bt6.setOnClickListener(manejador);
        bt7.setOnClickListener(manejador);
        bt8.setOnClickListener(manejador);
        bt9.setOnClickListener(manejador);
        btC.setOnClickListener(manejador);
        btR.setOnClickListener(manejador);

        btCalcular.setOnClickListener((View v)->{
            double propina;
            double cuenta = Double.parseDouble(tvPropina.getText().toString());
            String totalCuenta;
            if(tvFinal.getText().toString().isEmpty()){

            }else{
                if (rbBien.isChecked()){
                    propina=1.10;
                    cuenta=propina *cuenta;
                    totalCuenta= String.format("%.2f",cuenta);
                    tvFinal.setText(totalCuenta);
                }else if(rbExc.isChecked()){
                    propina=1.20;
                    cuenta=propina *cuenta;
                    totalCuenta= String.format("%.2f",cuenta);
                }
            }
        });

    }
}