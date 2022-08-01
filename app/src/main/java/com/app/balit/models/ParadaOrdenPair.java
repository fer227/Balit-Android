package com.app.balit.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ParadaOrdenPair {
    @SerializedName("numeroParada")
    @Expose
    private String numeroParada;

    @SerializedName("orden")
    @Expose
    private String orden;

    public String getNumeroParada() {
        return numeroParada;
    }

    public void setNumeroParada(String numeroParada) {
        this.numeroParada = numeroParada;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public ParadaOrdenPair(String numeroParada, String orden) {
        this.numeroParada = numeroParada;
        this.orden = orden;
    }

    @Override
    public String toString() {
        return "ParadaOrdenPair{" +
                "numeroParada='" + numeroParada + '\'' +
                ", orden='" + orden + '\'' +
                '}';
    }
}
