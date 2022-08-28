package com.luis.appcine;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FrgReparto extends Fragment {


    public FrgReparto() {
        // Required empty public constructor
    }

    private int reparto;
    @Override
    public void onCreate(Bundle saverdInstanceState){
        super.onCreate(saverdInstanceState);
        if(getArguments() != null){
            reparto = getArguments().getInt("prot"); // F
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frm_reparto, container, false);

        //E Para recibir la información en los Fragment
        estructuraFragment(view);
        return view;
    }

    private void estructuraFragment(View view) {
        TextView textView = view.findViewById(R.id.txtReparto);
        textView.setText(reparto);
    }
}