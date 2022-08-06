package com.app.balit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.balit.adapters.ListAdapterParadas;
import com.app.balit.api.ShippingMicroserviceService;
import com.app.balit.models.PackInfoParada;
import com.app.balit.models.Parada;
import com.app.balit.models.ParadaOrdenPair;
import com.app.balit.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LineaDetail extends AppCompatActivity {
    static ListAdapterParadas listAdapterParadas;
    ArrayList<Parada> paradas = new ArrayList<Parada>();
    String nombreLinea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linea_detail);

        nombreLinea = getIntent().getExtras().getString("nombre");
        ImageView imageLinea = findViewById(R.id.image_detail_linea);
        switch (nombreLinea){
            case "N3":
                imageLinea.setBackground(getApplicationContext().getDrawable(R.drawable.n3));
                break;
            case "C4":
                imageLinea.setBackground(getApplicationContext().getDrawable(R.drawable.c4));
                break;
            case "5":
                imageLinea.setBackground(getApplicationContext().getDrawable(R.drawable.linea5));
                break;
        }

        ShippingMicroserviceService.getInstance().getParadas(nombreLinea).enqueue(new Callback<PackInfoParada>() {
            @Override
            public void onResponse(Call<PackInfoParada> call, Response<PackInfoParada> response) {
                paradas.clear();
                PackInfoParada packInfoParada = response.body();

                Map<Integer, Integer> paradaByOrdenMap = new HashMap<Integer, Integer>();
                for (ParadaOrdenPair pair: packInfoParada.getOrden()){
                    paradaByOrdenMap.put(pair.getOrden(), pair.getNumeroParada());
                }

                Map<Integer, Parada> paradaByNumeroMap = new HashMap<Integer, Parada>();
                for(Parada parada: packInfoParada.getInfoParadas()){
                    paradaByNumeroMap.put(parada.getNumero(), parada);
                }

                for(int i = 1; i <= paradaByOrdenMap.size(); i++){
                    paradas.add(paradaByNumeroMap.get(paradaByOrdenMap.get(i)));
                }
                listAdapterParadas.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<PackInfoParada> call, Throwable t) {
                Utils.enviarToast("Error al intentar recibir las paradas de la línea", getApplicationContext());
            }
        });

        listAdapterParadas = new ListAdapterParadas(paradas, this);
        RecyclerView recyclerView = findViewById(R.id.lista_paradas);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapterParadas);
    }
}