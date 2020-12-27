package com.example.frases;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Frase1 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frase1);

    }

    public void btnFrases(View view) {
        RandomActivity randomActivity = new RandomActivity();
        randomActivity.CallRandomActivity(this);
    }

}
