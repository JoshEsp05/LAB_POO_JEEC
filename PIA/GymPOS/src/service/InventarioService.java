package service;

import model.Equipo;
import util.Serializador;

import java.util.ArrayList;
import java.util.List;

public class InventarioService {

    private List<Equipo> equipos;

    private final String ARCHIVO = "inventario.dat";

    public InventarioService() {

        Object data = Serializador.cargar(ARCHIVO);

        if (data instanceof List<?>) {
            equipos = (List<Equipo>) data;
        } else {
            equipos = new ArrayList<>();
        }
    }

    public void agregarEquipo(Equipo equipo) {

        equipos.add(equipo);

        guardar();
    }

    public List<Equipo> obtenerEquipos() {
        return equipos;
    }

    public void eliminarEquipo(Equipo equipo) {

        equipos.remove(equipo);

        guardar();
    }

    public void guardar() {
        Serializador.guardar(ARCHIVO, equipos);
    }
}