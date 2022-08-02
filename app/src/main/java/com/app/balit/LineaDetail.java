package com.app.balit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class LineaDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linea_detail);

        String nombreLinea = getIntent().getExtras().getString("nombre");

        TextView tituloLinea = findViewById(R.id.titulo_linea);

        tituloLinea.setText(nombreLinea);
    }
}