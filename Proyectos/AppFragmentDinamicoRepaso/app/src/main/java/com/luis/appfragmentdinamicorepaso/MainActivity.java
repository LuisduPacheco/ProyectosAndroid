package com.luis.appfragmentdinamicorepaso;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout; //1
    private Fragment fragment1, fragment2, fragment3;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tlId); //2
        tabLayout.addTab(tabLayout.newTab().setText("Fragmento 1"));//7
        tabLayout.addTab(tabLayout.newTab().setText("Fragmento 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Fragmento 3"));
        fragment1 = new FragmentUno();
        fragment2 = new FragmentDos();
        fragment3 = new FragmentTres();

        getSupportFragmentManager().beginTransaction().add(R.id.frlContenedor, fragment1).commit();//3
        getSupportFragmentManager().beginTransaction().add(R.id.frlContenedor, fragment2).hide(fragment2).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frlContenedor, fragment3).hide(fragment3).commit();
        accionTablayaout();
    }

    private void accionTablayaout(){  //4
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override
            public void onTabSelected(TabLayout.Tab tab) { //5
                transaction = getSupportFragmentManager().beginTransaction();
            //6
                switch (tab.getPosition()){
                    case 0:
                        if(fragment1.isAdded()){ //8
                            transaction.hide(fragment2).hide(fragment3).show(fragment1);
                        }
                        else{
                            transaction.hide(fragment2).hide(fragment3).add(R.id.frlContenedor,fragment1).addToBackStack(null);
                        }
                        break;
                    case 1:
                        if(fragment2.isAdded()){
                            transaction.hide(fragment1).hide(fragment3).show(fragment2);
                        }
                        else{
                            transaction.hide(fragment1).hide(fragment3).add(R.id.frlContenedor,fragment2).addToBackStack(null);
                        }
                        break;
                    case 2:
                        if(fragment3.isAdded()){
                            transaction.hide(fragment2).hide(fragment1).show(fragment3);
                        }
                        else{
                            transaction.hide(fragment2).hide(fragment1).add(R.id.frlContenedor, fragment3).addToBackStack(null);
                        }
                        break;
                }//Fin del Switch
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