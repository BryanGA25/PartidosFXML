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
        listaPartidosFiltrada = FXCollections.observableArrayList();
    }

    public ObservableList<Partidos> filtrar(String nombreEquipo) {
        if (nombreEquipo != null && !"".equals(nombreEquipo)) {

            listaPartidosFiltrada.clear();
            for (Partidos partidos : listaPartidos) {
                if (partidos.getLocal().contains(nombreEquipo))
                    listaPartidosFiltrada.add(partidos);
            }
            return listaPartidosFiltrada;


        }
        else {
                return listaPartidos;
            }
        }

    }

