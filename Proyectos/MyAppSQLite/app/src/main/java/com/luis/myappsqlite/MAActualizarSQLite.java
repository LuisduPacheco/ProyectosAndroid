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

public class MAActualizarSQLite extends AppCompatActivity {
    private ListView listView;
    private EditText editTextNombre, editTextSabor, editTextPresentacion, editTextTipo, editTextPrecio;
    private Button button;
    private BebidaVO bvo = new BebidaVO();
    private BebidaDAO bdao = new BebidaDAO();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maactualizar_sqlite);
        listView = findViewById(R.id.lvBebidasActualizar);
        editTextNombre = findViewById(R.id.edtNombreActualizar);
        editTextSabor = findViewById(R.id.edtSaborActualizar);
        editTextPresentacion = findViewById(R.id.edtPresentacionActualizar);
        editTextTipo = findViewById(R.id.edtTipoActualizar);
        editTextPrecio = findViewById(R.id.edtPrecioActualizar);
        button = findViewById(R.id.btnActualizarRegistro);

        this.clickItemLista();
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, llenarListaActualizar());
        listView.setAdapter(arrayAdapter);
        this.clickActualizar();
    }

    private void clickItemLista(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                llenarEditTextActualizar(position);
            }
        });
    }

    private void clickActualizar(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarBebida();
            }
        });
    }

    private ArrayList<String> llenarListaActualizar(){
        ArrayList<String> lista = new ArrayList<>();
        if(bdao.listarBebida(bvo, getApplicationContext()) != null){
            for (BebidaVO listaVO: bdao.listarBebida(bvo, getApplicationContext())) {
                lista.add(listaVO.getCodigoBebida()+". "+listaVO.getNombreBebida());
            }
        }
        return lista;
    }

    private void llenarEditTextActualizar(int position) {
        ArrayList<BebidaVO> datosActualizar = bdao.listarBebida(bvo, getApplicationContext());
        editTextNombre.setText(datosActualizar.get(position).getNombreBebida());
        editTextSabor.setText(datosActualizar.get(position).getSaborBebida());
        editTextPresentacion.setText(String.valueOf(datosActualizar.get(position).getPresentacionBebida()));
        editTextTipo.setText(datosActualizar.get(position).getTipoBebida());
        editTextPrecio.setText(datosActualizar.get(position).getPrecioBebida().toString());
        bvo.setCodigoBebida(datosActualizar.get(position).getCodigoBebida());
    }

    private void actualizarBebida(){
        if(!editTextNombre.getText().toString().isEmpty() && !editTextSabor.getText().toString().isEmpty() &&
            !editTextPresentacion.getText().toString().isEmpty() && !editTextTipo.getText().toString().isEmpty() &&
            !editTextPrecio.getText().toString().isEmpty()){

            bvo.setNombreBebida(editTextNombre.getText().toString());
            bvo.setSaborBebida(editTextSabor.getText().toString());
            bvo.setPresentacionBebida(Integer.parseInt(editTextPresentacion.getText().toString()));
            bvo.setTipoBebida(editTextTipo.getText().toString());
            bvo.setPrecioBebida(Double.parseDouble(editTextPrecio.getText().toString()));
            bvo.setCodigoBebida(bvo.getCodigoBebida());

            if(bdao.actualizarBebida(bvo, getApplicationContext())){
                    editTextPrecio.setText("");
                    editTextTipo.setText("");
                    editTextPresentacion.setText("");
                    editTextSabor.setText("");
                    editTextNombre.setText("");
                ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, llenarListaActualizar());
                listView.setAdapter(arrayAdapter);
                Toast.makeText(this, "Bebida actualizada correctamente", Toast.LENGTH_SHORT).show();
                }
            else{
                Toast.makeText(this, "Error en la actualización", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
}