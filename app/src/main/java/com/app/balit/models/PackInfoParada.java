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

    public PackInfoParada(List<ParadaOrdenPair> orden, List<Parada> infoParadas) {
        this.orden = orden;
        this.infoParadas = infoParadas;
    }

    public List<ParadaOrdenPair> getOrden() {
        return orden;
    }

    public void setOrden(List<ParadaOrdenPair> orden) {
        this.orden = orden;
    }

    public List<Parada> getInfoParadas() {
        return infoParadas;
    }

    public void setInfoParadas(List<Parada> infoParadas) {
        this.infoParadas = infoParadas;
    }

    @Override
    public String toString() {
        return "PackInfoParada{" +
                "orden=" + orden +
                ", infoParadas=" + infoParadas +
                '}';
    }
}
