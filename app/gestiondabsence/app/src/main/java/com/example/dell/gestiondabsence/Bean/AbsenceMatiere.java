package com.example.dell.gestiondabsence.Bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dell on 22/04/2018.
 */

public class AbsenceMatiere {

    @SerializedName("id")
    private int id;
    @SerializedName("nom")
    private String nom;
    @SerializedName("nbr_absence")
    private int nbr_absence;


    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getNbr_absence() {
        return nbr_absence;
    }
}
