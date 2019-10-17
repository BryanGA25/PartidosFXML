package es.Partidos.view;

import es.Partidos.model.Division;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DialogoPartidoControlador {

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

}