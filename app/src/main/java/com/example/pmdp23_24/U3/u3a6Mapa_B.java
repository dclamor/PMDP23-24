package com.example.pmdp23_24.U3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdp23_24.R;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class u3a6Mapa_B extends AppCompatActivity {

    public static final String CLAVE_CARACTERES ="ArrayCaracteres" ;
    TextView tvAnalisis;
    Button btVolver;
    LinkedHashMap<Character,Integer> mapa;

    private static final int LETRAS_MOSTRADAS = 3;


    private static final String REGEX = "[.,\\/#!$%\\^&\\*;:{}=\\-_`~()”“\"…\n123456789]";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a6_mapa_b);
        Bundle info = getIntent().getExtras();
        String frase = info.getString(u3a6Mapa_A.CLAVE_TEXTO);

        tvAnalisis = findViewById(R.id.u3a6BidTvAnalisis);
        btVolver = findViewById(R.id.u3a6BidBtVolver);
        frase = frase.replace(" ","")
                .replaceAll(REGEX,"")
                .toLowerCase();
        mapa = new LinkedHashMap<>();
        if (!frase.isEmpty()){
            int i=0;
            while(i<frase.length()){
                char letra = frase.charAt(i);
                if (mapa.containsKey(letra)){
                    mapa.put(letra,mapa.get(letra)+1);
                }else{
                    mapa.put(letra,1);
                }
                i++;
            }
            tvAnalisis.setText("Los caracteres y su repetición en orden de entrada son: \n");
            mapa.forEach((key,value)->{
                tvAnalisis.setText(tvAnalisis.getText().toString()+key+" Repeticiones: "+value+"\n");
            });
        }else{
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setTitle("Error");
            alerta.setMessage("El texto no tiene letras para analizar");
            alerta.show();
        }
        final String fraseFinal=frase;
        //ordenar ,mapa por orden de clave
        btVolver.setOnClickListener(view -> {
            Map<Character, Integer> sortedMap = mapa.entrySet()
                    .stream()
                    .sorted(Comparator.comparing(Map.Entry<Character, Integer>::getValue).reversed())
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (e1, e2) -> e1,
                            LinkedHashMap::new
                    ));




            // Convert the entry set to an array of strings
            String[] arrayCaracteres = new String[sortedMap.entrySet().size()];

            int i = 0;
            for (Map.Entry<Character, Integer> entry : sortedMap.entrySet()) {
                char key = entry.getKey();
                int value = entry.getValue();

                // Convert key-value pair to a string
                String entrada = "Caracter: " + key + " Repeticiones: " + value + "\n";

                // Store the string in the array
                arrayCaracteres[i] = entrada;
                i++;
            }

// Now, 'arrayCaracteres' contains the key-value pairs as strings

            if (fraseFinal.isEmpty()) {
                setResult(Activity.RESULT_CANCELED);
            } else {
            Intent data = new Intent();
            data.putExtra(CLAVE_CARACTERES,arrayCaracteres);
            setResult(Activity.RESULT_OK,data);
            }
            finish();

        });
    }
}