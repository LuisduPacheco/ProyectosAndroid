package com.luis.appcine;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FrgPuntuacion extends Fragment {

    public FrgPuntuacion() {
        // Required empty public constructor
    }

    private int recaudacion;
    @Override
    public void onCreate(Bundle saverdInstanceState){
        super.onCreate(saverdInstanceState);
        if(getArguments() != null){
            recaudacion = getArguments().getInt("rec"); // F
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frg_puntuacion, container, false);
        estructuraFragment(view);
        return view;
    }

    private void estructuraFragment(View view) {
        TextView textView = view.findViewById(R.id.txtPuntuacion);
        textView.setText(recaudacion);
    }
}