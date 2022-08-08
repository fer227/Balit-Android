package com.app.balit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.app.balit.adapters.PageAdapter;
import com.google.android.material.tabs.TabLayout;

public class ParadaDetail extends AppCompatActivity {
    TabLayout tabLayout;
    public static ViewPager2 viewPager2;
    String numeroParada;
    String nombreParada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parada_detail);

        int numero = getIntent().getExtras().getInt("numero");
        numeroParada = Integer.toString(numero);
        nombreParada = getIntent().getExtras().getString("nombreParada");

        tabLayout = findViewById(R.id.tab_layout);
        viewPager2 = findViewById(R.id.viewpager);
        viewPager2.setAdapter(new PageAdapter(getSupportFragmentManager(), getLifecycle()));

        tabLayout.addTab(tabLayout.newTab().setText("Tiempos de espera").setIcon(R.drawable.tiempo) );
        tabLayout.addTab(tabLayout.newTab().setText("Puntos de interés").setIcon(R.drawable.location));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
    }

    public String getNumeroParada() {
        return numeroParada;
    }

    public String getNombreParada() {
        return nombreParada;
    }
}