package model;

import java.time.LocalDateTime;

public class Acceso {
    private Cliente cliente;
    private LocalDateTime fecha;

    public Acceso(Cliente cliente) {
        this.cliente = cliente;
        this.fecha = LocalDateTime.now();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }
}