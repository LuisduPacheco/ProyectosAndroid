package com.luis.appedad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    Button button1, buttonExit;
    EditText editTextResultado;
    TextView textViewProducto, textViewProducto1, textViewProducto2, textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        editTextResultado = findViewById(R.id.edtResultadoP);
        button1 = findViewById(R.id.btnValidarP);
        buttonExit = findViewById(R.id.btnExit3);
        textViewProducto = findViewById(R.id.Producto);
        textViewProducto1 = findViewById(R.id.txtProducto1);
        textViewProducto2 = findViewById(R.id.txtProducto2);
        textViewResultado = findViewById(R.id.txtResultado);

        //variables para mostrar la multiplicación a realizar
        int random = (int) (Math.random() * 10);
        int random2 = (int) (Math.random() * 10);
        textViewProducto1.setText(String.valueOf(random));
        textViewProducto2.setText(String.valueOf(random2));

    }

    public void resultadoUsuario() {
        int factor1 = Integer.parseInt(textViewProducto1.getText().toString());
        int factor2 = Integer.parseInt(textViewProducto2.getText().toString());
        int resultado = factor1 * factor2;
        if (resultado == Integer.parseInt(editTextResultado.getText().toString())) {
            textViewResultado.setText("Excelente, eres todo un adulto");
            Toast.makeText(this, "Correcto, el resultado es: "+resultado, Toast.LENGTH_SHORT).show();
        }else{
            textViewResultado.setText("Incorrecto");

        }

    }

    public void onClick(View view) {


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultadoUsuario();
            }
        });

        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
    }
}