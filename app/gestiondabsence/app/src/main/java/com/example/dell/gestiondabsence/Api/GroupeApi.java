package com.example.dell.gestiondabsence.Api;

import com.example.dell.gestiondabsence.Bean.Groupe;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;



public interface GroupeApi {

    String URL = "http://192.168.43.90/GestionAbsence/api/";

    @POST("getGroupesByFiliere.php")
    @FormUrlEncoded
    Call<List<Groupe>> getGroupesByFiliere(@Field("idFiliere") int idFiliere);

    @POST("getGroupe.php")
    @FormUrlEncoded
    Call<Groupe> getGroupe(@Field("id") int id);
}
