package com.app.balit.api;

import com.app.balit.models.Linea;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ShippingMicroserviceAPI {
    @GET("/lineas")
    Call<List<Linea>> getLineas();
}
