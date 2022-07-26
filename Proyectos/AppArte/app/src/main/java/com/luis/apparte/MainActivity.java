package com.luis.apparte;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listViewArte;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewArte = findViewById(R.id.listArte);
        // #7. Adapter Personalizado
        AdapterPersonalizado adapterPersonalizado = new AdapterPersonalizado(this, R.layout.list_personalizada, tipoArte());
        listViewArte.setAdapter(adapterPersonalizado);

    }
    private ArrayList <String> tipoArte () {
        ArrayList <String> tipoArt = new ArrayList<>();
        tipoArt.add("Abstracto");
        tipoArt.add("Realismo");
        tipoArt.add("Hiperrealismo");
        tipoArt.add("Expresionismo");
        tipoArt.add("Pop");
        return tipoArt;
    }

}