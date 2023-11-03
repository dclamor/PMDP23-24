package com.example.pmdp23_24.U3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdp23_24.R;

public class u3a6Mapa_B extends AppCompatActivity {

    public static final String CLAVE_CARACTERES ="ArrayCaracteres" ;
    TextView tvAnalisis;
    Button btVolver;
    String ArrayCaracteres[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a6_mapa_b);
        tvAnalisis = findViewById(R.id.u3a6BidTvAnalisis);
        btVolver = findViewById(R.id.u3a6BidBtVolver);
    }
}