package com.luis.appgrid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterGrid extends BaseAdapter {
    private Context context;
    int referenciaGrid;
    ArrayList<Integer> imagenes = new ArrayList<>();
    ArrayList<String> nombres = new ArrayList<>();

    public AdapterGrid(Context context, int referenciaGrid, ArrayList<Integer> imagenes, ArrayList<String> nombres) {
        this.context = context;
        this.referenciaGrid = referenciaGrid;
        this.imagenes = imagenes;
        this.nombres = nombres;
    }

    @Override
    public int getCount() {
        return this.nombres.size();
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
        View view = convertView;
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        view = layoutInflater.inflate(R.layout.grid_personalizado, null);

        int imagenColor = imagenes.get(position);
        String nombreColor = nombres.get(position);
        ImageView imageView = view.findViewById(R.id.imgColor);
        TextView textView = view.findViewById(R.id.txtNombreColor);

        imageView.setImageResource(imagenColor);
        textView.setText(String.valueOf(nombreColor));

        return view;
    }
}
