package com.luis.myappnoticieroscrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttonI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonI = findViewById(R.id.btnInfo);
        this.click();

    }

    private void click() {
        buttonI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accionActivity();
            }
        });

    }

    private void accionActivity(){
        Intent intent = new Intent(this, MANoticiero.class);
        startActivity(intent);

    }
}