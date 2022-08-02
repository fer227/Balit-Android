package com.app.balit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.app.balit.adapters.ListAdapterLineas;
import com.app.balit.api.ShippingMicroserviceService;
import com.app.balit.models.Linea;
import com.app.balit.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    static ListAdapterLineas listAdapterLineas;
    ArrayList<Linea> lineas = new ArrayList<Linea>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ShippingMicroserviceService.getInstance().getLineas().enqueue(new Callback<List<Linea>>() {
            @Override
            public void onResponse(Call<List<Linea>> call, Response<List<Linea>> response) {
                lineas.clear();
                lineas.addAll(response.body());
                listAdapterLineas.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Linea>> call, Throwable t) {
                Utils.enviarToast("Error al intentar recibir las líneas", getApplicationContext());
            }
        });

        listAdapterLineas = new ListAdapterLineas(lineas, this);
        RecyclerView recyclerView = findViewById(R.id.lista_lineas);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapterLineas);
    }
}