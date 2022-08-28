package com.luis.apprecyclerclickfragmentraslado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MAInformacionAdicional extends AppCompatActivity {
    private TextView textView;
    private ImageView imageView;
    private Fragment fragmentDetalle, fragmentEspecificaciones;
    private FragmentTransaction transaction;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainformacion_adicional);

        textView = findViewById(R.id.txtNombreInfoAdicional);
        imageView = findViewById(R.id.imgNombreInfoAdicional);
        tabLayout = findViewById(R.id.tlId);
        //A
        fragmentDetalle = new FragmentDetalle();
        fragmentEspecificaciones = new FragmentEspecificaciones();
        tabLayout.addTab(tabLayout.newTab().setText("Detalles"));
        tabLayout.addTab(tabLayout.newTab().setText("Especificaciones"));

        getSupportFragmentManager().beginTransaction().add(R.id.flContenedor,fragmentDetalle).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.flContenedor,fragmentEspecificaciones).hide(fragmentEspecificaciones).commit();

        this.getData();
        this.obtenerInformacionAdicional();
        this.navegacionTabLayout();
    }
    //B
    private void navegacionTabLayout(){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                transaction = getSupportFragmentManager().beginTransaction();
                switch (tab.getPosition()){
                    case 0:
                        if(fragmentDetalle.isAdded()) {
                            transaction.hide(fragmentEspecificaciones).show(fragmentDetalle);
                        }else{
                            transaction.hide(fragmentEspecificaciones).add(R.id.flContenedor,fragmentDetalle).addToBackStack(null);
                        }
                        break;
                    case 1:
                        if(fragmentEspecificaciones.isAdded()) {
                            transaction.hide(fragmentDetalle).show(fragmentEspecificaciones);
                        }else{
                            transaction.hide(fragmentDetalle).add(R.id.flContenedor,fragmentEspecificaciones).addToBackStack(null);
                        }
                        break;
                }
                transaction.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void getData() { //Recibe la información principal
        Bundle bundle = getIntent().getExtras();
        int nombreD = bundle.getInt("nombreD");
        int imgD = bundle.getInt("imgD");

        textView.setText(nombreD);
        imageView.setImageResource(imgD);
    }
    //Recibe infor
    private void obtenerInformacionAdicional(){
        Bundle bundle = getIntent().getExtras();
        int detallesD = bundle.getInt("detalleD");
        int especificacionesD = bundle.getInt("especificacionesD");
        this.trasladarInfoFragmentDetalle(detallesD);
        this.trasladarInfoFragmentEspecificaciones(especificacionesD);

    }
    private void trasladarInfoFragmentDetalle(int detalleD){
        Bundle bundle = new Bundle();
        bundle.putInt("detalleDF", detalleD);
        fragmentDetalle.setArguments(bundle);
    }
    private void trasladarInfoFragmentEspecificaciones(int especificacionesD){
        Bundle bundle = new Bundle();
        bundle.putInt("especificacionesDF", especificacionesD);
        fragmentEspecificaciones.setArguments(bundle);
    }

}