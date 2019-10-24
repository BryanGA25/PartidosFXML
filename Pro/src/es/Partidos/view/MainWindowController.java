package es.Partidos.view;

import es.Partidos.logica.Logica;
import es.Partidos.model.Partidos;
import es.Partidos.view.filters.filtrarTexto;
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

public class MainWindowController extends BaseController implements Initializable {

    private es.Partidos.view.filters.filtrarTexto filtrarTexto2;

    @FXML
   private TextField filtrarTexto;

    @FXML
    private MenuItem menuAlta;

    @FXML
    private TableView<Partidos> tablaPartidos;

    @FXML
    void altaPartido(ActionEvent event) {
        cargarDialogo("FormularioPartidos.fxml", 700, 500).abrirDialogo(true);
        filtrar();
    }
    @FXML
    void  modificarPartido(ActionEvent event){

        DialogoPartidoControlador controlador=(DialogoPartidoControlador)cargarDialogo("DialogoPartido.fxml",700,450);
        Partidos partido=tablaPartidos.getSelectionModel().getSelectedItem();
        controlador.setPartidoModificado(partido);
        controlador.abrirDialogo(true);
        filtrar();

    }

   @Override
   public void initialize(URL url, ResourceBundle resourceBundle) {
      tablaPartidos.setItems( Logica.getINSTANCE().getListaPartidos());
       filtrarTexto2= new filtrarTexto(Logica.getINSTANCE().getListaPartidos());
        //siempre que se haga un cambio en el texto de filtrar texto nos notificara
            filtrarTexto.textProperty().addListener(new ChangeListener<String>() {
          @Override
          public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                tablaPartidos.setItems(filtrarTexto2.filtrar(newValue));

          }
      });



   }
    public void filtrar()
    {
        tablaPartidos.setItems(filtrarTexto2.filtrar(filtrarTexto.getText()));


    }

    public void borrarPartido(ActionEvent event) {
        Logica.getINSTANCE().borraPartido(tablaPartidos.getSelectionModel().getSelectedItem());
    }
}
