package controller;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class CalendarioController {

    @FXML
    private GridPane gridCalendario;

    private final String[] dias = {
        "Lunes",
        "Martes",
        "Miércoles",
        "Jueves",
        "Viernes",
        "Sábado",
        "Domingo"
    };

    @FXML
    public void initialize() {

        // títulos
        for (int i = 0; i < dias.length; i++) {

            Label lblDia = new Label(dias[i]);

            lblDia.setStyle(
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-color: #2c3e50;" +
                "-fx-text-fill: white;" +
                "-fx-padding: 10;"
            );

            lblDia.setMaxWidth(Double.MAX_VALUE);

            gridCalendario.add(lblDia, i, 0);
        }

        // ===== LUNES =====
        agregarClase(0, 1, "Yoga\n7:00 AM");
        agregarClase(0, 2, "Cardio HIT\n10:00 AM");
        agregarClase(0, 3, "Spinning\n6:00 PM");

        // ===== MARTES =====
        agregarClase(1, 1, "Crossfit\n8:00 AM");
        agregarClase(1, 2, "Box\n5:00 PM");
        agregarClase(1, 3, "Zumba\n7:00 PM");

        // ===== MIÉRCOLES =====
        agregarClase(2, 1, "Yoga\n7:00 AM");
        agregarClase(2, 2, "Pierna\n6:00 PM");
        agregarClase(2, 3, "Funcional\n8:00 PM");

        // ===== JUEVES =====
        agregarClase(3, 1, "Spinning\n9:00 AM");
        agregarClase(3, 2, "Crossfit\n6:00 PM");
        agregarClase(3, 3, "Box\n8:00 PM");

        // ===== VIERNES =====
        agregarClase(4, 1, "Cardio HIT\n7:00 AM");
        agregarClase(4, 2, "Mixto\n5:00 PM");
        agregarClase(4, 3, "Zumba\n7:30 PM");

        // ===== SÁBADO =====
        agregarClase(5, 1, "Pierna\n10:00 AM");
        agregarClase(5, 2, "Yoga\n12:00 PM");
        agregarClase(5, 3, "Funcional\n2:00 PM");

        // ===== DOMINGO =====
        agregarClase(6, 1, "Descanso");
    }

    private void agregarClase(int columna, int fila, String texto) {

        VBox box = new VBox();

        box.setAlignment(Pos.CENTER);

        box.setPrefSize(140, 100);

        String color = "#ecf0f1";

        // 🎨 colores por clase
        if (texto.contains("Yoga")) {
            color = "#a8e6cf";
        }
        else if (texto.contains("Crossfit")) {
            color = "#ff8b94";
        }
        else if (texto.contains("Spinning")) {
            color = "#ffd3b6";
        }
        else if (texto.contains("Zumba")) {
            color = "#f9c74f";
        }
        else if (texto.contains("Box")) {
            color = "#f94144";
        }
        else if (texto.contains("Cardio")) {
            color = "#90be6d";
        }
        else if (texto.contains("Pierna")) {
            color = "#577590";
        }
        else if (texto.contains("Funcional")) {
            color = "#43aa8b";
        }
        else if (texto.contains("Mixto")) {
            color = "#9d4edd";
        }
        else if (texto.contains("Descanso")) {
            color = "#adb5bd";
        }

        box.setStyle(
            "-fx-background-color: " + color + ";" +
            "-fx-border-color: #bdc3c7;" +
            "-fx-background-radius: 10;" +
            "-fx-border-radius: 10;"
        );

        Label lbl = new Label(texto);

        lbl.setStyle(
            "-fx-font-size: 14px;" +
            "-fx-font-weight: bold;"
        );

        box.getChildren().add(lbl);

        gridCalendario.add(box, columna, fila);
    }
}