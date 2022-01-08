package com.example.dell.gestiondabsence;


import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.dell.gestiondabsence.Api.AbsenceApi;
import com.example.dell.gestiondabsence.Api.GroupeApi;
import com.example.dell.gestiondabsence.Api.RetardApi;
import com.example.dell.gestiondabsence.Api.StagiaireApi;
import com.example.dell.gestiondabsence.Bean.Data;
import com.example.dell.gestiondabsence.Bean.Groupe;
import com.example.dell.gestiondabsence.Bean.Stagiaire;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailStagiaireFragment extends Fragment {


    TextView txtNom,txtGroupe,txtDate;

    private int idGroupe;
    private int idStagiaire;
    private int idAnnee;
    private String type;

    PieChart piechart;

    Button btnShow;

    public DetailStagiaireFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_stagiaire, container, false);

        txtNom = view.findViewById(R.id.txtNomComplet);
        txtDate = view.findViewById(R.id.txtDate);
        txtGroupe = view.findViewById(R.id.txtGroupe);
        btnShow = view.findViewById(R.id.btnShow);
        piechart = view.findViewById(R.id.piechart);


        idGroupe = getArguments().getInt("idGroupe");
        idStagiaire = getArguments().getInt("idStagiaire");
        idAnnee = getArguments().getInt("idAnnee");
        type = getArguments().getString("type");


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(StagiaireApi.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

                if(type.equals("retard")){
                    retrofit.create(RetardApi.class)
                            .getRetardByMatiere(idStagiaire,idAnnee)
                            .enqueue(new Callback<List<Data>>() {
                                @Override
                                public void onResponse(Call<List<Data>> call, Response<List<Data>> response) {
                                    setUpChart(response.body());
                                }

                                @Override
                                public void onFailure(Call<List<Data>> call, Throwable t) {

                                    t.printStackTrace();
                                }
                            });
                }
                else {
                    retrofit.create(AbsenceApi.class)
                            .getAbsencesByMatiere(idStagiaire,idAnnee)
                            .enqueue(new Callback<List<Data>>() {
                                @Override
                                public void onResponse(Call<List<Data>> call, Response<List<Data>> response) {
                                    setUpChart(response.body());
                                }

                                @Override
                                public void onFailure(Call<List<Data>> call, Throwable t) {

                                }
                            });
                }


        if(type.equals("retard")){
            btnShow.setText("Afficher Les Retards");
        }
        else {
            btnShow.setText("Afficher Les Absences");

        }

        new Retrofit.Builder()
                .baseUrl(StagiaireApi.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(StagiaireApi.class)
                .getStagiaire(idStagiaire)
                .enqueue(new Callback<Stagiaire>() {
                    @Override
                    public void onResponse(Call<Stagiaire> call, Response<Stagiaire> response) {

                        txtNom.setText(response.body().getNom()+" "+response.body().getPrenom());
                        txtDate.setText(response.body().getDate());
                    }

                    @Override
                    public void onFailure(Call<Stagiaire> call, Throwable t) {

                    }
                });

        new Retrofit.Builder()
                .baseUrl(StagiaireApi.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GroupeApi.class)
                .getGroupe(idGroupe)
                .enqueue(new Callback<Groupe>() {
                    @Override
                    public void onResponse(Call<Groupe> call, Response<Groupe> response) {
                        txtGroupe.setText(response.body().getLibelle());
                    }

                    @Override
                    public void onFailure(Call<Groupe> call, Throwable t) {

                    }
                });


        //Toast.makeText(getActivity(),idAnnee+" "+idStagiaire+" "+idGroupe+"",Toast.LENGTH_LONG).show();

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = null;
                Bundle bundle = new Bundle();

                if(type.equals("retard")){
                    fragment = new RetardMatiereFragment();
                    bundle.putString("type","retard");
                }
                else {
                    fragment = new AbsenceMatiereFragment();
                    bundle.putString("type","absence");

                }

                bundle.putInt("idStagiaire",idStagiaire);

                fragment.setArguments(bundle);

                getFragmentManager().beginTransaction().replace(R.id.container,fragment).addToBackStack(null).commit();


            }
        });


        return view;
    }

    public void setUpChart(List<Data> retards){

        piechart.setUsePercentValues(true);
        piechart.getDescription().setEnabled(false);
        piechart.setExtraOffsets(5,10,5,10);
        piechart.setDragDecelerationFrictionCoef(0.95f);
        piechart.setDrawHoleEnabled(true);
        piechart.setHoleColor(Color.WHITE);
        piechart.setTransparentCircleRadius(61f);

        ArrayList<PieEntry> entries = new ArrayList<>();

        for (Data entry : retards){
            entries.add(new PieEntry(entry.getNbre(),entry.getNom()));
        }

        PieDataSet dataSet = new PieDataSet(entries,"");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);

        PieData data = new PieData(dataSet);
        data.setValueTextSize(14f);
        data.setValueTextColor(Color.WHITE);

        piechart.setData(data);
        piechart.refreshDrawableState();
        piechart.notifyDataSetChanged();
    }

}
