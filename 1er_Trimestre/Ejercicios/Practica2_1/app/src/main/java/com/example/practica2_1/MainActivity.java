package com.example.practica2_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boton = (Button) findViewById(R.id.button);

        boton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                TextView vText = (TextView) findViewById(R.id.helloWorld);
                vText.setText("¿Seguro que deseas reiniciar tu teléfono?");
            }
        });
    }
}
