package es.Partidos;

import es.Partidos.logica.Logica;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.File;

public class Launcher extends Application {




    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/MainWindow.fxml"));
        stage.setTitle("Pantalla Principal");
        stage.setOnHidden(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                Logica.getINSTANCE().guardarFichero(new File("listaPartidos.txt"));
            }
        });
        stage.setScene(new Scene( root,750,750));
        stage.show();
    }


    public static void main(String[] args){
        launch(args);
    }
}
