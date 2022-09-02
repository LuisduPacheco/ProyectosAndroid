package com.luis.myappsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.luis.myappsqlite.basededatos.BebidaDAO;
import com.luis.myappsqlite.basededatos.BebidaVO;

import java.util.ArrayList;

public class MAListarSQLite extends AppCompatActivity {
    private ListView listView;
    private BebidaDAO bdao = new BebidaDAO();
    private BebidaVO bvo = new BebidaVO();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malistar_sqlite);
        listView = findViewById(R.id.lvListadoBebidas);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, llenarLista());


        this.clickItem();
        listView.setAdapter(arrayAdapter);
    }

    //PARA EL FRAGMENT - 2
    private void clickItem(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                trasladarDatos(position);
            }
        });
    }


    private ArrayList<String> llenarLista (){
        ArrayList<String> lista = new ArrayList<>();
        if(bdao.listarBebida(bvo,getApplicationContext())!=null){
            for (BebidaVO listaVO: bdao.listarBebida(bvo, getApplicationContext())) {
                lista.add(listaVO.getNombreBebida());
            }
        }

        return lista;
    }
    //TRASLADAR información al fragment - 1
    private void trasladarDatos(int position){
        Intent intent = new Intent(this, MADetalle.class);
        intent.putExtra("codigo",bdao.listarBebida(bvo, getApplicationContext()).get(position).getCodigoBebida().toString());
        intent.putExtra("nombre", bdao.listarBebida(bvo, getApplicationContext()).get(position).getNombreBebida());
        intent.putExtra("sabor", bdao.listarBebida(bvo, getApplicationContext()).get(position).getSaborBebida());
        intent.putExtra("presentacion", bdao.listarBebida(bvo, getApplicationContext()).get(position).getPresentacionBebida().toString());
        intent.putExtra("tipo", bdao.listarBebida(bvo, getApplicationContext()).get(position).getTipoBebida());
        intent.putExtra("precio",bdao.listarBebida(bvo, getApplicationContext()).get(position).getPrecioBebida().toString());
        startActivity(intent);
    }



}