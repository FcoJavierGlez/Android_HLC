package com.example.proyecto1_marcadorbaloncesto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Marcadores local y visitante:
        final TextView puntosLocal = (TextView) findViewById(R.id.puntos_local);
        final TextView puntosVisitante = (TextView) findViewById(R.id.puntos_visitante);

        //Nombres equipos:
        final EditText equipoLocal = (EditText)findViewById(R.id.edit_equipoLocal);
        final EditText equipoVisitante = (EditText)findViewById(R.id.edit_equipoVisitante);

        //Botones puntos local:
        Button localUnPunto = (Button) findViewById(R.id.local_1punto);
        Button localDosPuntos = (Button) findViewById(R.id.local_2punto);
        Button localTresPuntos = (Button) findViewById(R.id.local_3punto);

        //Botones puntos visitante:
        Button visitanteUnPunto = (Button) findViewById(R.id.visitante_1punto);
        Button visitanteDosPuntos = (Button) findViewById(R.id.visitante_2punto);
        Button visitanteTresPuntos = (Button) findViewById(R.id.visitante_3punto);

        //Botones incremente/decrementa marcador local:
        Button incrementaLocal = (Button)findViewById(R.id.incrementa_local);
        Button decrementaLocal = (Button)findViewById(R.id.decrementa_local);

        //Botones incremente/decrementa marcador visitante:
        Button incrementaVisitante = (Button)findViewById(R.id.incrementa_visitante);
        Button decrementaVisitante = (Button)findViewById(R.id.decrementa_visitante);

        //Botón reset:
        Button reset = (Button)findViewById(R.id.reset);

        //Botón deshacer
        Button deshacer = (Button)findViewById(R.id.deshacer);


        //Funcionalidad botones puntos local
        localUnPunto.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View V) {
                Marcador.setPuntos("local",1);
                actualizaDisplay(puntosLocal, puntosVisitante);
            }
        });

        localDosPuntos.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View V) {
                Marcador.setPuntos("local",2);
                actualizaDisplay(puntosLocal, puntosVisitante);
            }
        });

        localTresPuntos.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View V) {
                Marcador.setPuntos("local",3);
                actualizaDisplay(puntosLocal, puntosVisitante);
            }
        });


        //Funcionalidad botones puntos visitante
        visitanteUnPunto.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View V) {
                Marcador.setPuntos("visitante",1);
                actualizaDisplay(puntosLocal, puntosVisitante);
            }
        });

        visitanteDosPuntos.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View V) {
                Marcador.setPuntos("visitante",2);
                actualizaDisplay(puntosLocal, puntosVisitante);
            }
        });

        visitanteTresPuntos.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View V) {
                Marcador.setPuntos("visitante",3);
                actualizaDisplay(puntosLocal, puntosVisitante);
            }
        });

        //Funcionalidad botón reset
        reset.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View V) {
                Marcador.reset();
                actualizaDisplay(puntosLocal, puntosVisitante);
                resetNombreEquipos(equipoLocal, equipoVisitante);
            }
        });

        //Funcionalidad deshacer:
        deshacer.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View V) {
                Marcador.deshacer();
                actualizaDisplay(puntosLocal, puntosVisitante);
            }
        });

        //Funcionalidad botones incrementa y decrementa
        incrementaLocal.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Marcador.incrementaMarcador("local");
                actualizaDisplay(puntosLocal, puntosVisitante);
            }
        });

        incrementaVisitante.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Marcador.incrementaMarcador("visitante");
                actualizaDisplay(puntosLocal, puntosVisitante);
            }
        });

        decrementaLocal.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Marcador.decrementaMarcador("local");
                actualizaDisplay(puntosLocal, puntosVisitante);
            }
        });

        decrementaVisitante.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Marcador.decrementaMarcador("visitante");
                actualizaDisplay(puntosLocal, puntosVisitante);
            }
        });

    }

    private void resetNombreEquipos(EditText equipoLocal, EditText equipoVisitante) {
        equipoLocal.setText("");
        equipoVisitante.setText("");
    }

    private void actualizaDisplay(TextView puntosLocal, TextView puntosVisitante) {
        puntosLocal.setText(Marcador.getMarcadorLocal());
        puntosVisitante.setText(Marcador.getMarcadorVisitante());
    }
}
