package com.example.spinner;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.net.wifi.aware.PublishConfig;
import android.view.View;
import android.widget.*;
import android.os.Bundle;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    Spinner spFrutas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spFrutas= (Spinner) findViewById(R.id.spFrutas);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.frutas, android.R.layout.simple_spinner_item);

        spFrutas.setAdapter(adapter);


    }


    public void onClick(View v){
        TextView lblFruta = findViewById(R.id.lblFruta);
        TextView lblPosicao = findViewById(R.id.lblPosicao);

        String frutaSelec = spFrutas.getSelectedItem().toString();
        int posicao = spFrutas.getSelectedItemPosition();

        if (posicao > 0){
            lblFruta.setText("Fruta: "+ frutaSelec);
            lblPosicao.setText("Posição "+ posicao);

        }else {
            Alerta();
        }

    }

    private void Alerta(){
        AlertDialog.Builder popup = new AlertDialog.Builder(this);
        popup.setTitle("Erro!");
        popup.setMessage("Você não selecionou nenhum nenhum número.");
        popup.setNeutralButton("OK", null);
        popup.show();
    }


}
