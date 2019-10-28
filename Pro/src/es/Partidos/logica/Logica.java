package es.Partidos.logica;

import es.Partidos.model.Division;
import es.Partidos.model.Partidos;
import es.Partidos.model.Resultado;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

public class Logica {

    private static Logica INSTANCE =null;
    private  Resultado resultado=new Resultado(12,10);

    private Partidos partido1=new Partidos("Barcelona","Madrid",resultado,Utils.convertirToDate(Utils.convertirToLocalDate(new Date(12/07/2018))), Division.primera);
    private Partidos partido2=new Partidos("Madrid","Barcelona",resultado,new Date(14/07/2018), Division.primera);
    private Partidos partido3=new Partidos("Sporting","Oviedo",resultado,new Date(13/07/2018), Division.primera);
    private ObservableList<Partidos> listaPartidos;
    private ArrayList<Partidos> arrayPartidos;

    private  Logica(){

    listaPartidos= FXCollections.observableArrayList();
    listaPartidos.addAll(partido1,partido2,partido3);

    }
    public static Logica getINSTANCE(){

        if (INSTANCE ==null){
            INSTANCE=new Logica();
        }
        return  INSTANCE;
    }

    public void addPartido(Partidos partidos){

        listaPartidos.add(partidos);

    }
    public void modificarPartido(Partidos partidos){

        int id=listaPartidos.indexOf(partidos);
        listaPartidos.set(id,partidos);

    }

    public void borraPartido(Partidos partido){

           listaPartidos.remove(partido);


    }
    public void guardarFichero(File fichero){
        try {
            ArrayList listaFichero = new ArrayList(listaPartidos);
            ObjectOutputStream obs = new ObjectOutputStream(new FileOutputStream(fichero));

            obs.writeObject(listaFichero);

        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public ObservableList getListaPartidos(){

        return listaPartidos;
    }
    public ArrayList<Partidos> getArray(){
        if(arrayPartidos.isEmpty()!=true) {
            arrayPartidos = new ArrayList<>(listaPartidos);

            return arrayPartidos;
        }else{

            return arrayPartidos;
        }
    }



}
