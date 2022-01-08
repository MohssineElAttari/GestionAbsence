package com.example.dell.gestiondabsence.Bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dell on 15/04/2018.
 */

public class Annee {
    private int id;
    @SerializedName("annee")
    private String Annee;

    public Annee(int id, String annee) {
        this.id = id;
        Annee = annee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnnee() {
        return Annee;
    }

    public void setAnnee(String annee) {
        Annee = annee;
    }
}
