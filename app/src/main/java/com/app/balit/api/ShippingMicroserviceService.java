package com.app.balit.api;

import com.app.balit.utils.Utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShippingMicroserviceService {
    private static ShippingMicroserviceAPI instance = null;

    public static ShippingMicroserviceAPI getInstance(){
        if(instance == null){
            instance = new Retrofit.Builder()
                    .baseUrl(Utils.getUrlBase())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ShippingMicroserviceAPI.class);
        }
        return instance;
    }
}
