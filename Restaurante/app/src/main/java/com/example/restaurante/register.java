package com.example.restaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void registerSuccess(View v){
        Intent intent = new Intent(getApplicationContext(), sucess.class);
        startActivity(intent);
        finish();
    }
}