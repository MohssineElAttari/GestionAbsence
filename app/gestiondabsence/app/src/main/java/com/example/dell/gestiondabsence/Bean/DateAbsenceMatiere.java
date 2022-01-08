package com.example.dell.gestiondabsence.Bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dell on 22/04/2018.
 */

public class DateAbsenceMatiere {

     private String nom;
     private String date_absence;
     @SerializedName("nbre_heure")
     private int nbrHeure;

    public String getNom() {
        return nom;
    }

    public String getDate_absence() {
        return date_absence;
    }

    public int getNbrHeure() {
        return nbrHeure;
    }
}
