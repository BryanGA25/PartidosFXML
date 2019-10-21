package es.Partidos.view;

import es.Partidos.logica.Logica;
import es.Partidos.logica.Utils;
import es.Partidos.model.Division;
import es.Partidos.model.Partidos;
import es.Partidos.model.Resultado;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class DialogoPartidoControlador implements Initializable {

    private Partidos partidoModificar;
    private int indiceModificar;


    @FXML
    private TextField tfLocal;

    @FXML
    private TextField tfResulLocal;

    @FXML
    private TextField tfVisitante;

    @FXML
    private TextField tfResultadoVisitante;

    @FXML
    private DatePicker dpFecha;

    @FXML
    private ComboBox<Division> cbDivision;

    public void setPartidoModificado(Partidos partidoModificado)
    {
        this.partidoModificar = partidoModificado;
        tfLocal.setText(partidoModificado.getLocal());
        tfResulLocal.setText(String.valueOf(partidoModificado.getResul().getLocal()));
        tfVisitante.setText(partidoModificado.getVisitante());
        tfResultadoVisitante.setText(String.valueOf(partidoModificado.getResul().getVisitante()));
    }


    public void altaModificarPartido(ActionEvent event) {
        if (partidoModificar!=null)
        {
            partidoModificar.setDate(Utils.convertirToDate(dpFecha.getValue()));
            partidoModificar.setDivision(cbDivision.getValue());
            partidoModificar.setLocal(tfLocal.getText());
            partidoModificar.setVisitante(tfVisitante.getText());
            partidoModificar.setResul(new Resultado(Integer.parseInt(String.valueOf(tfResulLocal)),Integer.parseInt(String.valueOf(tfResultadoVisitante))));
            Logica.getINSTANCE().modificarPartido(partidoModificar);
        }
        else {

        }
        //Como obtener un Stage desde un evento
        Stage stage = ((Stage)((Node)event.getSource()).getScene().getWindow());
        stage.close();
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<Division> options= FXCollections.observableArrayList(Division.primera,Division.segunda,Division.tercera);
        cbDivision.setItems(options);


    }
}
