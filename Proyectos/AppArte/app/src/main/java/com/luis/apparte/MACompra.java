package com.luis.apparte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MACompra extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;
    private Button button, buttonCancelar;
    private EditText editTextN, editTextA, editTextNit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macompra);

        imageView = findViewById(R.id.imgCompra);
        textView = findViewById(R.id.txtNombreArt);
        button = findViewById(R.id.btnComprar);
        buttonCancelar = findViewById(R.id.btnCancelar);
        editTextN = findViewById(R.id.edtNombre);
        editTextA = findViewById(R.id.edtApellido);
        editTextNit = findViewById(R.id.edtNit);
        obtenerDatos();

        this.click();

    }

    private void click() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = editTextN.getText().toString();
                String apellido = editTextA.getText().toString();
                String nit = editTextNit.getText().toString();

                if(!nombre.isEmpty() && !apellido.isEmpty() && !nit.isEmpty()){
                    trasladoAFactura();
                }
                else  {
                    Toast.makeText(MACompra.this, "LLene todos los campos", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextN.setText("");
                editTextA.setText("");
                editTextNit.setText("");
                finish();
            }
        });
    }

    private void obtenerDatos () {
        Bundle bundle = getIntent().getExtras();
        int imagen = bundle.getInt("imagen");
        String descripcion = bundle.getString("descripcion");
        imageView.setImageResource(imagen);
        textView.setText(descripcion);

    }

    private void trasladoAFactura() {
        Intent intent = new Intent(this, MAFactura.class);
        Intent intent2 = new Intent(this, MainActivity.class);
        String descripcion = textView.getText().toString();
        String nombre = editTextN.getText().toString();
        String apellido = editTextA.getText().toString();
        String nit = editTextNit.getText().toString();
        
        intent.putExtra("descripcion", descripcion);
        intent.putExtra("nombre", nombre);
        intent.putExtra("apellido", apellido);
        intent.putExtra("nit", nit);
        startActivity(intent);
        finish(); //
    }


}