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

import com.example.dell.gestiondabsence.Adapter.FiliereAdapter;
import com.example.dell.gestiondabsence.Adapter.GroupAdapter;
import com.example.dell.gestiondabsence.Adapter.MatiereAdapter;
import com.example.dell.gestiondabsence.Adapter.NiveauAdapter;
import com.example.dell.gestiondabsence.Api.FiliereApi;
import com.example.dell.gestiondabsence.Api.GroupeApi;
import com.example.dell.gestiondabsence.Api.MatiereApi;
import com.example.dell.gestiondabsence.Api.NiveauApi;
import com.example.dell.gestiondabsence.Bean.Filiere;
import com.example.dell.gestiondabsence.Bean.Groupe;
import com.example.dell.gestiondabsence.Bean.Matiere;
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
public class GABFragment extends Fragment {

    Spinner filiere;
    Spinner groupes;
    Spinner matiere;
    Spinner niveaux;
    Button afficher ;

    private ListView listMatieres;
    private int idMatiere;
    private int idGroupe;
    private int idNiveau;
    private int idFiliere;

    public GABFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        final View view = inflater.inflate(R.layout.fragment_gab, container, false);

        filiere=view.findViewById(R.id.spinner);
        groupes=view.findViewById(R.id.spinner2);
        matiere=view.findViewById(R.id.spinner3);

        niveaux=view.findViewById(R.id.spinner4);

        afficher=view.findViewById(R.id.btnvalider);

        afficher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ABFragment  abFragment=new ABFragment();
                Bundle bundle = new Bundle();

                bundle.putInt("idMatiere", idMatiere);
                bundle.putInt("idGroupe", idGroupe);
                bundle.putInt("idNiveau",idNiveau);

                abFragment.setArguments(bundle);
                getActivity().getFragmentManager().beginTransaction().replace(R.id.container,abFragment).addToBackStack(null).commit();


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
                //filiere.setVisibility(View.VISIBLE);
                new Retrofit.Builder()
                        .baseUrl(MatiereApi.URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(MatiereApi.class)
                        .getMatieres(idFiliere,idNiveau)
                        .enqueue(new Callback<List<Matiere>>() {
                            @Override
                            public void onResponse(Call<List<Matiere>> call, Response<List<Matiere>> response) {
                                matiere.setAdapter(new MatiereAdapter(getActivity(),response.body()));
                            }

                            @Override
                            public void onFailure(Call<List<Matiere>> call, Throwable t) {

                            }
                        });

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

                idFiliere = Integer.parseInt(txtId.getText().toString());
                //groupes.setVisibility(View.VISIBLE);
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

                    //matiere.setVisibility(View.VISIBLE);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });



            matiere.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    TextView iidMatiere=view.findViewById(R.id.idm);
                    idMatiere = Integer.parseInt(iidMatiere.getText().toString());
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {



                }
            });

        return view;
    }


}
