package com.example.frases;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {


    MediaPlayer song;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        song = MediaPlayer.create(this, R.raw.lofi_hip_hop);

    }


    public void btnFrases(View view) {
        RandomActivity randomActivity = new RandomActivity();
        randomActivity.CallRandomActivity(this);
        song.start();
    }


}
