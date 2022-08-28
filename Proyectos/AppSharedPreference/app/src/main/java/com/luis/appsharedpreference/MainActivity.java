package com.luis.appsharedpreference;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    private EditText editTextNombre, editTextEdad;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNombre = findViewById(R.id.edtNombreSP);
        editTextEdad = findViewById(R.id.edtEdadSP);
        button = findViewById(R.id.btnAlmacenar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                almacenarDatos();
            }
        });
        this.obtenerDatos();
    }
    private void almacenarDatos(){
        if(!editTextNombre.getText().toString().isEmpty() && !editTextEdad.getText().toString().isEmpty()){
            //Instanciar la clase SharedPreference para utilizar su objeto, ya que permite realizar la acción de almacenado
            SharedPreferences preferences = getSharedPreferences("DatosPreferidos", Context.MODE_PRIVATE);
            String nombre = editTextNombre.getText().toString();
            int edad = Integer.parseInt(editTextEdad.getText().toString());

            //Almacenar los datos que se encuentran en las variables
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("nombre", nombre);
            editor.putInt("edad", edad);
            if(editor.commit() == true){
                editTextNombre.setText("");
                editTextEdad.setText("");
                Toast.makeText(this, "Datos Almacenados", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Datos no almacenados", Toast.LENGTH_SHORT).show();
            }
           
        }else{
            Toast.makeText(this, "Llenar los espacios", Toast.LENGTH_SHORT).show();
        }
    }
    private void obtenerDatos(){
        SharedPreferences preferences = getSharedPreferences("DatosPreferidos", Context.MODE_PRIVATE);
        //Se asignan los datos que están almacenados en el preference
        //Definir valores por defecto ya que el archivo puede estar vacío
        String nombre = preferences.getString("nombre","");
        int edad = preferences.getInt("edad", 0);
        String edadMostrar = "";
        if(edad == 0){
            edadMostrar = "";
            editTextEdad.setText(String.valueOf(edadMostrar));
        }else{
            editTextEdad.setText(String.valueOf(edad));
        }

        editTextNombre.setText(String.valueOf(nombre));

    }
}