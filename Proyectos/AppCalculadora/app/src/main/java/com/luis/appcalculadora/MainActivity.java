package com.luis.appcalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNum1, editTextNum2;
    private TextView textViewResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNum1 = findViewById(R.id.edtNum1);
        editTextNum2 = findViewById(R.id.edtNum2);
        textViewResultado = findViewById(R.id.txtResultado);

    }
    private void suma(){
        String num1 = editTextNum1.getText().toString();
        String num2 = editTextNum2.getText().toString();
        if(!num1.isEmpty() && !num2.isEmpty()){
            int sumar = Integer.parseInt(num1)+Integer.parseInt(num2);
            textViewResultado.setText(String.valueOf(sumar));

        }
        else {
            Toast.makeText(this, "Datos no ingresados", Toast.LENGTH_SHORT).show();
        }
    }
    private void restar(){
        String num1 = editTextNum1.getText().toString();
        String num2 = editTextNum2.getText().toString();
        if(!num1.isEmpty() && !num2.isEmpty()){
            int restar = Integer.parseInt(num1)-Integer.parseInt(num2);
            textViewResultado.setText(String.valueOf(restar));

        }
        else {
            Toast.makeText(this, "Datos no ingresados", Toast.LENGTH_SHORT).show();
        }
    }

    private void multiplica(){
        String num1 = editTextNum1.getText().toString();
        String num2 = editTextNum2.getText().toString();
        if(!num1.isEmpty() && !num2.isEmpty()){
            int multiplicar = Integer.parseInt(num1)*Integer.parseInt(num2);
            textViewResultado.setText(String.valueOf(multiplicar));

        }
        else {
            Toast.makeText(this, "Datos no ingresados", Toast.LENGTH_SHORT).show();
        }

    }

    private void mayor(){
        String num1 = editTextNum1.getText().toString();
        String num2 = editTextNum2.getText().toString();
        if(!num1.isEmpty() && !num2.isEmpty()){
            int r1 = Integer.parseInt(num1);
            int r2 = Integer.parseInt(num2);
            if (r1>r2){
                textViewResultado.setText(String.valueOf(r1 + ">"+r2));
            } else if(r2>r1) {
                textViewResultado.setText(String.valueOf(r2 + ">"+r1));
            }else {
                textViewResultado.setText(String.valueOf(r1 + "="+r2));
            }
        }
        else {
            Toast.makeText(this, "Datos no ingresados", Toast.LENGTH_SHORT).show();
        }

    }

    private void divide(){
        String num1 = editTextNum1.getText().toString();
        String num2 = editTextNum2.getText().toString();
        if(!num1.isEmpty() && !num2.isEmpty()){

            if(Integer.parseInt(num2) == 0){
                Toast.makeText(this, "Error, no existe división dentro de 0", Toast.LENGTH_SHORT).show();
                textViewResultado.setText(String.valueOf("No existe división entre 0"));
            }
            else {
                int dividir = Integer.parseInt(num1)/Integer.parseInt(num2);
                textViewResultado.setText(String.valueOf(dividir));
            }
        }
        else {
            Toast.makeText(this, "Datos no ingresados", Toast.LENGTH_SHORT).show();
        }

    }


    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSumar:
                this.suma();
                break;
            case R.id.btnRestar:
                this.restar();
                break;
            case  R.id.btnMultiplica:
                this.multiplica();
                break;
            case R.id.btnDividir:
                this.divide();
                break;
            case R.id.btnMayor:
                this.mayor();
                break;

        }
    }
}