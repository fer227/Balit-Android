package com.app.balit.api;

import com.app.balit.models.Linea;
import com.app.balit.models.POI;
import com.app.balit.models.PackInfoParada;
import com.app.balit.models.Parada;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface ShippingMicroserviceAPI {
    @GET("/lineas")
    Call<List<Linea>> getLineas();

    @GET("/paradas/linea/{id}")
    Call<PackInfoParada> getParadas(@Path("id") String id);

    @GET("/paradas/{id}")
    Call<Parada> getParada(@Path("id") String id);

    @GET("/lineas/{id}")
    Call<Linea> getLinea(@Path("id") String id);

    @GET("/puntosdeinteres/parada/{id}")
    Call<List<POI>> getPOISByParada(@Path("id") String id);

    @GET("/puntosdeinteres/linea/paradas")
    Call<List<POI>> getPOISByLinea(@QueryMap Map<String, String> paradas);
}
