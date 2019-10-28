module Pro {

    requires org.controlsfx.controls;
    requires javafx.controls;
    requires  javafx.graphics;
    requires javafx.fxml;
    exports es.Partidos.view;
    exports es.Partidos.model;
    exports es.Partidos.logica;
    exports es.Partidos;

    opens es.Partidos.view to javafx.fxml;



}