package com.luis.myapplistview;
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
    //LOS DATOS DE LA ListView
    //ArrayList<String> vocales = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listVocales);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, this.vocales());
        listView.setAdapter(arrayAdapter); //Llenando la lista

        this.clickItem();
    }

    public void clickItem(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                traslado(position);
            }
        });
    }

    private ArrayList<String> vocales(){
        ArrayList<String> vocales = new ArrayList<>();
        vocales.add("A");
        vocales.add("E");
        vocales.add("I");
        vocales.add("O");
        vocales.add("U");
        return vocales;
    }

    //Método que retorna un ArrayList con las imagenes como datos
    private ArrayList<Integer> imagenes(){
        ArrayList<Integer>img = new ArrayList<>();
        img.add(R.drawable.ic_a);
        img.add(R.drawable.ic_e);
        img.add(R.drawable.ic_i);
        img.add(R.drawable.ic_o);
        img.add(R.drawable.ic_u);
        return img;
    }
    //Método que retorna un ArrayList con la informacion como tal
    private ArrayList<Integer> informacion(){
        ArrayList<Integer> info = new ArrayList<>();
        info.add(R.string.vocalA);
        info.add(R.string.vocalE);
        info.add(R.string.vocalI);
        info.add(R.string.vocalO);
        info.add(R.string.vocalU);
        return info;
    }

    //MÉTODO que hará la apertura y traslado de los datos a otra Activity
    private void traslado (int position){
        Intent intent = new Intent(this, MAVocales.class);
        intent.putExtra("imagenes", imagenes().get(position));
        intent.putExtra("informacion", informacion().get(position));
        startActivity(intent);
    }
}