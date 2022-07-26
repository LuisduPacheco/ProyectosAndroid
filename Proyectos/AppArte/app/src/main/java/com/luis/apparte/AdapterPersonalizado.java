package com.luis.apparte;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AdapterPersonalizado extends BaseAdapter { // #1 extends

    // #2. Atributos para el AdapterPersonalizado
    private Context context;
    private int referenciaLista;
    ArrayList<String> tipoArte = new ArrayList<>();

    // #3. Constructor
    public AdapterPersonalizado (Context context, int referenciaLista, ArrayList<String> tipoArte) {
        this.context = context;
        this.referenciaLista = referenciaLista;
        this.tipoArte = tipoArte;

    }

    @Override
    public int getCount() {
        //return 0;
        return this.tipoArte.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // #4. Variable para el retorno, tipo View
        View view = convertView;

        // #5. Implementación de un View diseñado usando LayoutInflater
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.list_personalizada, null);

        // #6. Recibir la info por posicion de los ArrayList
        String tipoDeArte = this.tipoArte.get(position);

        TextView textViewNombreArte = view.findViewById(R.id.txtNombreArte);
        Button buttonVer = view.findViewById(R.id.btnVer);

        textViewNombreArte.setText(String.valueOf(tipoDeArte));


        //Método del botón

        buttonVer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                trasladarDatos(position);
            }
        });
        return view;
    }

    public void trasladarDatos (int position) {
        Intent intent = new Intent(context, MAAbstracto.class);
        Intent intent1 = new Intent(context, MARealismo.class);
        Intent intent2 = new Intent(context, MAHiperRealismo.class);
        Intent intent3 = new Intent(context, MAExpresionismo.class);
        Intent intent4 = new Intent(context, MAPop.class);
        if (position == 0){
            context.startActivity(intent);
        }
        else if (position == 1){
            context.startActivity(intent1);
        }
        else if (position == 2){
            context.startActivity(intent2);
        }
        else if (position == 3){
            context.startActivity(intent3);
        }
        else if (position == 4){
            context.startActivity(intent4);
        }
        else {
            Toast.makeText(context, "Aun no", Toast.LENGTH_SHORT).show();
        }
    }


}
