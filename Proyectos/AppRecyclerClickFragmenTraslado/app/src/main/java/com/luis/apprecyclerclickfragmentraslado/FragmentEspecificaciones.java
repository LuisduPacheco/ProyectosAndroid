package com.luis.apprecyclerclickfragmentraslado;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentEspecificaciones extends Fragment {
    private int especificacionesDF;
    public FragmentEspecificaciones() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //mParam1 = getArguments().getString(ARG_PARAM1);
            especificacionesDF = getArguments().getInt("especificacionesDF");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_especificaciones, container, false); //1
        estructuraFragment(view);
        return view;
    }

    private void estructuraFragment(View view){
        TextView textView = view.findViewById(R.id.txtEspecificaciones);
        textView.setText(especificacionesDF);
    }
}