package com.luis.appfragmentdinamico;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class FragmentUno extends Fragment {



    public FragmentUno() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //1
        View view = inflater.inflate(R.layout.fragment_uno, container, false);
        this.estructuraFramentUno(view);

        return view;
    }

    private void estructuraFramentUno(View view) {
        //2
        Button button;
        button = view.findViewById(R.id.btnFrgUno);//Botón del fragment
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Te encuentras en el fragment No. 1", Toast.LENGTH_SHORT).show();
            }
        });
    }
}