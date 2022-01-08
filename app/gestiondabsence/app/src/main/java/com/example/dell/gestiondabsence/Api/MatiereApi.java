package com.example.dell.gestiondabsence.Api;

import com.example.dell.gestiondabsence.Bean.Matiere;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Abdelilah Boutizoua on 14/04/2018.
 */

public interface MatiereApi {

    String URL = "http://192.168.43.90/GestionAbsence/api/";

    @POST("getMatieres.php")
    @FormUrlEncoded
    Call<List<Matiere>> getMatieres(@Field("id") int idFiliere, @Field("niveau") int niveau);
}
