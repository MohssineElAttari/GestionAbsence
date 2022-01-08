package com.example.dell.gestiondabsence;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dell.gestiondabsence.Adapter.DateAbsenceMatiereAdapter;
import com.example.dell.gestiondabsence.Api.AbsenceApi;
import com.example.dell.gestiondabsence.Bean.DateAbsenceMatiere;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class DateAbsenceMatiereFragment extends Fragment {
    TextView txtNom,txtnbr,txtDate;

    ListView list;
    public DateAbsenceMatiereFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_date_absence_matiere, container, false);

        list = view.findViewById(R.id.list);

        txtNom = view.findViewById(R.id.txtnommatiere);
        txtDate = view.findViewById(R.id.txtdate);
        txtnbr = view.findViewById(R.id.txtdate);

        int idStagiaire = getArguments().getInt("idStagiaire",0);

        final String type = getArguments().getString("type");

        int idMatiere = getArguments().getInt("idMatiere",0);


        new Retrofit.Builder()
                .baseUrl(AbsenceApi.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(AbsenceApi.class)
                .absencesByMatieres(idStagiaire,idMatiere)
                .enqueue(new Callback<List<DateAbsenceMatiere>>() {
                    @Override
                    public void onResponse(Call<List<DateAbsenceMatiere>> call, Response<List<DateAbsenceMatiere>> response) {
                        list.setAdapter(new DateAbsenceMatiereAdapter(getActivity(),response.body(),type));
                    }

                    @Override
                    public void onFailure(Call<List<DateAbsenceMatiere>> call, Throwable t) {

                    }
                });



        return view;
    }

}
