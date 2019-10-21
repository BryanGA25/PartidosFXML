package es.Partidos.view;

import es.Partidos.logica.Logica;
import es.Partidos.model.Partidos;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    public TextField filtrarTexto;


    @FXML
    private MenuItem menuAlta;

    @FXML
    private TableView<Partidos> tablaPartidos;

    @FXML
    void altaPartido(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("DialogoPartido.fxml"));
            Stage stage =new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Pantalla Principal");
            stage.setScene(new Scene( root,650,450));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @FXML
    void  modificarPartido(ActionEvent event){
        try {
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("DialogoPartido.fxml"));
            Parent root = fxmlLoader.load();
            DialogoPartidoControlador controlador= fxmlLoader.getController();
            Partidos partidoMo=tablaPartidos.getSelectionModel().getSelectedItem();
            controlador.setPartidoModificado(partidoMo);
            Stage stage =new Stage();
            stage.setTitle("Pantalla Principal");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene( root,650,450));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

   @Override
   public void initialize(URL url, ResourceBundle resourceBundle) {
      tablaPartidos.setItems( Logica.getINSTANCE().getListaPartidos());

        //siempre que se haga un cambio en el texto de filtrar texto nos notificara
      filtrarTexto.textProperty().addListener(new ChangeListener<String>() {
          @Override
          public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {


          }
      });


   }
}
