package com.luis.apprecyclerviewtoolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.rvVocales);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        AdapterRecyclerView adapterRecyclerView = new AdapterRecyclerView(this.datosVOS());
        recyclerView.setAdapter(adapterRecyclerView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case (R.id.item1):
                Toast.makeText(this, "cuadricula", Toast.LENGTH_SHORT).show();
                recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
                break;
            case (R.id.item2):
                Toast.makeText(this, "lista", Toast.LENGTH_SHORT).show();
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<DatosVO> datosVOS (){
        ArrayList<DatosVO> datos = new ArrayList<>();
        datos.add(new DatosVO("Letra A", R.drawable.ic_a));
        datos.add(new DatosVO("Letra B", R.drawable.ic_b));
        datos.add(new DatosVO("Letra C", R.drawable.ic_c));
        datos.add(new DatosVO("Letra D", R.drawable.ic_d));
        datos.add(new DatosVO("Letra E", R.drawable.ic_e));
    return datos;
    }


}