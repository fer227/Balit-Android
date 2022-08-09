package com.app.balit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.app.balit.adapters.ListAdapterLineas;
import com.app.balit.adapters.ListAdapterPois;
import com.app.balit.api.ShippingMicroserviceService;
import com.app.balit.models.POI;
import com.app.balit.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class POIByLinea extends AppCompatActivity {
    static ListAdapterPois listAdapterPois;
    ArrayList<POI> pois = new ArrayList<>();
    String query;
    String nombreLinea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poiby_linea);

        query = getIntent().getExtras().getString("query");
        System.out.println(query);
        String[] paradas = query.split("-");
        Map<String, String> queryParams = new HashMap<String, String>();
        for(String s: paradas){
            queryParams.put("id", s);
            System.out.println(s);
        }

        System.out.println(queryParams);

        nombreLinea = getIntent().getExtras().getString("nombre");
        ImageView imageLinea = findViewById(R.id.image_title_poisbylinea);
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

        ShippingMicroserviceService.getInstance().getPOISByLinea(queryParams).enqueue(new Callback<List<POI>>() {
            @Override
            public void onResponse(Call<List<POI>> call, Response<List<POI>> response) {
                pois.clear();
                pois.addAll(response.body());
                listAdapterPois.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<POI>> call, Throwable t) {
                Utils.enviarToast("Error al intentar recibir las paradas de la línea", getApplicationContext());
            }
        });

        listAdapterPois = new ListAdapterPois(pois, this);
        RecyclerView recyclerView = findViewById(R.id.lista_pois_bylinea);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapterPois);
    }
}