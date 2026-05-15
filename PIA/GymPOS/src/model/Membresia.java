package model;

import java.time.LocalDate;
import java.io.Serializable;

public class Membresia implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Cliente cliente;
    private Plan plan;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Membresia(Cliente cliente, Plan plan) {
        this.cliente = cliente;
        this.plan = plan;
        this.fechaInicio = LocalDate.now();
        this.fechaFin = fechaInicio.plusDays(plan.getDuracionDias());
    }

    public boolean estaActiva() {
        return LocalDate.now().isBefore(fechaFin);
    }

    public Cliente getCliente() { return cliente; }
    public Plan getPlan() { return plan; }
    public LocalDate getFechaFin() { return fechaFin; }
}
