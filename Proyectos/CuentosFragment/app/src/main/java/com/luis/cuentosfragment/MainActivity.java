package com.luis.cuentosfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageButton imageButtonL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageButtonL = findViewById(R.id.imbLibro);
        
        this.clickImageButton();

    }

    private void clickImageButton() {
        imageButtonL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Cuentos...", Toast.LENGTH_SHORT).show();
                leerCuentos();
            }
        });

    }

    private void leerCuentos (){
        Intent intent = new Intent(this, MACuentos.class);
        startActivity(intent);
    }

}