package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listaCarros;
    ArrayList<String> carros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaCarros  = findViewById(R.id.lsvcarros);
        carros = new  ArrayList<String>();

        carros.add("Gol");
        carros.add("Onix");
        carros.add("Renegade");
        carros.add("HB20");
        carros.add("Uno");
        carros.add("Fiesta");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, carros);

        listaCarros.setAdapter(adapter);

        listViewCarros();
    }

    private void listViewCarros(){
        listaCarros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nome = carros.get(position).toString();
                String marca = marcaCarro(position);


                Toast.makeText(getApplicationContext(), "Modelo: " + nome  +"\n" +
                        "Marca: " + marca , Toast.LENGTH_SHORT).show();

            }
        });

    }

    private String marcaCarro(int pos){
        switch (pos){
            case 1:
                return "Volkswagem";
            case 2:
                return "Chevrolet";
            case 3:
                return "Jeep";
            case 4:
                return "Hyundai";
            case 5:
                return "Fiat";
            default:
                return "Ford";
        }

    }

}
