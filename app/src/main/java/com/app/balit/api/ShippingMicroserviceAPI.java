package com.app.balit.api;

import com.app.balit.models.Linea;
import com.app.balit.models.PackInfoParada;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ShippingMicroserviceAPI {
    @GET("/lineas")
    Call<List<Linea>> getLineas();

    @GET("/paradas/linea/{id}")
    Call<PackInfoParada> getParadas(@Path("id") String id);
}
