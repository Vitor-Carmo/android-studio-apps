package com.example.restaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void goToGalery(View v){
        Intent intent = new Intent(getApplicationContext(), galery.class);
        startActivity(intent);
        finish();

    }

    public void register(View v){
        Intent intent = new Intent(getApplicationContext(), register.class);
        startActivity(intent);
    }


}