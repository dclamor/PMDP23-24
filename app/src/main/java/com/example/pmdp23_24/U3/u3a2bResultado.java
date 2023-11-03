package com.example.pmdp23_24.U3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.pmdp23_24.R;

public class u3a2bResultado extends AppCompatActivity {
    double resultado;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a2b_resultado);


        Bundle info = getIntent().getExtras();
        String op1 = info.getString(u3a2aCalculadora.INFO_NUM1);
        String op2 = info.getString(u3a2aCalculadora.INFO_NUM2);
        String operacion = info.getString(u3a2aCalculadora.INFO_OPERANDO);

        TextView tv = findViewById(R.id.u3a2tvResultado);
        tv.setText(String.valueOf(resultado));


    }
}