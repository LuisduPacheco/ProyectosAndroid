package com.luis.myappsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.luis.myappsqlite.basededatos.BebidaDAO;
import com.luis.myappsqlite.basededatos.BebidaVO;

import java.util.ArrayList;

public class MAEliminarSQLite extends AppCompatActivity {
    private ListView listView;
    private EditText editText;
    private Button button;
    private BebidaVO bvo = new BebidaVO();
    private BebidaDAO bdao = new BebidaDAO();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maeliminar_sqlite);

        listView = findViewById(R.id.lvBebidasEliminar);
        editText = findViewById(R.id.edtNombreEliminar);
        button = findViewById(R.id.btnEliminarRegistro);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, llenarLista());
        this.clickItemLista();
        this.clickEliminar();
        listView.setAdapter(arrayAdapter);

    }
    private void clickItemLista(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                llenarEditTextNombre(position);
            }
        });
    }
    
    private void clickEliminar(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EliminarRegistro();
            }
        });
    }

    private ArrayList<String> llenarLista(){
        ArrayList<String> lista = new ArrayList<>();
        if(bdao.listarBebida(bvo, getApplicationContext())!=null){
            for (BebidaVO vo: bdao.listarBebida(bvo, getApplicationContext())) {
                lista.add(vo.getCodigoBebida()+". "+vo.getNombreBebida());
            }
        }
        return lista;
    }

    private void llenarEditTextNombre(int position){
        ArrayList<BebidaVO> eliminar = bdao.listarBebida(bvo, getApplicationContext());
        editText.setText(eliminar.get(position).getNombreBebida());
        bvo.setCodigoBebida(eliminar.get(position).getCodigoBebida());
    }
    
    private void EliminarRegistro(){
        if(!editText.getText().toString().isEmpty()){
            
            if(bdao.eliminarBebida(bvo, getApplicationContext())){
                editText.setText("");
                ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, llenarLista());
                listView.setAdapter(arrayAdapter);
                Toast.makeText(this, "Registro eliminado correctamente", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Error al eliminar el registro", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Debe elegir un registro de la lista", Toast.LENGTH_SHORT).show();
        }
    }


}