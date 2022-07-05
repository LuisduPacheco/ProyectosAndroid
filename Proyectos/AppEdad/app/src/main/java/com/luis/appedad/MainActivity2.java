package com.luis.appedad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    Button buttonValidarS, buttonExit;
    TextView textViewSuma1, textViewSuma2, textViewResultadoS;
    EditText editTextResultadoS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        buttonValidarS = findViewById(R.id.btnValidarS);
        buttonExit = findViewById(R.id.btnExit2);
        textViewSuma1 = findViewById(R.id.txtSuma1);
        textViewSuma2 = findViewById(R.id.txtSuma2);
        textViewResultadoS = findViewById(R.id.txtResultadoS);
        editTextResultadoS = findViewById(R.id.edtResultadoS);

        int random1 = (int) (Math.random() * 10);
        int random2 = (int) (Math.random() * 10);

        textViewSuma1.setText(String.valueOf(random1));
        textViewSuma2.setText(String.valueOf(random2));

    }

    public void resultadoUsuarioS() {
        int sumando1 = Integer.parseInt(textViewSuma1.getText().toString());
        int sumando2 = Integer.parseInt(textViewSuma2.getText().toString());
        int resultado = sumando1 + sumando2;
        if (resultado == Integer.parseInt(editTextResultadoS.getText().toString())) {
            textViewResultadoS.setText("Excelente, no eres tan bebé");
            Toast.makeText(this, "Correcto, el resultado es: "+resultado, Toast.LENGTH_SHORT).show();
        }else{
            textViewResultadoS.setText("Incorrecto");
        }

    }

    public void onClick(View view) {

        buttonValidarS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultadoUsuarioS();
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