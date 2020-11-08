package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;



public class MainActivity extends AppCompatActivity {
    EditText n1;
    EditText n2;
    TextView lblResultado;
    Spinner operacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        operacao = findViewById(R.id.operacao);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.operacoes, android.R.layout.simple_spinner_item);

        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);
        lblResultado = findViewById(R.id.lblResultado);

        operacao.setAdapter(adapter);

    }

    // Tem que selecionar o número maior
    public void btnCalcular(View v){
        double N1 = Double.parseDouble(n1.getText().toString());
        double N2 = Double.parseDouble(n2.getText().toString());


        double resultado = 1.0;
        int selec = (int) operacao.getSelectedItemId();
        switch (selec){
            case 0:
                resultado = Somar(N1,N2);
                break;
            case 1:
                resultado = Subtrair(N1, N2);
                break;
            case 2:
                resultado = Multiplicar(N1, N2);
                break;
            default:
                resultado = Dividir(N1, N2);
                break;

        }

        lblResultado.setText(""+resultado);
    }

    private double Somar(Double x, Double y){
        return x + y;
    }

    private double Subtrair(Double x, Double y){
        if (x < y){
            double a = x;
            x = y;
            y = a;
        }

        return x - y;
    }

    private double Multiplicar(Double x, Double y){
        return x * y;
    }

    private double Dividir(Double x, Double y){
        if (x < y){
            double a = x;
            x = y;
            y = a;
        }

        return x / y;
    }
}
