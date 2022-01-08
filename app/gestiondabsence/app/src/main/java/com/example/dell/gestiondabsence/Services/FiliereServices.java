package com.example.dell.gestiondabsence.Services;

import android.util.Log;

import com.example.dell.gestiondabsence.Api.FiliereApi;
import com.example.dell.gestiondabsence.Bean.Filiere;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dell on 17/04/2018.
 */

public class FiliereServices {
    public List<Filiere> findAll() {

        final List<Filiere> filieres = new ArrayList<>();
        new Retrofit.Builder()
                .baseUrl(FiliereApi.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(FiliereApi.class).getFilieres().enqueue(new Callback<List<Filiere>>() {
            @Override
            public void onResponse(Call<List<Filiere>> call, Response<List<Filiere>> response) {
                Response<List<Filiere>> res = response;
                filieres.addAll(response.body());
            }

            @Override
            public void onFailure(Call<List<Filiere>> call, Throwable t) {

                Log.d("ERROR ",t.getMessage());
            }
        });

        return filieres;
    }
}
