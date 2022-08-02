package com.app.balit.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PackInfoParada {
    @SerializedName("orden")
    @Expose
    private List<ParadaOrdenPair> orden;

    @SerializedName("infoParadas")
    @Expose
    private List<Parada> infoParadas;
}
