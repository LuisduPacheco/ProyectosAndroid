package com.luis.myapppaises;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MAPais extends AppCompatActivity {
    private TextView textViewNombre, textViewPoblacion;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapais);

        textViewNombre=findViewById(R.id.txtNombre);
        textViewPoblacion = findViewById(R.id.txtPoblacion);
        imageView = findViewById(R.id.imgPais);
        this.obtener();

    }

    private void obtener () {
        Bundle bundle = getIntent().getExtras();
        int imagen = bundle.getInt("imagenes");
        int nombre = bundle.getInt("nombres");
        int pobla = bundle.getInt("pobla");

        imageView.setImageResource(imagen);
        textViewNombre.setText(nombre);
        textViewPoblacion.setText(pobla);
    }

}