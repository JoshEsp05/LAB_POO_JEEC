package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.*;
import service.*;

public class MembresiaController {

    @FXML private ComboBox<Cliente> comboClientes;
    @FXML private ComboBox<Plan> comboPlanes;

    @FXML private TableView<Membresia> tablaMembresias;
    @FXML private TableColumn<Membresia, String> colCliente;
    @FXML private TableColumn<Membresia, String> colPlan;
    @FXML private TableColumn<Membresia, String> colEstado;

    private ClienteService clienteService = new ClienteService();
    private MembresiaService membresiaService = new MembresiaService();
    private PagoService pagoService = new PagoService();

    @FXML
    public void initialize() {

        tablaMembresias.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);

        tablaMembresias.getItems().setAll(membresiaService.obtenerMembresias());
        // columnas
        colCliente.setCellValueFactory(cell ->
            new javafx.beans.property.SimpleStringProperty(
                cell.getValue().getCliente().getNombre()
            )
        );

        colPlan.setCellValueFactory(cell ->
            new javafx.beans.property.SimpleStringProperty(
                cell.getValue().getPlan().getNombre()
            )
        );

        colEstado.setCellValueFactory(cell ->
            new javafx.beans.property.SimpleStringProperty(
                cell.getValue().estaActiva() ? "Activa" : "Vencida"
            )
        );


        colCliente.setStyle("-fx-alignment: CENTER;");
        colPlan.setStyle("-fx-alignment: CENTER;");
        colEstado.setStyle("-fx-alignment: CENTER;");

        colEstado.setCellFactory(column -> new TableCell<Membresia, String>() {

            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                    setStyle("");
                } else {

                    setText(item);

                    // 🔥 centrar texto
                    setAlignment(javafx.geometry.Pos.CENTER);

                    if (item.equals("Activa")) {
                        setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
                    } else {
                        setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
                    }
                }
            }
        });

        // cargar datos
        comboClientes.getItems().addAll(clienteService.obtenerClientes());

        comboPlanes.getItems().addAll(
            new Plan("Mensual", 500, 30),
            new Plan("Trimestral", 1200, 90),
            new Plan("Anual", 4000, 365)
        );
    }

    @FXML
    private void asignarMembresia() {

    Cliente cliente = comboClientes.getValue();
    Plan plan = comboPlanes.getValue();

    if (cliente == null || plan == null) {
        mostrarAlerta("Error", "Selecciona cliente y plan");
        return;
    }

    for (Membresia m : membresiaService.obtenerMembresias()) {
        if (m.getCliente().equals(cliente) && m.estaActiva()) {
            mostrarAlerta("Error", "El cliente ya tiene membresía activa");
            return;
        }
    }

    boolean pagoExitoso = pagoService.procesarPago(cliente, plan.getPrecio());

    if (pagoExitoso) {

        Membresia nueva = new Membresia(cliente, plan);

        membresiaService.agregarMembresia(nueva);

        tablaMembresias.getItems().add(nueva);

        mostrarInfo(
            "Pago exitoso",
            "Membresía activada.\nPuntos acumulados: " + cliente.getPuntos()
        );
    }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void mostrarInfo(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}