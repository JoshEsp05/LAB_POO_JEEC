package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DashboardController {

    @FXML
    private StackPane contenedor;

    @FXML
    public void initialize() {
        cargarVista("/view/main.fxml"); // inicio con clientes
    }

    @FXML
    private void cargarClientes() {
        cargarVista("/view/main.fxml");
    }

    @FXML
    private void cargarMembresias() {
        cargarVista("/view/membresias.fxml");
    }

    @FXML
    private void cargarCalendario() {
        cargarVista("/view/calendario.fxml");
    }

    @FXML
    private void cargarAcceso() {
        cargarVista("/view/acceso.fxml");
    }

    @FXML
    private void cargarInventario() {
        cargarVista("/view/inventario.fxml");
    }

    @FXML
    private void cargarReportes() {
        // luego lo conectamos
        System.out.println("Reportes");
    }

    @FXML
    private void cerrar() {
        Stage stage = (Stage) contenedor.getScene().getWindow();
        stage.close();
    }

@FXML
private void minimizar() {
    Stage stage = (Stage) contenedor.getScene().getWindow();
    stage.setIconified(true);
}

@FXML
private void maximizar() {
    Stage stage = (Stage) contenedor.getScene().getWindow();
    stage.setMaximized(!stage.isMaximized());
}

    
    private void cargarVista(String ruta) {
        try {
            contenedor.getChildren().clear();
            contenedor.getChildren().add(
                FXMLLoader.load(getClass().getResource(ruta))
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}