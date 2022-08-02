package com.app.balit.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ParadaOrdenPair {
    @SerializedName("numeroParada")
    @Expose
    private int numeroParada;

    @SerializedName("orden")
    @Expose
    private int orden;

    public int getNumeroParada() {
        return numeroParada;
    }

    public void setNumeroParada(int numeroParada) {
        this.numeroParada = numeroParada;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public ParadaOrdenPair(int numeroParada, int orden) {
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
