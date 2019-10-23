package es.Partidos.view.filters;

import es.Partidos.model.Division;
import es.Partidos.model.Partidos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class filtrarTexto {

    private ObservableList<Partidos> listaPartidos;
    private ObservableList<Partidos> listaPartidosFiltrada;

    public filtrarTexto(ObservableList<Partidos> listaPartidos) {
        this.listaPartidos = listaPartidos;
        listaPartidos = FXCollections.observableArrayList();
    }

    public ObservableList<Partidos> filtrar(String divFiltrada) {
        if (divFiltrada != null && !"".equals(divFiltrada)) {


            return listaPartidos;

        } else {
            listaPartidosFiltrada.clear();
            for (Partidos partidos : listaPartidos) {
                if (partidos.getLocal().contains(divFiltrada)) {
                    listaPartidosFiltrada.add(partidos);

                }

            }
                return listaPartidosFiltrada;
        }

    }
}
