package com.example.practica2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imagen = (ImageView) findViewById(R.id.imagen);
        final TextView texto = (TextView) findViewById(R.id.texto);
        Button boton = (Button)findViewById(R.id.boton);

        boton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                imagen.setImageResource(R.drawable.after_cookie);
                texto.setText("I'm full!");
            }
        });
    }
}
