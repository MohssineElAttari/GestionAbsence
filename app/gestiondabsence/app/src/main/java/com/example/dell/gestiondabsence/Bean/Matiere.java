package com.example.dell.gestiondabsence.Bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dell on 15/04/2018.
 */

public class Matiere{
    @SerializedName("id")
    private int id;
    @SerializedName("nom")
    private String nom;
    @SerializedName("code")
    private String code;
    @SerializedName("massHoraire")
    private String massHoraire;

    @SerializedName("nbrHeure")
    private int nbr_heure;

    @SerializedName("nbr_absence")
    private int nbr_absence;

    //@SerializedName("date_absence")
    private String date_absence;

    public Matiere(int id, String nom, String code, String massHoraire) {
        this.id = id;
        this.nom = nom;
        this.code = code;
        this.massHoraire = massHoraire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMassHoraire() {
        return massHoraire;
    }

    public void setMassHoraire(String massHoraire) {
        this.massHoraire = massHoraire;
    }

    public int getNbr_heure() {
        return nbr_heure;
    }

    public int getNbr_absence() {
        return nbr_absence;
    }

    public String getDate_absence() {
        return date_absence;
    }
}
