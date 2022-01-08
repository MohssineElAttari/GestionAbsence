package com.example.dell.gestiondabsence.Bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dell on 15/04/2018.
 */

public class Absence {
    @SerializedName("date_absence")
    private String date;
    @SerializedName("nbrHeure")
    private int nbrabsence;
    @SerializedName("etat")
    private String etat;
    @SerializedName("matiere_id")
    private int id_matiere;
    @SerializedName("stagiaire_id")
    private int id_stagiaire;

    public Absence(String date, int nbrabsence, int id_matiere, int id_stagiaire) {
        this.date = date;
        this.nbrabsence = nbrabsence;
        this.id_matiere = id_matiere;
        this.id_stagiaire = id_stagiaire;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNbrabsence() {
        return nbrabsence;
    }

    public void setNbrabsence(int nbrabsence) {
        this.nbrabsence = nbrabsence;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getId_matiere() {
        return id_matiere;
    }

    public void setId_matiere(int id_matiere) {
        this.id_matiere = id_matiere;
    }

    public int getId_stagiaire() {
        return id_stagiaire;
    }

    public void setId_stagiaire(int id_stagiaire) {
        this.id_stagiaire = id_stagiaire;
    }
}
