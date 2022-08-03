package com.luis.appgrid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MAColor extends AppCompatActivity {
    private ImageView imageView;
    private TextView textViewN, textViewC ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macolor);

        imageView = findViewById(R.id.imgColorT);
        textViewN = findViewById(R.id.txtNombreT);
        textViewC = findViewById(R.id.txtCodigo);
        this.obtener();

    }

    private void obtener() {
        Bundle bundle = getIntent().getExtras();
        int imagen = bundle.getInt("imagen");
        String nombre = bundle.getString("nombre");
        int color = bundle.getInt("color");
        imageView.setImageResource(imagen);
        textViewN.setText(String.valueOf(nombre));
        textViewC.setText(color);
    }
}