package com.luis.myapppoemas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonLeer;
    private Button buttonRomance;
    private Button buttonVariados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLeer = findViewById(R.id.btnLeer);
        buttonRomance = findViewById(R.id.btnLeer1);
        buttonVariados = findViewById(R.id.btnLeer2);
        this.click();
    }

    private void unAutor(){
        Intent intent1 = new Intent(this, MainActivity2.class);
        startActivity(intent1);
    }

    private void romance(){
        Intent intent2 = new Intent(this, MainActivity3.class);
        startActivity(intent2);
    }

    private void variados(){
        Intent intent3 = new Intent(this, MainActivity4.class);
        startActivity(intent3);
    }

    private void click() {

        buttonLeer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                unAutor();
            }
        });
        buttonRomance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                romance();
            }
        });
        buttonVariados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                variados();
            }
        });

    }


}