package Controlador;


import Logica.BBDD;
import Logica.Campeon;

import java.util.ArrayList;

public class Controlador {
    private BBDD bbdd;
    private ArrayList<String> campeones_name;
    private ArrayList<String> preguntas;
    private ArrayList<Campeon> campeones;

    public Controlador() {
        bbdd = new BBDD();
        campeones_name = new ArrayList<>();
        preguntas = bbdd.getPreguntas();
        campeones = bbdd.getChampionLeague();
        for (Campeon st : bbdd.getChampionLeague()) {
            campeones_name.add(st.getName());
        }

    }

    public ArrayList<String> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(ArrayList<String> preguntas) {
        this.preguntas = preguntas;
    }

    public ArrayList<Campeon> getCampeones() {
        return campeones;
    }

    public ArrayList<String> getCampeones_Name() {
        return campeones_name;
    }
}
