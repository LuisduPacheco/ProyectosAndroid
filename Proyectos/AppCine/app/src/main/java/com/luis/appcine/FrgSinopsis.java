package com.luis.appcine;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FrgSinopsis extends Fragment {

    public FrgSinopsis() {
        // Required empty public constructor
    }
    private int sinopsis;

    @Override
    public void onCreate(Bundle saverdInstanceState){
        super.onCreate(saverdInstanceState);
        if(getArguments() != null){
            sinopsis = getArguments().getInt("sinop"); // F
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frg_sinopsis, container, false);


        //E Para recibir la información en los Fragment
        estructuraFragment(view);
        return view;


    }

    private void estructuraFragment(View view) {
        TextView textView = view.findViewById(R.id.txtSinopsis);
        textView.setText(sinopsis);
    }


}