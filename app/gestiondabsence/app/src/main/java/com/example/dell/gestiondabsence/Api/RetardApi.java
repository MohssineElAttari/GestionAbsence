package com.example.dell.gestiondabsence.Api;

import com.example.dell.gestiondabsence.Bean.AbsenceMatiere;
import com.example.dell.gestiondabsence.Bean.Data;
import com.example.dell.gestiondabsence.Bean.DateAbsenceMatiere;
import com.example.dell.gestiondabsence.Bean.Retard;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;



public interface RetardApi {

    String URL = "http://192.168.43.90/GestionAbsence/api/";

    @POST("ajouterRetard.php")
    Call<ResponseBody> ajouterRetard(@Body List<Retard> retards);

    @POST("getMatieresRetards.php")
    @FormUrlEncoded
    Call<List<AbsenceMatiere>> getMatieresRetards(@Field("idStagiaire") int id);

    @POST("RetardByMatiere.php")
    @FormUrlEncoded
    Call<List<DateAbsenceMatiere>> RetardByMatiere(@Field("idStagiaire") int id, @Field("matiere_id") int matiere);

    @POST("getRetardByMatiere.php")
    @FormUrlEncoded
    Call<List<Data>> getRetardByMatiere(@Field("stagiaire_id") int stagiaire_id, @Field("annee") int annee);

}
