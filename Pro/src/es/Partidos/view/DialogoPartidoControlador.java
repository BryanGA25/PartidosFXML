package es.Partidos.view;

import es.Partidos.logica.Logica;
import es.Partidos.logica.Utils;
import es.Partidos.model.Division;
import es.Partidos.model.Partidos;
import es.Partidos.model.Resultado;
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
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import java.net.URL;
import java.util.ResourceBundle;

public class DialogoPartidoControlador extends BaseController implements Initializable {

    private Partidos partidoModificar;

    @FXML
    private Button botonAceptar;

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
        dpFecha.setValue(Utils.convertirToLocalDate(partidoModificado.getDate()));
        cbDivision.setValue(partidoModificado.getDivision());
    }


    public void altaModificarPartido(ActionEvent event) {


        if (partidoModificar == null) {
            Partidos partido = new Partidos(tfLocal.getText(),
                    tfVisitante.getText(),
                    new Resultado(Integer.parseInt(tfResulLocal.getText()), Integer.parseInt(tfResultadoVisitante.getText())),
                    Utils.convertirToDate(dpFecha.getValue()) ,cbDivision.getValue());
            Logica.getINSTANCE().addPartido(partido);
        }
        else{
            partidoModificar.setLocal(tfLocal.getText());
            partidoModificar.setVisitante(tfVisitante.getText());
            partidoModificar.setDivision(cbDivision.getValue());
            partidoModificar.setResul(new Resultado(Integer.parseInt(tfResulLocal.getText()), Integer.parseInt(tfResultadoVisitante.getText())));
            partidoModificar.setDate(Utils.convertirToDate(dpFecha.getValue()));
            Logica.getINSTANCE().modificarPartido(partidoModificar);
        }
        //Obtener stage desde un evento
        ((Stage)((Node)event.getSource()).getScene().getWindow()).close();
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ValidationSupport validationsupport=new ValidationSupport();
        validationsupport.registerValidator(tfLocal, Validator.createEmptyValidator("Nombre equipo local vacio"));
        validationsupport.registerValidator(tfVisitante, Validator.createEmptyValidator("Nombre equipo visitante vacio"));
        validationsupport.registerValidator(tfResulLocal, Validator.createEmptyValidator("Resultado equipo local vacio"));
        validationsupport.registerValidator(tfResultadoVisitante, Validator.createEmptyValidator("Resultado equipo visante vacio"));
        validationsupport.registerValidator(cbDivision,Validator.createEmptyValidator("No ha seleccionado una division"));
        validationsupport.registerValidator(dpFecha,Validator.createEmptyValidator("No hay una fecha seleccionada"));
        validationsupport.invalidProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                botonAceptar.setDisable(t1);
            }
        });
        ObservableList<Division> options= FXCollections.observableArrayList(Division.primera,Division.segunda,Division.tercera);
        cbDivision.setItems(options);





    }
}
