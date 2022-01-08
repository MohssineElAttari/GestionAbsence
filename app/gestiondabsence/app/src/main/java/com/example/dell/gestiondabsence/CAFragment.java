package com.example.dell.gestiondabsence;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.gestiondabsence.Adapter.AnneeAdapter;
import com.example.dell.gestiondabsence.Adapter.FiliereAdapter;
import com.example.dell.gestiondabsence.Adapter.GroupAdapter;
import com.example.dell.gestiondabsence.Adapter.NiveauAdapter;
import com.example.dell.gestiondabsence.Api.AnneeApi;
import com.example.dell.gestiondabsence.Api.FiliereApi;
import com.example.dell.gestiondabsence.Api.GroupeApi;
import com.example.dell.gestiondabsence.Api.NiveauApi;
import com.example.dell.gestiondabsence.Bean.Annee;
import com.example.dell.gestiondabsence.Bean.Filiere;
import com.example.dell.gestiondabsence.Bean.Groupe;
import com.example.dell.gestiondabsence.Bean.Niveau;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class CAFragment extends Fragment {

    Spinner filiere;
    Spinner groupes;
    Spinner annee;
    Spinner niveaux;

    Button afficher ;

    private ListView listMatieres;
    private int idGroupe;
    private int idFiliere;
    private int idAnnee;
    private int idNiveau;

    public CAFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_ca, container, false);

        annee=view.findViewById(R.id.spinner);
        filiere=view.findViewById(R.id.spinner2);
        groupes=view.findViewById(R.id.spinner3);
        niveaux=view.findViewById(R.id.spinner4);



        afficher=view.findViewById(R.id.btnCA);

        new Retrofit.Builder()
                .baseUrl(AnneeApi.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(AnneeApi.class)
                .getAnnees()
                .enqueue(new Callback<List<Annee>>() {
                    @Override
                    public void onResponse(Call<List<Annee>> call, Response<List<Annee>> response) {
                        annee.setAdapter(new AnneeAdapter(getActivity(),response.body()));
                    }

                    @Override
                    public void onFailure(Call<List<Annee>> call, Throwable t) {
                        Toast.makeText(getActivity(), "test", Toast.LENGTH_SHORT).show();
                    }
                });

        annee.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView txtIdAnee = view.findViewById(R.id.ida);
                idAnnee = Integer.parseInt(txtIdAnee.getText().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        new Retrofit.Builder()
                .baseUrl(FiliereApi.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NiveauApi.class)
                .getNiveaux()
                .enqueue(new Callback<List<Niveau>>() {
                    @Override
                    public void onResponse(Call<List<Niveau>> call, Response<List<Niveau>> response) {
                        niveaux.setAdapter(new NiveauAdapter(getActivity(),response.body()));
                    }

                    @Override
                    public void onFailure(Call<List<Niveau>> call, Throwable t) {

                    }
                });

        niveaux.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView txtId = view.findViewById(R.id.idniveau);
                idNiveau = Integer.parseInt(txtId.getText().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        new Retrofit.Builder()
                .baseUrl(FiliereApi.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(FiliereApi.class).getFilieres().enqueue(new Callback<List<Filiere>>() {
            @Override
            public void onResponse(Call<List<Filiere>> call, Response<List<Filiere>> response) {
                filiere.setAdapter(new FiliereAdapter(getActivity(),response.body()));

            }

            @Override
            public void onFailure(Call<List<Filiere>> call, Throwable t) {

                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        filiere.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView txtId = view.findViewById(R.id.idf);

                new Retrofit.Builder()
                        .baseUrl(FiliereApi.URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(GroupeApi.class)
                        .getGroupesByFiliere(Integer.parseInt(txtId.getText().toString()))
                        .enqueue(new Callback<List<Groupe>>() {
                            @Override
                            public void onResponse(Call<List<Groupe>> call, Response<List<Groupe>> response) {
                                groupes.setAdapter(new GroupAdapter(getActivity(),response.body()));
                            }

                            @Override
                            public void onFailure(Call<List<Groupe>> call, Throwable t) {

                            }
                        });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        groupes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView txtid=view.findViewById(R.id.idg);
                idGroupe = Integer.parseInt(txtid.getText().toString());
                Toast.makeText(getActivity(), idGroupe+"", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        afficher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ListStagiaresFragment fragment = new ListStagiaresFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("idGroupe",idGroupe);
                bundle.putInt("idAnnee",idAnnee);
                bundle.putInt("idNiveau",idNiveau);
                bundle.putString("type","absence");

                fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.container,fragment).addToBackStack(null).commit();
            }
        });

        return view;

    }

}
