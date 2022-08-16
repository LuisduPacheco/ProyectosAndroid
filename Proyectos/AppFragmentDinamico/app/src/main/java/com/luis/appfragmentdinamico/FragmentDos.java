package com.luis.appfragmentdinamico;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class FragmentDos extends Fragment {

    public FragmentDos() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dos, container, false);
        this.estructuraFragmentDos(view);
        return view;
    }

    private void estructuraFragmentDos(View view) {
        Button button;
        button = view.findViewById(R.id.btnFrgDos);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Te encuentras en el fragment No. 2", Toast.LENGTH_SHORT).show();
            }
        });
    }
}