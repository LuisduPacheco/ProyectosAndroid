package com.luis.appcine;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerView; //Inicio recycler
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Cartelera");

        //Recycler
        recyclerView = findViewById(R.id.rvCartel);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        AdaptadorRecyclerV adaptadorRecyclerV = new AdaptadorRecyclerV(this.datosVOS());
        clickRecycler(adaptadorRecyclerV); // Paso 6
        recyclerView.setAdapter(adaptadorRecyclerV);

    }
    //Paso 4 Click en el Recycler
    private void clickRecycler(AdaptadorRecyclerV adaptadorRecyclerV){
        adaptadorRecyclerV.setItemClickListener(new ClickListener() {
            @Override
            public void itemClick(Integer position, View view) {
                trasladarDatos(position); // -paso 5
            }
        });
    }

    //Recycler
    private ArrayList<DatosVO> datosVOS (){
        ArrayList<DatosVO> datos = new ArrayList<>();
        datos.add(new DatosVO("Constantine","Duración: 121 minutos", R.drawable.ic_ctine));
        datos.add(new DatosVO("El lobo de Wall Street", "Duración: 180 minutos", R.drawable.ic_lobo));
        datos.add(new DatosVO("Glass", "Duración: 129 minutos", R.drawable.ic_glass));
        datos.add(new DatosVO("X-Men: Días del futuro pasado", "Duración: 132 minutos", R.drawable.ic_xmen));
        datos.add(new DatosVO("La llegada","Duración: 116 minutos",R.drawable.ic_llega));
        datos.add(new DatosVO("Avengers: End Game","Duracion: 182 minutos", R.drawable.ic_end));
        return datos;
    }
    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case (R.id.item1):
                Toast.makeText(this, "Lista", Toast.LENGTH_SHORT).show();
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
            break;
            case (R.id.item2):
                Toast.makeText(this, "Mosaico", Toast.LENGTH_SHORT).show();
                recyclerView.setLayoutManager(new GridLayoutManager(this,2));
            break;
        }
        return super.onOptionsItemSelected(item);
    }

    //Paso 5
    private void trasladarDatos(int position){
        Intent intent = new Intent(getApplicationContext(), MAInfoPelicula.class);
        intent.putExtra("tituloD", datosVOS().get(position).getStringTitulo() );
        intent.putExtra("imagenD", datosVOS().get(position).getIntegerImagen());
        intent.putExtra("sinop", datosInformacionAdicional().get(position).getIntegerSinop());
        intent.putExtra("prot", datosInformacionAdicional().get(position).getIntegerProt());
        intent.putExtra("rec", datosInformacionAdicional().get(position).getIntegerRec());
        startActivity(intent);
    }

    //Trasladar información a los fragment
    //C
    private ArrayList <DatosVO> datosInformacionAdicional(){
        ArrayList<DatosVO> datosInfo = new ArrayList<>();
        datosInfo.add(new DatosVO(R.string.sinop1, R.string.prot1, R.string.rec1));
        datosInfo.add(new DatosVO(R.string.sinop2, R.string.prot2, R.string.rec2));
        datosInfo.add(new DatosVO(R.string.sinop3, R.string.prot3, R.string.rec3));
        datosInfo.add(new DatosVO(R.string.sinop4, R.string.prot4, R.string.rec4));
        datosInfo.add(new DatosVO(R.string.sinop5, R.string.prot5, R.string.rec5));
        datosInfo.add(new DatosVO(R.string.sinop6, R.string.prot6, R.string.rec6));

        return datosInfo;
    }


}