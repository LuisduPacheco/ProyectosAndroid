package com.luis.apparte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MAExpresionismo extends AppCompatActivity {
    private Button button1, button2, button3;
    private TextView textView1, textView2, textView3;
    private ImageView imageView1, imageView2, imageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maexpresionismo);

        button1 = findViewById(R.id.btnExp1);
        button2 = findViewById(R.id.btnExp2);
        button3 = findViewById(R.id.btnExp3);

        textView1 = findViewById(R.id.txtExp1);
        textView2 = findViewById(R.id.txtExp2);
        textView3 = findViewById(R.id.txtExp3);

        this.click ();
    }

    private void click() {
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trasladoDatos1();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trasladoDatos2();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trasladoDatos3();
            }
        });
    }

    public void trasladoDatos1() {
        Intent intent = new Intent(this, MACompra.class);
        int imagen = R.drawable.ic_exp1;
        String descripcion = textView1.getText().toString();
        intent.putExtra("imagen", imagen);
        intent.putExtra("descripcion", descripcion);
        startActivity(intent);
    }

    public void trasladoDatos2() {
        Intent intent = new Intent(this, MACompra.class);
        int imagen = R.drawable.ic_exp2;
        String descripcion = textView2.getText().toString();
        intent.putExtra("imagen", imagen);
        intent.putExtra("descripcion", descripcion);
        startActivity(intent);
    }
    public void trasladoDatos3() {
        Intent intent = new Intent(this, MACompra.class);
        int imagen = R.drawable.ic_exp3;
        String descripcion = textView3.getText().toString();
        intent.putExtra("imagen", imagen);
        intent.putExtra("descripcion", descripcion);
        startActivity(intent);
    }


}