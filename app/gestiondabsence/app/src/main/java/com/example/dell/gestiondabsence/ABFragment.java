package com.example.dell.gestiondabsence;


import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dell.gestiondabsence.Adapter.StagiaireAdapter;
import com.example.dell.gestiondabsence.Api.AbsenceApi;
import com.example.dell.gestiondabsence.Api.StagiaireApi;
import com.example.dell.gestiondabsence.Bean.Absence;
import com.example.dell.gestiondabsence.Bean.Stagiaire;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class ABFragment extends Fragment {
    private ListView ListStaiaire;
    private StagiaireAdapter adapter;

    private Button valider;

    private int idMatiere;

    private int idGroupe;
    private int idNiveau;

    public ABFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_ab, container, false);

        ListStaiaire=view.findViewById(R.id.list_absence);
        valider = view.findViewById(R.id.valider_absence);

        idMatiere = getArguments().getInt("idMatiere",0);

        idGroupe = getArguments().getInt("idGroupe",0);

        idNiveau = getArguments().getInt("idNiveau",0);
        
        new Retrofit.Builder()
                .baseUrl(StagiaireApi.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(StagiaireApi.class)
                .getStagiairesByGroupe(idGroupe,idNiveau)
                .enqueue(new Callback<List<Stagiaire>>() {
            @Override
            public void onResponse(Call<List<Stagiaire>> call, Response<List<Stagiaire>> response) {


                adapter = new StagiaireAdapter(getActivity(),response.body(),"absence");

                ListStaiaire.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Stagiaire>> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(), adapter.getNumIds()+"", Toast.LENGTH_SHORT).show();

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Entrer Nombre Heures");

                final EditText input = new EditText(getActivity());
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                builder.setView(input);

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int nbreHeure = Integer.parseInt(input.getText().toString());
                        DateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
                        List<Absence> absences = new ArrayList<>();

                        for (int id : adapter.getNumIds()){
                            absences.add(new Absence(dt.format(new Date()),nbreHeure,idMatiere,id));
                        }

                        ajouterAbsence(absences);

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();

            }
        });





        return view;
    }


    public void ajouterAbsence(List<Absence> absences){
        new Retrofit.Builder()
                .baseUrl(StagiaireApi.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(AbsenceApi.class)
                .ajouterAbsence(absences)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Toast.makeText(getActivity(), "bien Ajouter", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });


    }

}
