package com.example.dell.gestiondabsence.Bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Abdelilah Boutizoua on 12/04/2018.
 */

public class Retard {

    private int id;

    @SerializedName("stagiaire_id")
    private int stagiaire;

    @SerializedName("matiere_id")
    private int matiere;

    @SerializedName("date_retard")
    private String dateRetard;

    @SerializedName("nbre_heure")
    private int nbre_heure;

    public Retard(int stagiaire, int matiere, String dateRetard, int nbre_heure) {
        this.stagiaire = stagiaire;
        this.matiere = matiere;
        this.dateRetard = dateRetard;
        this.nbre_heure = nbre_heure;
    }

    public int getId() {
        return id;
    }

    public int getStagiaire() {
        return stagiaire;
    }

    public int getMatiere() {
        return matiere;
    }

    public String getDateRetard() {
        return dateRetard;
    }
}
