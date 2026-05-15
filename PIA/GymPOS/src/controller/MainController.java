package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Cliente;
import service.ClienteService;
import service.MembresiaService;
import service.ReporteService;

public class MainController {

    @FXML private TextField txtId;
    @FXML private TextField txtNombre;
    @FXML private TextField txtEmail;
    @FXML private Button btnAgregar;

    @FXML private TableView<Cliente> tablaClientes;
    @FXML private TableColumn<Cliente, String> colId;
    @FXML private TableColumn<Cliente, String> colNombre;
    @FXML private TableColumn<Cliente, String> colEmail;
    @FXML private TableColumn<Cliente, String> colMembresia;

    private ClienteService service = new ClienteService();
    private MembresiaService membresiaService = new MembresiaService();
    private ReporteService reporteService = new ReporteService();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        colId.setStyle("-fx-alignment: CENTER;");
        colNombre.setStyle("-fx-alignment: CENTER;");
        colEmail.setStyle("-fx-alignment: CENTER;");
        colMembresia.setStyle("-fx-alignment: CENTER;");

        colMembresia.setCellValueFactory(cell -> {

            Cliente cliente = cell.getValue();

            boolean activa = membresiaService.obtenerMembresias().stream()
                .anyMatch(m ->
                    m.getCliente().getId().equals(cliente.getId())
                    && m.estaActiva()
                );

            String estado = activa ? "Activa" : "Sin membresía";

            return new javafx.beans.property.SimpleStringProperty(estado);
        });

        colMembresia.setCellFactory(column -> new TableCell<Cliente, String>() {

            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                    setStyle("");
                } else {

                    setText(item);

                    setAlignment(javafx.geometry.Pos.CENTER);

                    if (item.equals("Activa")) {
                        setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
                    } else {
                        setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
                    }
                }
            }
        });



        tablaClientes.setOnMouseClicked(e -> cargarClienteSeleccionado());
        
        
        tablaClientes.getSelectionModel().selectedItemProperty().addListener(
            (obs, oldSel, newSel) -> {
                btnAgregar.setDisable(newSel != null);
            }
        );

        tablaClientes.getSelectionModel().selectedItemProperty().addListener(
        (obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                txtId.setText(newSelection.getId());
                txtNombre.setText(newSelection.getNombre());
                txtEmail.setText(newSelection.getEmail());
            }
        }
        );

        tablaClientes.getItems().addAll(service.obtenerClientes());
        tablaClientes.getSelectionModel().clearSelection();
        txtId.setText(service.generarNuevoId());


        txtId.setEditable(false);
    }

    @FXML
    private void agregarCliente() {

        String id = txtId.getText();
        String nombre = txtNombre.getText();
        String email = txtEmail.getText();

        if (id.isEmpty() || nombre.isEmpty() || email.isEmpty()) {
            mostrarAlerta("Error", "Todos los campos son obligatorios");
            return;
        }

        Cliente nuevo = new Cliente(id, nombre, email);

        service.agregarCliente(nuevo);
        tablaClientes.getItems().add(nuevo);

        limpiarCampos();
        txtId.setText(service.generarNuevoId());
    }

    @FXML
    private void eliminarCliente() {

        Cliente seleccionado = tablaClientes.getSelectionModel().getSelectedItem();

        if (seleccionado == null) {
            mostrarAlerta("Error", "Selecciona un cliente para eliminar");
            return;
        }

        service.eliminarCliente(seleccionado);
        tablaClientes.getItems().remove(seleccionado);

        tablaClientes.getSelectionModel().clearSelection();
        limpiarCampos();
    }

    @FXML
    private void actualizarCliente() {

        Cliente seleccionado = tablaClientes.getSelectionModel().getSelectedItem();

        if (seleccionado == null) {
            mostrarAlerta("Error", "Selecciona un cliente para actualizar");
            return;
        }

        String nombre = txtNombre.getText();
        String email = txtEmail.getText();


        seleccionado.setNombre(nombre);
        seleccionado.setEmail(email);

        tablaClientes.refresh();

        service.guardarCambios();

        tablaClientes.getSelectionModel().clearSelection();
        limpiarCampos();
    }

    private void cargarClienteSeleccionado() {
    Cliente seleccionado = tablaClientes.getSelectionModel().getSelectedItem();

    if (seleccionado != null) {
        txtId.setText(seleccionado.getId());
        txtNombre.setText(seleccionado.getNombre());
        txtEmail.setText(seleccionado.getEmail());
    }
    }

    @FXML
    private void generarReporte() {

        new Thread(() -> {
            System.out.println("Generando reporte...");

            reporteService.generarReporteClientes(service.obtenerClientes());

            System.out.println("Reporte listo");
        }).start();
    }


    private void limpiarCampos() {

        txtNombre.clear();

        txtEmail.clear();

        txtId.setText(service.generarNuevoId());
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}