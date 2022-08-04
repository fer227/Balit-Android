package com.app.balit.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Conexion {
    @SerializedName("nombreLinea")
    @Expose
    private String nombreLinea;

    public String getNombreLinea() {
        return nombreLinea;
    }

    public void setNombreLinea(String nombreLinea) {
        this.nombreLinea = nombreLinea;
    }

    public Conexion(String nombreLinea) {
        this.nombreLinea = nombreLinea;
    }

    @Override
    public String toString() {
        return "Conexion{" +
                "nombreLinea='" + nombreLinea + '\'' +
                '}';
    }
}
