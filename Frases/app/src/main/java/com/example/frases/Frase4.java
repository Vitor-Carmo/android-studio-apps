package com.example.frases;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class Frase4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frase4);
    }

    public void btnFrases(View view) {
        RandomActivity randomActivity = new RandomActivity();
        randomActivity.CallRandomActivity(this);
    }
}
