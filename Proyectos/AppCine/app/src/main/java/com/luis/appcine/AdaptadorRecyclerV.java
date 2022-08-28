package com.luis.appcine;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

//Recycler
public class AdaptadorRecyclerV extends RecyclerView.Adapter<AdaptadorRecyclerV.ViewHolder> {
    private static ClickListener clickListener;
    private ArrayList<DatosVO> datosVO = new ArrayList<>();
    public AdaptadorRecyclerV(ArrayList<DatosVO> datosVO){
        this.datosVO = datosVO;
    }

    @Override
    public AdaptadorRecyclerV.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }
    @Override
    public void onBindViewHolder(AdaptadorRecyclerV.ViewHolder holder, int position){
        holder.asignarDatos(datosVO.get(position).getStringTitulo(),
                            datosVO.get(position).getStringTiempo(),
                            datosVO.get(position).getIntegerImagen());
    }
    @Override
    public int getItemCount() {
        return this.datosVO.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView textViewNombre, textViewTiempo;
        private ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNombre = itemView.findViewById(R.id.txtRecyclerTitulo);
            textViewTiempo = itemView.findViewById(R.id.txtRecyclerTiempo);
            imageView = itemView.findViewById(R.id.imgRecycler);
            //3. Para el click en el CardView
            itemView.setOnClickListener(this);
        }


        private void asignarDatos(String nombre, String tiempo, Integer imagen){
            textViewNombre.setText(String.valueOf(nombre));
            textViewTiempo.setText(String.valueOf(tiempo));
            imageView.setImageResource(imagen);
        }

        //2 Para el click en el RecyclerView
        @Override
        public void onClick(View v) {
            clickListener.itemClick(getAdapterPosition(),v);
        }
    }

    //3. Para recocnocer el click en el recycler view
    public void setItemClickListener(ClickListener clickListener){
        AdaptadorRecyclerV.clickListener = clickListener;
    }
}
