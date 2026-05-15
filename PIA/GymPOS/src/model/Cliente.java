package model;

import java.io.Serializable;

public class Cliente implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String id;
    private String nombre;
    private String email;
    private int puntos;

    public int getPuntos() { return puntos; }
    public void setPuntos(int puntos) { this.puntos = puntos; }

    public Cliente(String id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.puntos = 0;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }

    public void setId(String id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return nombre;
    }

    
}
