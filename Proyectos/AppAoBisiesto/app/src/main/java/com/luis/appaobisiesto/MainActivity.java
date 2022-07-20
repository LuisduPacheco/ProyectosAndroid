package com.luis.appaobisiesto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonVerifica;
    private EditText editTextAnio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonVerifica = findViewById(R.id.btnVerificar);
        editTextAnio = findViewById(R.id.edtAnio);

        this.click();

    }
    private void click() {
        buttonVerifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datosATrasladar();
            }
        });
    }

    private void datosATrasladar(){
        String anio = editTextAnio.getText().toString();

        if(!anio.isEmpty() && Integer.parseInt(anio)!=0){
            Intent intent = new Intent(this, MAResultados.class);
            intent.putExtra("anio", anio);
            startActivity(intent);
            editTextAnio.setText("");
        }
        else if (anio.isEmpty()){
            Toast.makeText(this, "Error. Ingresar un año", Toast.LENGTH_SHORT).show();
        }
        else if(Integer.parseInt(anio) ==0 ){
            Toast.makeText(this, "El año 0 no entra en ninguna categoría", Toast.LENGTH_SHORT).show();
        }

    }

}