package com.luis.myappsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.luis.myappsqlite.basededatos.BebidaDAO;
import com.luis.myappsqlite.basededatos.BebidaVO;

public class MAInsertarSQLite extends AppCompatActivity {
    private EditText editTextNombre, editTextSabor, editTextPresentacion, editTextTipo, editTextPrecio;
    private Button buttonInsertar;
    private BebidaDAO bdao = new BebidaDAO();
    private BebidaVO bvo = new BebidaVO();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainsertar_sqlite);

        editTextNombre = findViewById(R.id.edtNombreBebidaInsertar);
        editTextSabor = findViewById(R.id.edtSaborBebidaInsertar);
        editTextPresentacion = findViewById(R.id.edtPresentacionBebidaInsertar);
        editTextTipo = findViewById(R.id.edtTipoBebidaInsertar);
        editTextPrecio = findViewById(R.id.edtPrecioBebidaInsertar);
        buttonInsertar = findViewById(R.id.btnInsertarRegistro);

        this.clickInsertar();
    }
    private void clickInsertar(){
        buttonInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarBebida();
            }
        });
    }
    private void registrarBebida(){
        if(!editTextNombre.getText().toString().isEmpty() && !editTextSabor.getText().toString().isEmpty()&&
            !editTextPresentacion.getText().toString().isEmpty() && !editTextTipo.getText().toString().isEmpty()&&
            !editTextPrecio.getText().toString().isEmpty()){
            bvo.setNombreBebida(editTextNombre.getText().toString());
            bvo.setSaborBebida(editTextSabor.getText().toString());
            bvo.setPresentacionBebida(Integer.parseInt(editTextPresentacion.getText().toString()));
            bvo.setTipoBebida(editTextTipo.getText().toString());
            bvo.setPrecioBebida(Double.parseDouble(editTextPrecio.getText().toString()));
            if(bdao.insertarBebida(bvo, getApplicationContext())){
                editTextNombre.setText("");
                editTextSabor.setText("");
                editTextPresentacion.setText("");
                editTextTipo.setText("");
                editTextPrecio.setText("");
                Toast.makeText(this, "Bebida Registrada Correctamente", Toast.LENGTH_SHORT).show();
            }else{
                //El contexto puede ser this o getAplicationContext
                Toast.makeText(this, "Error en el registro", Toast.LENGTH_SHORT).show();
        }
        }else {
            Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
}