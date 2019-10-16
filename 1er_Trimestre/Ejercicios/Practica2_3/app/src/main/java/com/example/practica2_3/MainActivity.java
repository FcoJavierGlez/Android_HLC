package com.example.practica2_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView unidades = (TextView)findViewById(R.id.unidades);

        final EditText nombre = (EditText)findViewById(R.id.nombre);

        final CheckBox crema = (CheckBox) findViewById(R.id.crema);
        final CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate);

        Button suma = (Button)findViewById(R.id.suma);
        Button resta = (Button)findViewById(R.id.resta);
        Button order = (Button)findViewById(R.id.order);

        suma.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if (Integer.parseInt(unidades.getText().toString())==100)
                    return;
                unidades.setText(Integer.toString(Integer.parseInt(unidades.getText().toString())+1));
            }
        });

        resta.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if (Integer.parseInt(unidades.getText().toString())==0)
                    return;
                unidades.setText(Integer.toString(Integer.parseInt(unidades.getText().toString())-1));
            }
        });

        order.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if (Integer.parseInt(unidades.getText().toString())==0)
                    return;
                if (nombre.getText().toString().equals("Nombre") || nombre.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Debe insertar su nombre", Toast.LENGTH_LONG).show();
                    return;
                }

                Double precio=1.50;
                if (crema.isChecked()) precio+=0.2;
                if (chocolate.isChecked()) precio+=0.35;

                Double pagar = Double.parseDouble(unidades.getText().toString())*precio*100;

                Toast.makeText(getApplicationContext(), "Nombre: "+nombre.getText()
                        +"\nCantidad: "+unidades.getText()
                        +"\nPrecio: "+(pagar/100)+"€", Toast.LENGTH_LONG).show();
            }
        });
    }
}
