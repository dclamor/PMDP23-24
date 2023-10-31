package com.example.pmdp23_24.U3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdp23_24.R;

public class u3a3Heladotron2 extends AppCompatActivity {
    Button btVolver;
    TextView tvDisplay;
    int totalBolas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a3_heladotron2);
        btVolver = findViewById(R.id.u3a3bIdBtVolver);
        tvDisplay = findViewById(R.id.u3a3bIdTvDisplay);
        Bundle info = getIntent().getExtras();
        int nchoco = info.getInt(u3a3Heladotron1.INFO_CHOCO);
        int nFresa = info.getInt(u3a3Heladotron1.INFO_FRESA);
        int nVainilla = info.getInt(u3a3Heladotron1.INFO_VAINILLA);
        String seleccion = info.getString(u3a3Heladotron1.INFO_RECIPIENTE);
        totalBolas = nFresa + nVainilla + nchoco;
        for (int i = 0; i < totalBolas; i++) {
            if (nchoco < 0) {
                tvDisplay.setTextColor(Color.BLACK);
                tvDisplay.setText(tvDisplay.getText() + "O");
                nchoco--;
            } else if (nFresa < 0) {
                tvDisplay.setTextColor(Color.MAGENTA);
                tvDisplay.setText(tvDisplay.getText() + "O");
                nFresa--;
            } else if (nVainilla < 0) {
                tvDisplay.setTextColor(Color.YELLOW);
                tvDisplay.setText(tvDisplay.getText() + "O");
                nVainilla--;

            }
        }
        if(seleccion.equals("Cucurucho")){
            tvDisplay.setTextColor(Color.YELLOW);
            tvDisplay.setText(tvDisplay.getText() + "\nV");
        }else if(seleccion.equals("CucuruchoChoco")) {
            tvDisplay.setTextColor(Color.BLACK);
            tvDisplay.setText(tvDisplay.getText() + "\nV");
        }else if(seleccion.equals("Tarrina")) {
            tvDisplay.setTextColor(Color.BLACK);
            tvDisplay.setText(tvDisplay.getText() + "\nU");
        }


    }
}