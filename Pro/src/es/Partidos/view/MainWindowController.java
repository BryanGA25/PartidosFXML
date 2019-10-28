package es.Partidos.view;

import es.Partidos.logica.Logica;
import es.Partidos.model.Division;
import es.Partidos.model.Partidos;
import es.Partidos.view.filters.filtrarTexto;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController extends BaseController implements Initializable {

    private es.Partidos.view.filters.filtrarTexto filtrarTexto2;

    @FXML
    private ComboBox comboDivision;

    @FXML
   private TextField filtrarTexto;

    @FXML
    private MenuItem menuAlta;

    @FXML
    private TableView<Partidos> tablaPartidos;



    @FXML
    void altaPartido(ActionEvent event) {
        cargarDialogo("FormularioPartidos.fxml", 700, 500).abrirDialogo(true);
        filtrarDiv();
    }
    @FXML
    void  modificarPartido(ActionEvent event){

        DialogoPartidoControlador controlador=(DialogoPartidoControlador)cargarDialogo("DialogoPartido.fxml",700,450);
        Partidos partido=tablaPartidos.getSelectionModel().getSelectedItem();
        controlador.setPartidoModificado(partido);
        controlador.abrirDialogo(true);
        filtrarDiv();

    }

   @Override
   public void initialize(URL url, ResourceBundle resourceBundle) {
       ObservableList<Division> options = FXCollections.observableArrayList(Division.primera, Division.segunda, Division.tercera);
       comboDivision.setItems(options);
       comboDivision.setValue("Division");
       tablaPartidos.setItems(Logica.getINSTANCE().getListaPartidos());
       filtrarTexto2 = new filtrarTexto(Logica.getINSTANCE().getListaPartidos());
       //siempre que se haga un cambio en el texto de filtrar texto nos notificara


   }

   public void filtrarDiv(){
        String divisionFiltrar = (String) comboDivision.getValue();
        tablaPartidos.setItems(filtrarTexto2.filtrarDivision(divisionFiltrar));

   }


    public void borrarPartido(ActionEvent event) {
        Logica.getINSTANCE().borraPartido(tablaPartidos.getSelectionModel().getSelectedItem());
    }


    public void cerrar(ActionEvent event){

        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
    }

}
