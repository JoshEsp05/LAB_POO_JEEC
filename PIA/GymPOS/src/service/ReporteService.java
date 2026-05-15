package service;

import model.Cliente;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReporteService {

    public void generarReporteClientes(List<Cliente> clientes) {

        try (FileWriter writer = new FileWriter("dist/reporte_clientes.txt")) {

            writer.write("=== REPORTE DE CLIENTES ===\n\n");

            for (Cliente c : clientes) {
                writer.write("ID: " + c.getId() + "\n");
                writer.write("Nombre: " + c.getNombre() + "\n");
                writer.write("Email: " + c.getEmail() + "\n");
                writer.write("------------------------\n");
            }

            System.out.println("Reporte generado correctamente");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
