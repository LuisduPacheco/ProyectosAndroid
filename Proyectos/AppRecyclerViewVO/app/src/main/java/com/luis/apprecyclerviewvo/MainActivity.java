package com.luis.apprecyclerviewvo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        AdaptadorRecyclerView adaptadorRecyclerView = new AdaptadorRecyclerView(this.datosVO());
        recyclerView.setAdapter(adaptadorRecyclerView);
    }

    private ArrayList<DatosVO> datosVO (){
        ArrayList<DatosVO> datos = new ArrayList<>();
        //Llenado de información por medio de un constructor
        datos.add(new DatosVO("La hamburguesa gigante","Deliciosas",R.drawable.ic_hamburguesa));
        datos.add(new DatosVO("Pizza x2","Ingredientes frescos", R.drawable.ic_pizza));
        datos.add(new DatosVO("SuperTacos", "Sabor autentico", R.drawable.ic_taco));
        return datos;
    }
}