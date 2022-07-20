package com.luis.myapppaises;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listPaises);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, this.paises());
        listView.setAdapter(arrayAdapter);

        this.clicItem();
    }

    private void clicItem() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                traslado(position);
            }
        });
    }

    private ArrayList<String> paises(){
        ArrayList <String> paises = new ArrayList<>();
        paises.add("Estados Unidos");
        paises.add("Brasil");
        paises.add("México");
        paises.add("Colombia");
        paises.add("Argentina");
        paises.add("Canadá");
        paises.add("Chile");
        paises.add("Guatemala");
        paises.add("Cuba");
        paises.add("Puerto Rico");
        return paises;
    }

    //Método que retorna un ArrayList con las imagenes como datos
    private ArrayList<Integer> imagenes() {
        ArrayList<Integer> img = new ArrayList<>();
        img.add(R.drawable.ic_usa);
        img.add(R.drawable.ic_bra);
        img.add(R.drawable.ic_mex);
        img.add(R.drawable.ic_col);
        img.add(R.drawable.ic_arg);
        img.add(R.drawable.ic_can);
        img.add(R.drawable.ic_chi);
        img.add(R.drawable.ic_gua);
        img.add(R.drawable.ic_cub);
        img.add(R.drawable.ic_pr);
        return img;
    }

    //Método que retorna un ArrayList con la información
    private ArrayList<Integer> nombres () {
        ArrayList<Integer> nombre = new ArrayList<>();
        nombre.add(R.string.N1);
        nombre.add(R.string.N2);
        nombre.add(R.string.N3);
        nombre.add(R.string.N4);
        nombre.add(R.string.N5);
        nombre.add(R.string.N6);
        nombre.add(R.string.N7);
        nombre.add(R.string.N8);
        nombre.add(R.string.N9);
        nombre.add(R.string.N10);
        return nombre;
    }

    private ArrayList<Integer> poblacion () {
        ArrayList<Integer> pob = new ArrayList<>();
        pob.add(R.string.P1);
        pob.add(R.string.P2);
        pob.add(R.string.P3);
        pob.add(R.string.P4);
        pob.add(R.string.P5);
        pob.add(R.string.P6);
        pob.add(R.string.P7);
        pob.add(R.string.P8);
        pob.add(R.string.P9);
        pob.add(R.string.P10);
        return pob;
    }

    //Método que hará la apertura y traslado de los datos a otra activity
    private void traslado (int position) {
        Intent intent = new Intent(this, MAPais.class);
        intent.putExtra("imagenes", imagenes().get(position));
        intent.putExtra("nombres", nombres().get(position));
        intent.putExtra("pobla", poblacion().get(position));
        startActivity(intent);
    }

}