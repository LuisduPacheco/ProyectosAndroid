package com.luis.appedad;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button1, button2, button3;
    private EditText editTextNombre, editTextEdad;
    private TextView textViewProducto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.btnValidar);
        button2 = findViewById(R.id.btnExit);

        editTextEdad = findViewById(R.id.edtEdad);
        editTextNombre = findViewById(R.id.edtNombre);




    }

    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity3.class);
        Intent intent2 = new Intent(this, MainActivity2.class);
        button1.setOnClickListener(new View.OnClickListener() {


        @Override
        public void onClick(View v) {
            String nombre = editTextNombre.getText().toString();
            String edad = editTextEdad.getText().toString();
            if(!nombre.isEmpty() && !edad.isEmpty()){
                if(Integer.parseInt(edad) >= 18){
                    startActivity(intent);

                }else{
                    startActivity(intent2);
                }
            }
            else{
                Toast.makeText(MainActivity.this, "Revise los campos", Toast.LENGTH_SHORT).show();
            }

        }
    });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    } //fin del public void onClick
}