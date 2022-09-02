package com.luis.myappsqlite;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
public class FragmentDetalle extends Fragment {
    private String codigo, nombre, sabor, presentacion, tipo, precio;
    public FragmentDetalle() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            codigo = getArguments().getString("codigo");
            nombre = getArguments().getString("nombre");
            sabor = getArguments().getString("sabor");
            presentacion = getArguments().getString("presentacion");
            tipo = getArguments().getString("tipo");
            precio = getArguments().getString("precio");
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detalle, container, false);
        llenarFragmento(view);
        return view;
    }
    private void llenarFragmento(View view){
        TextView textViewCodigo, textViewNombre, textViewSabor, textViewPresentacion, textViewTipo, textViewPrecio;
        textViewCodigo = view.findViewById(R.id.txtCodigoFragment);
        textViewNombre = view.findViewById(R.id.txtNombreFragment);
        textViewSabor = view.findViewById(R.id.txtSaborFragment);
        textViewPresentacion = view.findViewById(R.id.txtPresentacionFragment);
        textViewTipo = view.findViewById(R.id.txtTipoFragment);
        textViewPrecio = view.findViewById(R.id.txtPrecioFragment);

        textViewCodigo.setText(String.valueOf(codigo));
        textViewNombre.setText(String.valueOf(nombre));
        textViewSabor.setText("Sabor: "+sabor);
        textViewPresentacion.setText("Presentacion: "+presentacion+"m");
        textViewTipo.setText("Tipo: "+tipo);
        textViewPrecio.setText("Precio: Q."+precio);

    }

}