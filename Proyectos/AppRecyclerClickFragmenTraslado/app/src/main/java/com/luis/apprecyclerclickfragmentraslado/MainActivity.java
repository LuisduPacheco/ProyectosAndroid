package com.luis.apprecyclerclickfragmentraslado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1
        recyclerView = findViewById(R.id.rvId);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        //3
        AdaptadorRecycler adaptadorRecycler = new AdaptadorRecycler(this.setItem());
        clickRecycler(adaptadorRecycler); //Paso 10
        recyclerView.setAdapter(adaptadorRecycler);
    }

    //Paso 8
    private void clickRecycler(AdaptadorRecycler adaptadorRecycler) {
        adaptadorRecycler.setItemClickListener(new ClickListener() {
            @Override
            public void itemClick(Integer position, View v) {
                trasladarDatosCompletos(position); // - Paso 9
               // trasladarInformacionAdicional(position); //A
            }
        });

    }

    private ArrayList<DatosVO> setItem() { //2
        ArrayList<DatosVO> item = new ArrayList<>();
        item.add(new DatosVO(R.drawable.ic_tel, R.string.nombreD1, R.string.precioD1));
        item.add(new DatosVO(R.drawable.ic_lap, R.string.nombreD2, R.string.precioD2));
        item.add(new DatosVO(R.drawable.ic_aud, R.string.nombreD3, R.string.precioD3));
        item.add(new DatosVO(R.drawable.ic_tv, R.string.nombreD4, R.string.precioD4));

        return item;
    }

    //Paso 9
    private void trasladarDatosCompletos(int position) {
        Intent intent = new Intent(getApplicationContext(), MAInformacionAdicional.class);
        intent.putExtra("nombreD", setItem().get(position).getNombre());
        intent.putExtra("imgD", setItem().get(position).getImagen());
        intent.putExtra("detalleD", datosInformacinonAdicional().get(position).getDetalle());
        intent.putExtra("especificacionesD", datosInformacinonAdicional().get(position).getEspecificaciones());
        startActivity(intent);
    }

    private ArrayList<DatosVO> datosInformacinonAdicional(){
        ArrayList<DatosVO> datosInfo = new ArrayList<>();
        datosInfo.add(new DatosVO(R.string.detalle1, R.string.especificacionesD1));
        datosInfo.add(new DatosVO(R.string.detalle2, R.string.especificacionesD2));
        datosInfo.add(new DatosVO(R.string.detalle3, R.string.especificacionesD3));
        datosInfo.add(new DatosVO(R.string.detalle4, R.string.especificacionesD4));
        return datosInfo;
    }

    //Este método daba error al lanzar dos veces los intent, borraba los recursos
    /*private void trasladarInformacionAdicional(int position){ //A
        Intent intent = new Intent(getApplicationContext(), MAInformacionAdicional.class);
        intent.putExtra("detalleD", datosInformacinonAdicional().get(position).getDetalle());
        intent.putExtra("especificacionesD", datosInformacinonAdicional().get(position).getEspecificaciones());
        startActivity(intent);
    }*/


}

