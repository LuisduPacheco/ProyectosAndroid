package com.luis.appmarcasvehiculos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gridvMarcas);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, this.marcas());
        gridView.setAdapter(arrayAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "a pulsado: "+ marcas().get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private ArrayList<String> marcas (){
        ArrayList<String> marcas = new ArrayList<>();
        marcas.add("Toyota");
        marcas.add("Mercedes");
        marcas.add("BMW");
        marcas.add("Volksvagen");
        marcas.add("Audi");
        marcas.add("Macerati");
        marcas.add("Honda");
        marcas.add("Tesla");
        marcas.add("Alfa Romero");
        marcas.add("Buggatti");
        return marcas;
    }


}