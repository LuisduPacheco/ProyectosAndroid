package com.luis.apparte;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listViewArte;
    private Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewArte = findViewById(R.id.listArte);
        // #7. Adapter Personalizado
        AdapterPersonalizado adapterPersonalizado = new AdapterPersonalizado(this, R.layout.list_personalizada, tipoArte());
        listViewArte.setAdapter(adapterPersonalizado);

        //Toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "Opción 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                Toast.makeText(this, "Opción 2", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
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