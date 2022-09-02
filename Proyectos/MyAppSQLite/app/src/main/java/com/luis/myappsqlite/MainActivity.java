package com.luis.myappsqlite;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    private Button buttonInsertar;
    private Button buttonBuscar, buttonListado, buttonActualizar, buttonEliminar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonInsertar = findViewById(R.id.btnInsertarMenu);
        buttonBuscar = findViewById(R.id.btnBuscarId);
        buttonListado = findViewById(R.id.btnListar);
        buttonActualizar = findViewById(R.id.btnActualizar);
        buttonEliminar = findViewById(R.id.btnEliminar);
        this.navegacionMenu();
        this.BuscarId();
        this.Listar();
        this.Actualizar();
        this.Eliminar();
    }

    private void Eliminar() {
        buttonEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirEliminar();
            }
        });
    }

    private void Actualizar() {
        buttonActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirActualizar();
            }
        });
    }

    private void Listar() {
        buttonListado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirListar();
            }
        });
    }

    private void navegacionMenu(){
        buttonInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirInsertar();
            }
        });
    }
    private void BuscarId(){
        buttonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            abrirBuscar();
            }
        });
    }



    
    private void abrirBuscar(){
        Intent intent = new Intent(this, MABuscarIdSQLite.class);
        startActivity(intent);
    }
    private void abrirInsertar(){
        Intent intent = new Intent(this, MAInsertarSQLite.class);
        startActivity(intent);
    }
    private void abrirListar(){
        Intent intent = new Intent(this, MAListarSQLite.class);
        startActivity(intent);
    }

    private void abrirActualizar(){
        Intent intent = new Intent(this, MAActualizarSQLite.class);
        startActivity(intent);
    }
    private void abrirEliminar(){
        Intent intent = new Intent(this, MAEliminarSQLite.class);
        startActivity(intent);
    }
}