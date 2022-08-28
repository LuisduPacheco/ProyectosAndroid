package com.luis.appsharedpreferenceej;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextNombre, editTextApellido, editTextNacimiento, editTextFruta;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNombre = findViewById(R.id.txtNombre);
        editTextApellido = findViewById(R.id.txtApellido);
        editTextNacimiento = findViewById(R.id.txtNacimiento);
        editTextFruta = findViewById(R.id.txtFruta);
        button = findViewById(R.id.btnDatos);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                almacenarDatos();
            }
        });
        obtenerDatos();
    }

    private void almacenarDatos(){
        if(!editTextNombre.getText().toString().isEmpty() && !editTextApellido.getText().toString().isEmpty()
        && !editTextNacimiento.getText().toString().isEmpty() && !editTextFruta.getText().toString().isEmpty()){
            SharedPreferences preferences = getSharedPreferences("DatosPreferidos", Context.MODE_PRIVATE);
            String nombre = editTextNombre.getText().toString();
            String apellido = editTextApellido.getText().toString();
            String nacimiento = editTextNacimiento.getText().toString();
            String fruta = editTextFruta.getText().toString();

            //Almacenar los datos que se encuetran en las variables
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("nombre", nombre);
            editor.putString("apellido", apellido);
            editor.putString("nacimiento", nacimiento);
            editor.putString("fruta", fruta);

            if(editor.commit()==true){
                editTextNombre.setText("");
                editTextApellido.setText("");
                editTextNacimiento.setText("");
                editTextFruta.setText("");
                Toast.makeText(this, "Datos almacenados", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Datos no almacenados", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    private void obtenerDatos(){
        SharedPreferences preferences = getSharedPreferences("DatosPreferidos", Context.MODE_PRIVATE);
        String nombre = preferences.getString("nombre","");
        String apellido = preferences.getString("apellido","");
        String nacimiento = preferences.getString("nacimiento", "");
        String fruta = preferences.getString("fruta","");

        editTextNombre.setText(String.valueOf(nombre));
        editTextApellido.setText(String.valueOf(apellido));
        editTextNacimiento.setText(String.valueOf(nacimiento));
        editTextFruta.setText(String.valueOf(fruta));
    }
}