package com.example.dell.gestiondabsence.Api;

import com.example.dell.gestiondabsence.Bean.Annee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;


public interface AnneeApi {

    String URL = "http://192.168.43.90/GestionAbsence/api/";

    @POST("getAnnees.php")
    Call<List<Annee>> getAnnees();

    @POST("getLastYear.php")
    Call<Annee> getlastYear();

}
