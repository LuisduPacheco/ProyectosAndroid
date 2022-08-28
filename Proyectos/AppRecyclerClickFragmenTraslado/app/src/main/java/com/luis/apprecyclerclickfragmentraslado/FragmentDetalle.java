package com.luis.apprecyclerclickfragmentraslado;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentDetalle extends Fragment {


    public FragmentDetalle() {
        // Required empty public constructor
    }

    private int detalleDF;//A

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //mParam1 = getArguments().getString(ARG_PARAM1);
            detalleDF = getArguments().getInt("detalleDF");//B
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detalle, container, false); //1
        //D
        estructuraFragment(view);

        return view;
    }
    //C
    private void estructuraFragment(View view){
        TextView textView = view.findViewById(R.id.txtDetalles);
        textView.setText(detalleDF);
    }


}