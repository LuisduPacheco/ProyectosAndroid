package com.luis.appaobisiesto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MAResultados extends AppCompatActivity {

    private Button buttonRegresar;

    private TextView textViewTitulo, textViewAnioR, textViewMeses,
            textViewSemanas, textViewDias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maresultados);

    textViewTitulo = findViewById(R.id.txtAnioT);
    textViewAnioR = findViewById(R.id.txtAnioR);
    textViewSemanas = findViewById(R.id.txtSemanas);
    textViewDias = findViewById(R.id.txtDias);
    textViewMeses = findViewById(R.id.txtMeses);
    buttonRegresar = findViewById(R.id.btnRegresa);
    this.obtenerDatosTrasladados();

    }

    private void obtenerDatosTrasladados(){
    //Bundle para recibir los datos
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
        String anio = bundle.getString("anio");
        textViewTitulo.setText("El año "+anio+" es...");
        this.calculoTipoAnio(anio);

        this.click();
        }
    }

    private void click() {

        buttonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void calculoTipoAnio(String anio){
        int anio1 = Integer.parseInt(anio);
        if((anio1 %4 == 0) && (anio1 %100 != 0 || anio1 %400 == 0) ){
            textViewAnioR.setText("BISIESTO");
            textViewDias.setText("DÍAS: 366");
            textViewMeses.setText("MESES: 12");
            textViewSemanas.setText("SEMANAS: 52");
        }else{
            textViewAnioR.setText("NO BISIESTO");
            textViewDias.setText("DÍAS: 365");
            textViewMeses.setText("MESES: 12");
            textViewSemanas.setText("SEMANAS: 52");

        }
    }


}