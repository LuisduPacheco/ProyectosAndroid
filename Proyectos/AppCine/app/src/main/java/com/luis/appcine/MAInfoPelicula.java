package com.luis.appcine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MAInfoPelicula extends AppCompatActivity {
    private TextView textView;
    private ImageView imageView;
    //Para el traslado de información a los Fragment
    //A
    private Fragment fragmentSinopsis, fragmentReparto, fragmentRecaudacion;
    private FragmentTransaction transaction;
    private TabLayout tabLayout;
    //Para el Botón Comprar
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainfo_pelicula);

        textView = findViewById(R.id.txtNombreDetalle);
        imageView = findViewById(R.id.imgDetalles);
        tabLayout = findViewById(R.id.tlId);
        //A-
        fragmentSinopsis = new FrgSinopsis();
        fragmentReparto = new FrgReparto();
        fragmentRecaudacion = new FrgPuntuacion();
        tabLayout.addTab(tabLayout.newTab().setText("Sinopsis"));
        tabLayout.addTab(tabLayout.newTab().setText("Reparto"));
        tabLayout.addTab(tabLayout.newTab().setText("Recaudación"));
        
        button = findViewById(R.id.btnComprar);

        getSupportFragmentManager().beginTransaction().add(R.id.flContenedor,fragmentSinopsis).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.flContenedor,fragmentReparto).hide(fragmentReparto).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.flContenedor,fragmentRecaudacion).hide(fragmentRecaudacion).commit();

        this.getDatos();
        this.obtenerInformacionAdicional();
        this.navegacionTabLayout();
        //Click en el Boton
        this.clickCompra();

    }

    private void clickCompra() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MAInfoPelicula.this, "Comprar...", Toast.LENGTH_SHORT).show();
                comprar();
            }
        });
    }

    private void getDatos() {
        Bundle bundle = getIntent().getExtras();
        String tituloD = bundle.getString("tituloD");
        int imgD = bundle.getInt("imagenD");

        textView.setText(tituloD);
        imageView.setImageResource(imgD);
    }
    //B para la navegación en los fragment
    private void navegacionTabLayout(){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                transaction = getSupportFragmentManager().beginTransaction();
                switch (tab.getPosition()){
                    case 0:
                        if(fragmentSinopsis.isAdded()){
                            transaction.hide(fragmentReparto).hide(fragmentRecaudacion).show(fragmentSinopsis);
                        }else{
                            transaction.hide(fragmentReparto).hide(fragmentRecaudacion).add(R.id.flContenedor,fragmentSinopsis).addToBackStack(null);
                        }
                        break;
                    case 1:
                        if(fragmentReparto.isAdded()){
                            transaction.hide(fragmentSinopsis).hide(fragmentRecaudacion).show(fragmentReparto);
                        }else{
                            transaction.hide(fragmentSinopsis).hide(fragmentRecaudacion).add(R.id.flContenedor,fragmentReparto).addToBackStack(null);
                        }
                        break;
                    case 2:
                        if(fragmentRecaudacion.isAdded()){
                            transaction.hide(fragmentReparto).hide(fragmentSinopsis).show(fragmentRecaudacion);
                        }else{
                            transaction.hide(fragmentReparto).hide(fragmentSinopsis).add(R.id.flContenedor,fragmentRecaudacion).addToBackStack(null);
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

    //D RECIBIENDO INFO PARA LOS FRAGMENT
    private void obtenerInformacionAdicional(){
        Bundle bundle = getIntent().getExtras();
        int sinop = bundle.getInt("sinop");
        int prot = bundle.getInt("prot");
        int rec = bundle.getInt("rec");
        this.trasladarInfoFrgSinopsis(sinop);
        this.trsladarInfoFrgRecauda(rec);
        this.trasladarInfoFrgReparto(prot);
    }

    private void trasladarInfoFrgSinopsis(int sinop){
        Bundle bundle = new Bundle();
        bundle.putInt("sinop",sinop);
        fragmentSinopsis.setArguments(bundle);
    }
    private void trasladarInfoFrgReparto(int prot){
        Bundle bundle = new Bundle();
        bundle.putInt("prot",prot);
        fragmentReparto.setArguments(bundle);
    }
    private void trsladarInfoFrgRecauda(int rec){
        Bundle bundle = new Bundle();
        bundle.putInt("rec",rec);
        fragmentRecaudacion.setArguments(bundle);
    }

    public void comprar(){
        Intent intent = new Intent(this, MABoletos.class);
        startActivity(intent);
    }

}