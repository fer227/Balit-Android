package com.app.balit.models;

import java.util.List;

public class Linea {
    @SerializedName("_id")
    @Expose
    private String id;

    @SerializedName("nombre")
    @Expose
    private String nombre;

    @SerializedName("horaSalida")
    @Expose
    private String horaSalida;

    @SerializedName("horaCierre")
    @Expose
    private String horaCierre;

    @SerializedName("paradas")
    @Expose
    private List<ParadaOrdenPair> paradas;

    public Linea(String id, String nombre, String horaSalida, String horaCierre, List<ParadaOrdenPair> paradas) {
        this.id = id;
        this.nombre = nombre;
        this.horaSalida = horaSalida;
        this.horaCierre = horaCierre;
        this.paradas = paradas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(String horaCierre) {
        this.horaCierre = horaCierre;
    }

    public List<ParadaOrdenPair> getParadas() {
        return paradas;
    }

    public void setParadas(List<ParadaOrdenPair> paradas) {
        this.paradas = paradas;
    }

    @Override
    public String toString() {
        return "Linea{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", horaSalida='" + horaSalida + '\'' +
                ", horaCierre='" + horaCierre + '\'' +
                ", paradas=" + paradas +
                '}';
    }
}
