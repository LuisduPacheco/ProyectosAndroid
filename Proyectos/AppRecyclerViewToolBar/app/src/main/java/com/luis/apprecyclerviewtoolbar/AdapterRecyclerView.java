package com.luis.apprecyclerviewtoolbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder> {
    private ArrayList<DatosVO> datosVOS = new ArrayList<>();

    public AdapterRecyclerView(ArrayList<DatosVO> datosVOS) {
        this.datosVOS = datosVOS;
    }

    @Override
    public AdapterRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AdapterRecyclerView.ViewHolder holder, int position) {
        holder.asignarDatos(datosVOS.get(position).getStringVocal(),
                            datosVOS.get(position).getIntegerImagen());
    }

    @Override
    public int getItemCount() {
        return this.datosVOS.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        private ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txtLetraR);
            imageView = itemView.findViewById(R.id.imgRecycle);

        }
        private void asignarDatos(String letra, Integer imagen){
            textView.setText(String.valueOf(letra));
            imageView.setImageResource(imagen);
        }
    }
}
