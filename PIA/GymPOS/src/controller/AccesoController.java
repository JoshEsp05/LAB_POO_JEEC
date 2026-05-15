package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Cliente;
import service.*;

public class AccesoController {

    @FXML private ComboBox<Cliente> comboClientes;

    private ClienteService clienteService = new ClienteService();
    private AccesoService accesoService = new AccesoService();

    @FXML
    public void initialize() {
        comboClientes.getItems().addAll(clienteService.obtenerClientes());
    }

    @FXML
    private void registrarEntrada() {

        Cliente cliente = comboClientes.getValue();

        if (cliente == null) {
            mostrarAlerta("Error", "Selecciona un cliente");
            return;
        }

        boolean permitido = accesoService.registrarEntrada(cliente);

        if (permitido) {
            mostrarInfo("Acceso permitido", "Bienvenido " + cliente.getNombre());
        } else {
            mostrarAlerta("Acceso denegado", "Membresía vencida o inexistente");
        }
    }

    private void mostrarAlerta(String t, String m) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(t);
        alert.setContentText(m);
        alert.showAndWait();
    }

    private void mostrarInfo(String t, String m) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(t);
        alert.setContentText(m);
        alert.showAndWait();
    }
}