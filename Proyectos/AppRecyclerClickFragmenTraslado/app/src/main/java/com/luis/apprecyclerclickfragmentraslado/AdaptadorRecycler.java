package com.luis.apprecyclerclickfragmentraslado;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.ViewHolder> {

    //1
    private ArrayList<DatosVO> datosVOS = new ArrayList<>();

    //Paso1
    private static ClickListener clickListener; //variable propia

    public AdaptadorRecycler(ArrayList<DatosVO> datosVOS) {
        this.datosVOS = datosVOS;
    }

    @NonNull
    @Override
    public AdaptadorRecycler.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //3
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorRecycler.ViewHolder holder, int position) {
        holder.setData(datosVOS.get(position).getImagen(),
                datosVOS.get(position).getNombre(),
                datosVOS.get(position).getPrecio());
    }

    @Override
    public int getItemCount() {
        return this.datosVOS.size(); //2
    }

    //Paso 3. implements View.OnClickListener
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //4
        private ImageView imageView;
        private TextView textViewNombre, textViewPrecio;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //5
            imageView = itemView.findViewById(R.id.imgRecycler);
            textViewNombre = itemView.findViewById(R.id.txtNombre);
            textViewPrecio = itemView.findViewById(R.id.txtPrecio);
            //Paso 6
            itemView.setOnClickListener(this);
        }

        private void setData(Integer img, Integer nombre, Integer precio) {
            imageView.setImageResource(img); //6
            textViewNombre.setText(nombre);
            textViewPrecio.setText(precio);

        }

        //Paso 4
        @Override
        public void onClick(View v) {
            //Paso 7
            clickListener.itemClick(getAdapterPosition(),v);
        }
    }
    //Paso 5 reconocer el click en los apartados del recycler view
    public void setItemClickListener(ClickListener clickListener){
        AdaptadorRecycler.clickListener = clickListener;
    }
}
