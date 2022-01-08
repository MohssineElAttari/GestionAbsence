package com.example.dell.gestiondabsence.Api;

import com.example.dell.gestiondabsence.Bean.Stagiaire;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface StagiaireApi {

    String URL = "http://192.168.43.90/GestionAbsence/api/";

    @POST("GetStagiairesByGroupe.php")
    @FormUrlEncoded
    Call<List<Stagiaire>> getStagiairesByGroupe(@Field("idGroupe") int idGroupe,@Field("niveau") int niveau);


    @POST("getStagiaire.php")
    @FormUrlEncoded
    Call<Stagiaire> getStagiaire(@Field("id") int id);
}
