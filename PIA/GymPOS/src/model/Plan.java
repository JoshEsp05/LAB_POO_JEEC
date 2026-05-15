package model;

import java.io.Serializable;

public class Plan implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombre;
    private double precio;
    private int duracionDias;

    public Plan(String nombre, double precio, int duracionDias) {
        this.nombre = nombre;
        this.precio = precio;
        this.duracionDias = duracionDias;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getDuracionDias() {
        return duracionDias;
    }

    @Override
    public String toString() {
        return nombre + " ($" + precio + ")";
    }
}