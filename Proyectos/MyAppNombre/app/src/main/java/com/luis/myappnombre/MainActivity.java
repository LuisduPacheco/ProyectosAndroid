package com.luis.myappnombre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNombre;
    private TextView textViewResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNombre = findViewById(R.id.edtNombre);
        textViewResultado = findViewById(R.id.txtResultado);

    }
    private void mostrar(){
        String nombre = editTextNombre.getText().toString();
    if(!nombre.isEmpty()){
        textViewResultado.setText("Su nombre es: "+nombre);
        textViewResultado.setText("Su año de nacimiento es:");
    }else {
        Toast.makeText(this, "Dato no ingresado", Toast.LENGTH_SHORT).show();
    }
    }

    private void mostrarEdad(){
        int edad = Integer.parseInt(editTextNombre.getText().toString());

    }


    public void onclick(View view) {
        switch (view.getId()){
            case R.id.btnMostrar:
                this.mostrar();
                break;
        }
    }
}