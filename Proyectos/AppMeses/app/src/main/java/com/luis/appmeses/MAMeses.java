package com.luis.appmeses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MAMeses extends AppCompatActivity {
    private TextView textViewNombreMes, textViewCelebracionMes, textViewDescripcionMes;;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mameses);

        textViewNombreMes = findViewById(R.id.txtMes);
        textViewCelebracionMes = findViewById(R.id.txtCelebracion);
        textViewDescripcionMes = findViewById(R.id.txtHistoria);

        this.obtenerDatos ();

    }

    private void obtenerDatos() {
        Bundle bundle = getIntent().getExtras();
        String nomMes = bundle.getString("nomMes");
        String celebracion = bundle.getString("celebracion");
        int descripcion = bundle.getInt("descripcion");

        textViewNombreMes.setText(String.valueOf(nomMes));
        textViewCelebracionMes.setText(String.valueOf(celebracion));
        textViewDescripcionMes.setText((descripcion));

    }
}