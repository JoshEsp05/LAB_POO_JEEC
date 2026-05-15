package service;

import model.Acceso;
import model.Cliente;
import model.Membresia;

import java.util.ArrayList;
import java.util.List;

public class AccesoService {

    private List<Acceso> accesos = new ArrayList<>();
    private MembresiaService membresiaService = new MembresiaService();

    public boolean registrarEntrada(Cliente cliente) {

        for (Membresia m : membresiaService.obtenerMembresias()) {

            if (m.getCliente().getId().equals(cliente.getId())
                    && m.estaActiva()) {

                accesos.add(new Acceso(cliente));
                return true;
            }
        }

        return false;
    }

    public List<Acceso> obtenerAccesos() {
        return accesos;
    }
}