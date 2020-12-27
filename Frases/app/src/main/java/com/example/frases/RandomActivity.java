package com.example.frases;
import android.content.Intent;


import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

class RandomActivity {

    private Class[] activits = {
            Frase1.class,
            Frase2.class,
            Frase3.class,
            Frase4.class,
            Frase5.class,
    };

    /*
    *  it: is the corrent activity on the screen
    */

    private Class selectRandomActivity(AppCompatActivity it){
        Random random = new Random();
        int randomPosition = random.nextInt(5);

        if(it.getClass().equals(activits[randomPosition])){
            selectRandomActivity(it);
        }

        return activits[randomPosition];

    }


    void CallRandomActivity(AppCompatActivity it){
        Intent showScreen = new Intent(it, selectRandomActivity(it));

        it.startActivity(showScreen);

    }

}
