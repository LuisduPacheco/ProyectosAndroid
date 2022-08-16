package com.luis.appfragmentestaticos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentB extends Fragment {

    public FragmentB() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // 1.
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        // 4.
        this.estructuraFragment(view);

        return view;
    }
    //2.
    private void estructuraFragment(View view){
        Button button;

        button = view.findViewById(R.id.btnPresionarFrgB);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = getActivity().findViewById(R.id.txtMostrarFrgA);
                textView.setText("Lluvia en la Ciudad de Guatemala");
            }
        });
    }

}