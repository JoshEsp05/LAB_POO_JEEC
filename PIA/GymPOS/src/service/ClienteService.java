package service;

import model.Cliente;
import util.Serializador;

import java.util.ArrayList;
import java.util.List;

public class ClienteService {

    private List<Cliente> clientes;
    private final String ARCHIVO = "dist/clientes.dat";

    public ClienteService() {
        Object data = Serializador.cargar(ARCHIVO);

        if (data != null) {
            clientes = (List<Cliente>) data;
        } else {
            clientes = new ArrayList<>();
        }
    }

    public void agregarCliente(Cliente c) {
        clientes.add(c);
        guardar();
    }

    public void eliminarCliente(Cliente c) {
        clientes.remove(c);
        guardar();
    }

    public void guardarCambios() {
        guardar();
    }

    public List<Cliente> obtenerClientes() {
        return clientes;
    }

    private void guardar() {
        Serializador.guardar(ARCHIVO, clientes);
    }

    public String generarNuevoId() {

        int siguiente = clientes.size() + 1;

        return String.format("C%03d", siguiente);
    }

}
