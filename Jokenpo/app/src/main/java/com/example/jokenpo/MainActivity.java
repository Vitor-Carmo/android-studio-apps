package com.example.jokenpo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView player1, player2;
    TextView result;
    private int player1Choice, player2Choice;
    View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        player1 = findViewById(R.id.img_jogador1);
        player2 = findViewById(R.id.img_jogador2);

        result = findViewById(R.id.txtResultado);
        view = findViewById(R.id.view);

    }


    @Override
    public void onClick(View v) {

        player1.setScaleX(-1);

        if (v.getId() == R.id.papel) {
            player1.setImageResource(R.drawable.papel);
            player1Choice = 0;
        }

        if (v.getId() == R.id.tessoura) {
            player1.setImageResource(R.drawable.tesoura);
            player1Choice = 1;
        }

        if (v.getId() == R.id.pedra) {
            player1.setImageResource(R.drawable.pedra);
            player1Choice = 2;
        }

        player2Choice();
        winner();
    }


    private void player2Choice() {


        Random random = new Random();
        player2Choice = random.nextInt(3);


        if(player2Choice == 0) {
               player2.setImageResource(R.drawable.papel);
        }

        if(player2Choice == 1) {
            player2.setImageResource(R.drawable.tesoura);
        }

        if(player2Choice == 2) {
            player2.setImageResource(R.drawable.pedra);
        }

    }


    private void winner() {
        /*
            0 = papel
            1 = tessoura
            2 = pedra
         */

        if(player1Choice == player2Choice){
            result.setText("Empate");
            view.setBackgroundColor(getResources().getColor(R.color.defaultColor));
            return;
        }


        if(player1Choice == 0){
            if(player2Choice == 1){
                setResult("Perdeu");

            } else {
                setResult("Venceu");
            }
            return;
        }


        if(player1Choice == 1){
            if(player2Choice == 2){
                setResult("Perdeu");
            } else {
                setResult("Venceu");
            }
            return;
        }


        if(player1Choice == 2){
            if(player2Choice == 0){
                setResult("Perdeu");
            } else {
                setResult("Venceu");
            }

            return;
        }

    }


    private void setResult(String text){
        result.setText(text);
        if ("Perdeu" == text){
            view.setBackgroundColor(getResources().getColor(R.color.red));
        }else{
           view.setBackgroundColor(getResources().getColor(R.color.green));
        }
    }

}










