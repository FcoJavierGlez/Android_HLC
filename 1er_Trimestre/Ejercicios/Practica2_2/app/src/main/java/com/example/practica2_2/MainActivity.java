package com.example.practica2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sumar=(Button)findViewById(R.id.botonSumar);
        Button restar=(Button)findViewById(R.id.botonRestar);
        Button multiplicar=(Button)findViewById(R.id.botonMultiplicar);
        Button dividir=(Button)findViewById(R.id.botonDividir);
        Button borrar=(Button)findViewById(R.id.botonBorrar);

        //Suma
        sumar.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                EditText textNum1 = (EditText)findViewById(R.id.input1);
                EditText textNum2 = (EditText)findViewById(R.id.input2);
                TextView resultado = (TextView)findViewById(R.id.resultado);

                try {
                    resultado.setText(Double.toString(Double.parseDouble(textNum1.getText().toString())+Double.parseDouble(textNum2.getText().toString())));
                } catch (Exception e) {
                    resultado.setText("--E--");
                }

            }
        });

        //Resta
        restar.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                EditText textNum1 = (EditText)findViewById(R.id.input1);
                EditText textNum2 = (EditText)findViewById(R.id.input2);
                TextView resultado = (TextView)findViewById(R.id.resultado);

                try {
                    resultado.setText(Double.toString(Double.parseDouble(textNum1.getText().toString())-Double.parseDouble(textNum2.getText().toString())));
                } catch (Exception e) {
                    resultado.setText("--E--");
                }
            }
        });

        //Multiplica
        multiplicar.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                EditText textNum1 = (EditText)findViewById(R.id.input1);
                EditText textNum2 = (EditText)findViewById(R.id.input2);
                TextView resultado = (TextView)findViewById(R.id.resultado);

                try {
                    resultado.setText(Double.toString(Double.parseDouble(textNum1.getText().toString())*Double.parseDouble(textNum2.getText().toString())));
                } catch (Exception e) {
                    resultado.setText("--E--");
                }
            }
        });

        //Divide
        dividir.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                EditText textNum1 = (EditText)findViewById(R.id.input1);
                EditText textNum2 = (EditText)findViewById(R.id.input2);
                TextView resultado = (TextView)findViewById(R.id.resultado);

                try {
                    if (Double.parseDouble(textNum2.getText().toString())==0) {
                        resultado.setText("Infinito");
                    }
                    else {
                        resultado.setText(Double.toString(Double.parseDouble(textNum1.getText().toString())/Double.parseDouble(textNum2.getText().toString())));
                    }
                    //resultado.setText(Double.toString(Double.parseDouble(textNum1.getText().toString())/Double.parseDouble(textNum2.getText().toString())));
                } catch (Exception e) {
                    resultado.setText("--E--");
                }
            }
        });

        //Borra
        borrar.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                EditText textNum1 = (EditText)findViewById(R.id.input1);
                EditText textNum2 = (EditText)findViewById(R.id.input2);
                TextView resultado = (TextView)findViewById(R.id.resultado);

                textNum1.setText("");
                textNum2.setText("");
                resultado.setText("");
            }
        });


    }
}
