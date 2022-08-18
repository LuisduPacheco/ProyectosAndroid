package com.luis.cuentosfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MACuentos extends AppCompatActivity {
    private TabLayout tabLayout; //1
    private Fragment fragment1,fragment2,fragment3,fragment4,fragment5;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macuentos);

        tabLayout = findViewById(R.id.tlId);//2
        tabLayout.addTab(tabLayout.newTab().setText("Uno"));
        tabLayout.addTab(tabLayout.newTab().setText("Dos"));
        tabLayout.addTab(tabLayout.newTab().setText("Tres"));
        tabLayout.addTab(tabLayout.newTab().setText("Cuatro"));
        tabLayout.addTab(tabLayout.newTab().setText("Cinco"));
        fragment1 = new FCuentoUno();
        fragment2 = new FCuentoDos();
        fragment3 = new FCuentoTres();
        fragment4 = new FCuentoCuatro();
        fragment5 = new FCuentoCinco();

        getSupportFragmentManager().beginTransaction().add(R.id.frlContenedor,fragment1).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frlContenedor,fragment2).hide(fragment2).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frlContenedor,fragment3).hide(fragment3).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frlContenedor,fragment4).hide(fragment4).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frlContenedor,fragment5).hide(fragment5).commit();
        accionTablayout();
    }

    private void accionTablayout() { //4
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) { //5
                transaction = getSupportFragmentManager().beginTransaction();
                //6
                switch (tab.getPosition()){
                    case 0:
                        if(fragment1.isAdded()){
                            transaction.hide(fragment2).hide(fragment3).hide(fragment4).hide(fragment5).show(fragment1);
                        }else{
                            transaction.hide(fragment2).hide(fragment3).hide(fragment4).hide(fragment5).add(R.id.frlContenedor, fragment1).addToBackStack(null);
                        }
                        break;
                    case 1:
                        if(fragment2.isAdded()){
                            transaction.hide(fragment1).hide(fragment3).hide(fragment4).hide(fragment5).show(fragment2);
                        }else{
                            transaction.hide(fragment1).hide(fragment3).hide(fragment4).hide(fragment5).add(R.id.frlContenedor, fragment2).addToBackStack(null);
                        }
                        break;
                    case 2:
                        if(fragment3.isAdded()){
                            transaction.hide(fragment2).hide(fragment1).hide(fragment4).hide(fragment5).show(fragment3);
                        }else{
                            transaction.hide(fragment2).hide(fragment1).hide(fragment4).hide(fragment5).add(R.id.frlContenedor, fragment3).addToBackStack(null);
                        }
                        break;
                    case 3:
                        if(fragment4.isAdded()){
                            transaction.hide(fragment2).hide(fragment3).hide(fragment1).hide(fragment5).show(fragment4);
                        }else{
                            transaction.hide(fragment2).hide(fragment3).hide(fragment1).hide(fragment5).add(R.id.frlContenedor, fragment4).addToBackStack(null);
                        }
                        break;
                    case 4:
                        if(fragment5.isAdded()){
                            transaction.hide(fragment2).hide(fragment3).hide(fragment4).hide(fragment1).show(fragment5);
                        }else{
                            transaction.hide(fragment2).hide(fragment3).hide(fragment4).hide(fragment1).add(R.id.frlContenedor, fragment5).addToBackStack(null);
                        }
                        break;
                }//Fin del switch
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


}