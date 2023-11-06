package com.example.pmdp23_24.U3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdp23_24.R;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class u3a6Mapa_B extends AppCompatActivity {

    public static final String CLAVE_CARACTERES ="ArrayCaracteres" ;
    TextView tvAnalisis;
    Button btVolver;
    LinkedHashMap<Character,Integer> mapa;
    String arrayCaracteres[];
    private static final int LETRAS_MOSTRADAS = 3;
    Bundle info = getIntent().getExtras();
    String frase = info.getString(u3a6Mapa_A.CLAVE_TEXTO);
    private static String regex = "[.,\\/#!$%\\^&\\*;:{}=\\-_`~()”“\"…\n123456789]";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a6_mapa_b);
        tvAnalisis = findViewById(R.id.u3a6BidTvAnalisis);
        btVolver = findViewById(R.id.u3a6BidBtVolver);
        frase = frase.replace(" ","")
                .replaceAll(regex,"")
                .toLowerCase();
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
                tvAnalisis.setText("Caracter: "+key+" Repeticiones: "+value+"\n");
            });
        }else{
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setTitle("Error");
            alerta.setMessage("El texto no tiene letras para analizar");
            alerta.show();
        }
        btVolver.setOnClickListener(view -> {
            mapa.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue())
                    .collect(Collectors.toMap(
                            Map.Entry::getValue,
                            Map.Entry::getKey,
                            (e1,e2)->e1,
                            LinkedHashMap::new
                    ));


            if (!frase.isEmpty()){
            Intent data = new Intent();
            data.putExtra(CLAVE_CARACTERES,arrayCaracteres);
            setResult(Activity.RESULT_OK,data);
            }
            else{
                setResult(Activity.RESULT_CANCELED);
            }
            finish();

        });
    }
}