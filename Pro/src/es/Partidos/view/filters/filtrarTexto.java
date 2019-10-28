package es.Partidos.view.filters;

import es.Partidos.model.Division;
import es.Partidos.model.Partidos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class filtrarTexto {

    private ObservableList<Partidos> listaPartidos;
    private ObservableList<Partidos> listaPartidosFiltrada;

    public filtrarTexto(ObservableList<Partidos> listaPartidos) {
        this.listaPartidos = listaPartidos;
        listaPartidosFiltrada = FXCollections.observableArrayList();
    }


   public ObservableList<Partidos> filtrarDivision(Division divisionFiltrar) {
        ObservableList<Partidos> aux = FXCollections.observableArrayList();
        for (Partidos partido : listaPartidos) {
            if(partido.getDivision()==(divisionFiltrar)){
                aux.add(partido);
            }
        }
        return aux;

    }

}

