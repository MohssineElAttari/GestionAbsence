package com.example.dell.gestiondabsence.Api;

import com.example.dell.gestiondabsence.Bean.Absence;
import com.example.dell.gestiondabsence.Bean.AbsenceMatiere;
import com.example.dell.gestiondabsence.Bean.Data;
import com.example.dell.gestiondabsence.Bean.DateAbsenceMatiere;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface AbsenceApi {

    String URL = "http://192.168.43.90/GestionAbsence/api/";

    @POST("ajouterAbsence.php")
    Call<ResponseBody> ajouterAbsence(@Body List<Absence> absences);

    @POST("getMatieresAbsences.php")
    @FormUrlEncoded
    Call<List<AbsenceMatiere>> getAbsencesByMatires(@Field("idStagiaire") int id);

    @POST("absencesByMatieres.php")
    @FormUrlEncoded
    Call<List<DateAbsenceMatiere>> absencesByMatieres(@Field("idStagiaire") int id, @Field("matiere_id") int matiere);

    @POST("getAbsencesByMatiere.php")
    @FormUrlEncoded
    Call<List<Data>> getAbsencesByMatiere(@Field("stagiaire_id") int stagiaire_id, @Field("annee") int annee);
}
