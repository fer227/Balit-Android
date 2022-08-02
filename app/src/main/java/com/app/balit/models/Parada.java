package com.app.balit.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Parada {
    @SerializedName("_id")
    @Expose
    private String id;

    @SerializedName("nombre")
    @Expose
    private String nombre;

    @SerializedName("numero")
    @Expose
    private int numero;

    @SerializedName("latitud")
    @Expose
    private double latitud;

    @SerializedName("longitud")
    @Expose
    private double longitud;

    @SerializedName("conexiones")
    @Expose
    private List<Conexion> conexiones;

    @SerializedName("puntosDeInteres")
    @Expose
    private List<String> puntosDeInteres;

    public Parada(String id, String nombre, int numero, double latitud, double longitud, List<Conexion> conexiones, List<String> puntosDeInteres) {
        this.id = id;
        this.nombre = nombre;
        this.numero = numero;
        this.latitud = latitud;
        this.longitud = longitud;
        this.conexiones = conexiones;
        this.puntosDeInteres = puntosDeInteres;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public List<Conexion> getConexiones() {
        return conexiones;
    }

    public void setConexiones(List<Conexion> conexiones) {
        this.conexiones = conexiones;
    }

    public List<String> getPuntosDeInteres() {
        return puntosDeInteres;
    }

    public void setPuntosDeInteres(List<String> puntosDeInteres) {
        this.puntosDeInteres = puntosDeInteres;
    }

    @Override
    public String toString() {
        return "Parada{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", numero=" + numero +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", conexiones=" + conexiones +
                ", puntosDeInteres=" + puntosDeInteres +
                '}';
    }
}
