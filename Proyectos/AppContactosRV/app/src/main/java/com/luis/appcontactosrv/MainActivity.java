package com.luis.appcontactosrv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvContactos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        AdaptadorRecyclerView adaptadorRecyclerView = new AdaptadorRecyclerView(this.datosVOS());
        recyclerView.setAdapter(adaptadorRecyclerView);
    }

    private ArrayList<DatosVO> datosVOS(){
        ArrayList<DatosVO> datos = new ArrayList<>();
        //LlENANDO POR MEDIO DEL CONSTRUCTOR
        datos.add(new DatosVO("Alvaro", "Díaz","Tel: 11223344", R.drawable.ic_a));
        datos.add(new DatosVO("Andrea", "Rodriguez","Tel: 99887766",R.drawable.ic_a));
        datos.add(new DatosVO("Belinda", "Contreras", "Tel: 22334455",R.drawable.ic_b));
        datos.add(new DatosVO("Brandon","Pacheco","Tel: 88776655",R.drawable.ic_b));
        datos.add(new DatosVO("Carlos","García", "Tel: 33445566", R.drawable.ic_c));
        datos.add(new DatosVO("Camila", "Jimenez", "Tel: 77665544",R.drawable.ic_c));
        datos.add(new DatosVO("Daniela", "Mendez", "Tel: 44556677", R.drawable.ic_d));
        datos.add(new DatosVO("David", "Hernandez", "Tel: 44567891", R.drawable.ic_d));
        datos.add(new DatosVO("Esmeralda","Enriquez", "Tel: 66554433",R.drawable.ic_e));
        datos.add(new DatosVO("Eduardo", "Carvajal", "Tel: 12345678", R.drawable.ic_e));
        return datos;
    }

}