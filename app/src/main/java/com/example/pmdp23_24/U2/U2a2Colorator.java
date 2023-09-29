package com.example.pmdp23_24.U2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.pmdp23_24.R;

public class U2a2Colorator extends AppCompatActivity {

    TextView textoBarra;
    Button botonMostrar;
    SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u2a2_colorator);

        textoBarra = findViewById(R.id.u2a2txBarra);
        botonMostrar = findViewById(R.id.u2a2btMostrar);
        seekBar = findViewById(R.id.u2a2sbColorR);

        botonMostrar.setOnClickListener((View v)->{
            textoBarra.setText(Integer.toString(seekBar.getProgress()));
        });








    }
}