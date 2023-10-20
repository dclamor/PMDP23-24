package com.example.pmdp23_24.U3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.pmdp23_24.R;

public class u3a3Heladotron1 extends AppCompatActivity {

    public static final String INFO_CHOCO="numChoco";
    public static final String INFO_VAINILLA="numVainilla";
    public static final String INFO_FRESA="numFresa";
    public static final String INFO_RECIPIENTE="recipiente";

    Spinner spRecipiente;
    TextView udVainilla,udFresa,udChoco;
    Button btGenerar;
    int numChoco;
    int numVainilla;
    int numFresa;
    String recipiente;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a3_heladotron1);

        udFresa = findViewById(R.id.u3a3idTxFresa);
        udChoco = findViewById(R.id.u3a3idTxChoco);
        udVainilla = findViewById(R.id.u3a3idTxVainilla);

        spRecipiente = (Spinner) findViewById(R.id.u3a3SpRecipiente);

// Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.arrayRecipientes,
                android.R.layout.simple_spinner_item
        );
// Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner.
        spRecipiente.setAdapter(adapter);
        spRecipiente.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){


            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

               recipiente=adapterView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btGenerar = findViewById(R.id.u3a3idBtGenerar);
        btGenerar.setOnClickListener(view ->
        {
            numChoco=Integer.parseInt(udChoco.getText().toString());
            Intent i = new Intent(this, u3a3Heladotron2.class);
            i.putExtra(INFO_CHOCO,numChoco);
            i.putExtra(INFO_VAINILLA,numVainilla);
            i.putExtra(INFO_FRESA,numFresa);
            i.putExtra(INFO_RECIPIENTE,recipiente);
        });

    }

}