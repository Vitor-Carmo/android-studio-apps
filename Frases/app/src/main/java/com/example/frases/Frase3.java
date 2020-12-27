package com.example.frases;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class Frase3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frase3);
    }

    public void btnFrases(View view) {
        RandomActivity randomActivity = new RandomActivity();
        randomActivity.CallRandomActivity(this);
    }
}
