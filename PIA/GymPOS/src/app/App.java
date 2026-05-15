package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import service.MembresiaService;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(
            getClass().getResource("/view/dashboard.fxml")
        );

        Scene scene = new Scene(loader.load());
        stage.setTitle("GymPOS");
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();

        stage.setOnShown(e -> stage.centerOnScreen());

        final double[] offset = new double[2];

        scene.setOnMousePressed(e -> {
            offset[0] = e.getSceneX();
            offset[1] = e.getSceneY();
        });

        scene.setOnMouseDragged(e -> {
            stage.setX(e.getScreenX() - offset[0]);
            stage.setY(e.getScreenY() - offset[1]);
        });
        scene.getStylesheets().add(
            getClass().getResource("/css/style.css").toExternalForm()
        );

        iniciarVerificacionAutomatica();
    }

    public static void main(String[] args) {
        launch();
    }

    private void iniciarVerificacionAutomatica() {

    MembresiaService membresiaService = new MembresiaService();

    new Thread(() -> {
        while (true) {

            membresiaService.verificarVencimientos();

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }).start();
    }
}

