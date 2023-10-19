package com.example.pmdp23_24.U3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.pmdp23_24.R;

public class u3a2aCalculadora extends AppCompatActivity {

    public static final String INFO_NUM1="num1";
    public static final String INFO_NUM2="num2";
    public static final String INFO_OPERANDO="operando";
    public static final String NUMERO_NO_INTRODUCIDO="Introduzca un número";
    public static final String RB_NO_SELECCIONADO="Seleccione una opción";


    TextView tvOp1,tvOp2,tvErr1,tvErr2;

    Button btCalcular;
    RadioGroup grpOperacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.u3a2a_calculadora);
        tvOp1 = findViewById(R.id.u3a2idTvOp1);
        tvOp2 = findViewById(R.id.u3a2idTvOp2);
        tvErr1 = findViewById(R.id.u3a2Tverr1);
        tvErr1 = findViewById(R.id.u3a2Tverr2);

        int idSelect = grpOperacion.getCheckedRadioButtonId();
        RadioButton selectedRadiobt = findViewById(idSelect);
        String operacion = selectedRadiobt.getText().toString();

        btCalcular.setOnClickListener(view -> {

            Intent i = new Intent(this, u3a2bResultado.class);

            i.putExtra(INFO_NUM1,tvOp1.getText());
            i.putExtra(INFO_NUM2,tvOp2.getText());
            i.putExtra(INFO_OPERANDO,operacion);
            startActivity(i);
        });
    }

}