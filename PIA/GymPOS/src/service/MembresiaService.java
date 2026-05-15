package service;

import model.Membresia;
import util.Serializador;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Platform;
import javafx.scene.control.Alert;

public class MembresiaService {

    private List<Membresia> membresias;
    private final String ARCHIVO = "dist/membresias.dat";
    private List<Membresia> notificados = new ArrayList<>();

    public MembresiaService() {
        Object data = Serializador.cargar(ARCHIVO);

        if (data instanceof List<?>) {
            membresias = (List<Membresia>) data;
        } else {
            membresias = new ArrayList<>();
        }
    }

    public void verificarVencimientos() {

        for (Membresia m : membresias) {

            if (!m.estaActiva() && !notificados.contains(m)) {

                notificados.add(m);

                Platform.runLater(() -> {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Membresía vencida");
                    alert.setContentText(
                        "El cliente " + m.getCliente().getNombre() + " tiene su membresía vencida"
                    );
                    alert.show();
                });
            }
        }
    }

    public void agregarMembresia(Membresia m) {
        membresias.add(m);
        guardar();
    }

    public List<Membresia> obtenerMembresias() {
        return membresias;
    }

    private void guardar() {
        Serializador.guardar(ARCHIVO, membresias);
    }
}
