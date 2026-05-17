package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import model.Equipo;
import service.InventarioService;

public class InventarioController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtCantidad;

    @FXML private ComboBox<String> comboEstado;

    @FXML private TableView<Equipo> tablaEquipos;

    @FXML private TableColumn<Equipo, String> colNombre;
    @FXML private TableColumn<Equipo, Integer> colCantidad;
    @FXML private TableColumn<Equipo, String> colEstado;

    private InventarioService service = new InventarioService();

    @FXML
    public void initialize() {
        
        tablaEquipos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);

        colNombre.setCellValueFactory(
            new PropertyValueFactory<>("nombre")
        );

        colCantidad.setCellValueFactory(
            new PropertyValueFactory<>("cantidad")
        );

        colEstado.setCellValueFactory(
            new PropertyValueFactory<>("estado")
        );

        colEstado.setCellFactory(column -> {
    
            return new TableCell<>() {

                @Override
                protected void updateItem(String estado, boolean empty) {

                    super.updateItem(estado, empty);

                    if (empty || estado == null) {

                        setText(null);
                        setStyle("");

                    } else {

                        setText(estado);

                        if (estado.equals("Disponible")) {

                            setStyle(
                                "-fx-text-fill: green;" +
                                "-fx-font-weight: bold;" +
                                "-fx-alignment: CENTER;"
                            );

                        } else if (estado.equals("Mantenimiento")) {

                            setStyle(
                                "-fx-text-fill: orange;" +
                                "-fx-font-weight: bold;" +
                                "-fx-alignment: CENTER;"
                            );

                        } else {

                            setStyle(
                                "-fx-text-fill: red;" +
                                "-fx-font-weight: bold;" +
                                "-fx-alignment: CENTER;"
                            );
                        }
                    }
                }
            };
        });

        // centrar columnas
        colNombre.setStyle("-fx-alignment: CENTER;");
        colCantidad.setStyle("-fx-alignment: CENTER;");
        colEstado.setStyle("-fx-alignment: CENTER;");

        // estados
        comboEstado.getItems().addAll(
            "Disponible",
            "Mantenimiento",
            "Fuera de servicio"
        );

        tablaEquipos.getItems().setAll(
            service.obtenerEquipos()
        );

        tablaEquipos.getSelectionModel().selectedItemProperty().addListener(
            (obs, oldSel, newSel) -> {

                if (newSel != null) {

                    txtNombre.setText(newSel.getNombre());

                    txtCantidad.setText(
                        String.valueOf(newSel.getCantidad())
                    );

                    comboEstado.setValue(newSel.getEstado());
                }
            }
        );

    }

    @FXML
    private void agregarEquipo() {

        String nombre = txtNombre.getText();
        String cantidadTexto = txtCantidad.getText();
        String estado = comboEstado.getValue();

        if (nombre.isEmpty()
                || cantidadTexto.isEmpty()
                || estado == null) {

            mostrarError("Completa todos los campos");
            return;
        }

        int cantidad;

        try {
            cantidad = Integer.parseInt(cantidadTexto);
        } catch (Exception e) {
            mostrarError("Cantidad inválida");
            return;
        }

        Equipo equipo = new Equipo(
            nombre,
            cantidad,
            estado
        );

        service.agregarEquipo(equipo);

        tablaEquipos.getItems().add(equipo);

        limpiarCampos();
    }


    @FXML
    private void actualizarEquipo() {

        Equipo seleccionado =
            tablaEquipos.getSelectionModel().getSelectedItem();

        if (seleccionado == null) {

            mostrarError("Selecciona un equipo");

            return;
        }

        String nombre = txtNombre.getText();

        String cantidadTexto = txtCantidad.getText();

        String estado = comboEstado.getValue();

        if (nombre.isEmpty()
                || cantidadTexto.isEmpty()
                || estado == null) {

            mostrarError("Completa todos los campos");

            return;
        }

        int cantidad;

        try {

            cantidad = Integer.parseInt(cantidadTexto);

        } catch (Exception e) {

            mostrarError("Cantidad inválida");

            return;
        }

        seleccionado.setNombre(nombre);

        seleccionado.setCantidad(cantidad);

        seleccionado.setEstado(estado);

        tablaEquipos.refresh();

        service.guardar();

        limpiarCampos();

        tablaEquipos.getSelectionModel().clearSelection();
    }

    @FXML
    private void eliminarEquipo() {

        Equipo seleccionado =
            tablaEquipos.getSelectionModel().getSelectedItem();

        if (seleccionado == null) {
            mostrarError("Selecciona un equipo");
            return;
        }

        service.eliminarEquipo(seleccionado);

        tablaEquipos.getItems().remove(seleccionado);

        limpiarCampos();
    }

    private void limpiarCampos() {

        txtNombre.clear();
        txtCantidad.clear();

        comboEstado.setValue(null);
    }

    private void mostrarError(String mensaje) {

        Alert alert =
            new Alert(Alert.AlertType.ERROR);

        alert.setContentText(mensaje);

        alert.showAndWait();
    }
}