package com.luis.appmeses;

import androidx.appcompat.app.AppCompatActivity;

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
        listView = findViewById(R.id.listMeses);
        //ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, this.meses());
        AdapterPersonalizado adapterPersonalizado = new AdapterPersonalizado(this, R.layout.list_personalizada,numeroMeses(), meses(), descripcionCelebracionMes(), celebracionMes());
        listView.setAdapter(adapterPersonalizado);

    }

    private ArrayList <Integer> numeroMeses(){
        ArrayList <Integer> numeroMes = new ArrayList<>();
        for (int i = 1; i < 13; i++ ){
            numeroMes.add(i);
        }
        return numeroMes;
    }

    private ArrayList <String> meses(){
        ArrayList <String> mes = new ArrayList<>();
        mes.add("Enero");
        mes.add("Febrero");
        mes.add("Marzo");
        mes.add("Abril");
        mes.add("Mayo");
        mes.add("Junio");
        mes.add("Julio");
        mes.add("Agosto");
        mes.add("Septiembre");
        mes.add("Octubre");
        mes.add("Noviembre");
        mes.add("Diciembre");

        return mes;
    }

    private ArrayList<String> celebracionMes(){
        ArrayList<String> celebracionMes = new ArrayList<>();
        celebracionMes.add("Año Nuevo");
        celebracionMes.add("Huelga de Dolores");
        celebracionMes.add("Semana Santa");
        celebracionMes.add("Semana Santa");
        celebracionMes.add("Santa Cruz");
        celebracionMes.add("Baile de los Gigantes");
        celebracionMes.add("Fiesta Nacional Indigena Rabin Ajaw");
        celebracionMes.add("Festival folklórico");
        celebracionMes.add("Día de la Independencia");
        celebracionMes.add("San Francisco de Asís");
        celebracionMes.add("Todos los Santos");
        celebracionMes.add("Quema del diablo");
        return celebracionMes;
    }

    private ArrayList <Integer> descripcionCelebracionMes () {
        ArrayList<Integer> descripcionCelebracionMes = new ArrayList<>();
        descripcionCelebracionMes.add(R.string.mes1);
        descripcionCelebracionMes.add(R.string.mes2);
        descripcionCelebracionMes.add(R.string.mes3);
        descripcionCelebracionMes.add(R.string.mes4);
        descripcionCelebracionMes.add(R.string.mes5);
        descripcionCelebracionMes.add(R.string.mes6);
        descripcionCelebracionMes.add(R.string.mes7);
        descripcionCelebracionMes.add(R.string.mes8);
        descripcionCelebracionMes.add(R.string.mes9);
        descripcionCelebracionMes.add(R.string.mes10);
        descripcionCelebracionMes.add(R.string.mes11);
        descripcionCelebracionMes.add(R.string.mes12);
        return descripcionCelebracionMes;
    }


}