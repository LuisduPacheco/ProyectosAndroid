package com.luis.appcontactosrv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorRecyclerView extends RecyclerView.Adapter<AdaptadorRecyclerView.ViewHolder> {
    private ArrayList<DatosVO> datosVOS = new ArrayList<>();

    public AdaptadorRecyclerView(ArrayList<DatosVO> datosVOS) {
        this.datosVOS = datosVOS;
    }

    @Override
    public AdaptadorRecyclerView.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_contact, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( AdaptadorRecyclerView.ViewHolder holder, int position) {
        holder.asignarDatos(datosVOS.get(position).getStringNombre(), datosVOS.get(position).getStringApellido(),
                            datosVOS.get(position).getStringNumero(), datosVOS.get(position).getImagenContacto());
    }

    @Override
    public int getItemCount() {
        return this.datosVOS.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewNombre, textViewApellido, textViewNumero;
        private ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewNombre = itemView.findViewById(R.id.txtNombre);
            textViewApellido = itemView.findViewById(R.id.txtApellido);
            textViewNumero = itemView.findViewById(R.id.txtNumero);
            imageView = itemView.findViewById(R.id.imgRecycle);
        }
        private void asignarDatos(String stringNombre, String stringApellido, String stringNumero, Integer imagenContacto){
            textViewNombre.setText(String.valueOf(stringNombre));
            textViewApellido.setText(String.valueOf(stringApellido));
            textViewNumero.setText(String.valueOf(stringNumero));
            imageView.setImageResource(imagenContacto);
        }
    }
}
