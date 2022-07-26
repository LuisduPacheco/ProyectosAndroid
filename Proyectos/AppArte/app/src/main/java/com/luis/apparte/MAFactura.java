package com.luis.apparte;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MAFactura extends AppCompatActivity {
    TextView textViewDescrip, textViewN, textViewA, textViewNit;
    Button buttonFinaliza;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mafactura);

        textViewDescrip = findViewById(R.id.txtFactD);
        textViewN = findViewById(R.id.txtFactN);
        textViewA = findViewById(R.id.txtFactA);
        textViewNit = findViewById(R.id.txtFactNit);
        buttonFinaliza = findViewById(R.id.btnFactura);

        obtenerDatos();
        this.click();
    }

    private void click() {
        buttonFinaliza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void obtenerDatos () {
        Bundle bundle = getIntent().getExtras();
        String descripcion = bundle.getString("descripcion");
        String nombre = bundle.getString("nombre");
        String apellido = bundle.getString("apellido");
        String nit = bundle.getString("nit");

        textViewDescrip.setText(descripcion);
        textViewN.setText("Nombre: "+nombre);
        textViewA.setText("Apellido: "+apellido);
        textViewNit.setText("NIT: "+nit);

    }

}