package com.luis.myappproductosiva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText editTextNombre, editTextCantidad, editTextValor;
    private TextView textViewProducto, textViewPrecio, textViewTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNombre = findViewById(R.id.edtNombre);
        editTextCantidad = findViewById(R.id.edtCant);
        editTextValor = findViewById(R.id.edtValor);

    }

    public void onClick(View view) {
    }
}