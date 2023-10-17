package com.example.pmdp23_24.U3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.pmdp23_24.R;

public class u3a1bLanzada extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut3a1b_lanzada);
        Bundle info = getIntent().getExtras();
        String sInfo = info.getString(u3a1aLanza.INFO_NOMBRE);


    }
}