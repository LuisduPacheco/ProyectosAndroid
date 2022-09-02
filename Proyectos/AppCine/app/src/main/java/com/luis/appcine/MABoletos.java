package com.luis.appcine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MABoletos extends AppCompatActivity {

    private EditText editTextNombre, editTextNit, editTextApellido, editTextBoletos;
    private TextView textViewTotal, textViewPagado;
    private Button buttonTotal, buttonPagar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maboletos);
        editTextNombre = findViewById(R.id.edtNombreC);
        editTextApellido = findViewById(R.id.edtApellido);
        editTextNit = findViewById(R.id.edtNitC);
        editTextBoletos = findViewById(R.id.edtCantidad);
        buttonPagar = findViewById(R.id.btnPagar);
        buttonTotal = findViewById(R.id.btnVerTotal);
        textViewTotal = findViewById(R.id.txtTotalC);
        textViewPagado = findViewById(R.id.txtPagado);
        this.clickTotal();
        this.clickPagar();
    }

    private void clickPagar() {
        buttonPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pagar();
            }
        });
    }

    private void clickTotal() {
        buttonTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total();
            }
        });

    }

    private boolean total(){
        int precio, cantidad, total;
        String boletos = editTextBoletos.getText().toString();
        if(!boletos.isEmpty()){
            if(Integer.parseInt(boletos) > 0){
                precio = 60;
                cantidad = Integer.parseInt(boletos);
                total = precio*cantidad;
                textViewTotal.setText("Q."+total+".00\n"+"Cantidad de Boletos: "+cantidad);
                return true;
            }else{
                Toast.makeText(this, "Cantidad de boletos no valida", Toast.LENGTH_SHORT).show();
                return false;
            }
        }else{
            Toast.makeText(this, "Ingrese una cantidad de boletos", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void pagar(){
        if(!editTextNit.getText().toString().isEmpty() && !editTextApellido.getText().toString().isEmpty()
            && !editTextNit.getText().toString().isEmpty()){
            if(total() == true){
                editTextNit.setText("");
                editTextNombre.setText("");
                editTextApellido.setText("");
                editTextBoletos.setText("");
                textViewPagado.setText("Pago realizado con éxito\n"+"!GRACIAS POR SU VISITA!");

            }
        }else{
            Toast.makeText(this, "Llenar todos los datos para la factura", Toast.LENGTH_SHORT).show();
        }
    }




}