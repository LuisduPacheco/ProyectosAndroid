package com.luis.apprecyclerviewvo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class AdaptadorRecyclerView extends RecyclerView.Adapter<AdaptadorRecyclerView.ViewHolder> {
private ArrayList<DatosVO> datosVO = new ArrayList<>();
    public AdaptadorRecyclerView(ArrayList<DatosVO> datosVO) {
        this.datosVO = datosVO;
    }
    @Override
    public AdaptadorRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(AdaptadorRecyclerView.ViewHolder holder, int position) {
        holder.asignarDatos(datosVO.get(position).getNombreRestaurante(), datosVO.get(position).getCalidadRestaurante(),
                            datosVO.get(position).getImagenRestaurante());
    }
    @Override
    public int getItemCount() {
        return this.datosVO.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewNombre, textViewCalidad;
        private ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewNombre = itemView.findViewById(R.id.txtNombreRecycle);
            textViewCalidad = itemView.findViewById(R.id.txtCalidadRecycle);
            imageView = itemView.findViewById(R.id.imgRecycle);
        }
        private void asignarDatos(String nombre, String calidad, Integer imagen){
            textViewNombre.setText(String.valueOf(nombre));
            textViewCalidad.setText(String.valueOf(calidad));
            imageView.setImageResource(imagen);
        }
    }
}
