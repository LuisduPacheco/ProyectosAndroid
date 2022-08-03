package com.luis.appgrid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gridColores);

        AdapterGrid adapterGrid = new AdapterGrid(this, R.layout.grid_personalizado, this.imagenColor(), this.nombres() );
        gridView.setAdapter(adapterGrid);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            traslado(position);
            }
        });
    }


    private ArrayList<String> nombres(){
        ArrayList<String> nombreColor = new ArrayList<>();
        nombreColor.add("Rosa");
        nombreColor.add("Violeta");
        nombreColor.add("Aqua");
        nombreColor.add("Celeste");
        nombreColor.add("Verde");
        nombreColor.add("Musgo");
        nombreColor.add("Amarillo");
        nombreColor.add("Naranja");
        nombreColor.add("Blanco");
        nombreColor.add("Gris");
        nombreColor.add("Rojo");
        nombreColor.add("Purpura");
        nombreColor.add("Azul");
        nombreColor.add("Menta");
        nombreColor.add("Mostaza");
        return nombreColor;
    }
    private ArrayList<Integer> imagenColor(){
        ArrayList<Integer> imagen = new ArrayList<>();
        imagen.add(R.color.c1);
        imagen.add(R.color.c2);
        imagen.add(R.color.c3);
        imagen.add(R.color.c4);
        imagen.add(R.color.c5);
        imagen.add(R.color.c6);
        imagen.add(R.color.c7);
        imagen.add(R.color.c8);
        imagen.add(R.color.c9);
        imagen.add(R.color.c10);
        imagen.add(R.color.c11);
        imagen.add(R.color.c12);
        imagen.add(R.color.c13);
        imagen.add(R.color.c14);
        imagen.add(R.color.c15);
        return imagen;
    }

    private ArrayList<Integer> codigoRGB () {
        ArrayList<Integer> rgb = new ArrayList<>();
        rgb.add(R.string.c1);
        rgb.add(R.string.c2);
        rgb.add(R.string.c3);
        rgb.add(R.string.c4);
        rgb.add(R.string.c5);
        rgb.add(R.string.c6);
        rgb.add(R.string.c7);
        rgb.add(R.string.c8);
        rgb.add(R.string.c9);
        rgb.add(R.string.c10);
        rgb.add(R.string.c11);
        rgb.add(R.string.c12);
        rgb.add(R.string.c13);
        rgb.add(R.string.c14);
        rgb.add(R.string.c15);
        return rgb;
    }

    private void traslado (int position){
        Intent intent = new Intent(this, MAColor.class);
        intent.putExtra("imagen", this.imagenColor().get(position));
        intent.putExtra("nombre", this.nombres().get(position));
        intent.putExtra("color", this.codigoRGB().get(position));
        startActivity(intent);
    }

}