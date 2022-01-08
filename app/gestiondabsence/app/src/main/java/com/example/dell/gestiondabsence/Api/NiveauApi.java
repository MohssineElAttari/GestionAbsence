package com.example.dell.gestiondabsence.Api;

import com.example.dell.gestiondabsence.Bean.Niveau;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;



public interface NiveauApi {

    String URL = "http://192.168.191.1:8080/GestionAbsence/api/";

    @POST("getNiveaux.php")
    Call<List<Niveau>> getNiveaux();

}
