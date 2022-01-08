package com.example.dell.gestiondabsence;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dell.gestiondabsence.Adapter.NbrAbsenceMatiere;
import com.example.dell.gestiondabsence.Api.AbsenceApi;
import com.example.dell.gestiondabsence.Bean.AbsenceMatiere;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class AbsenceMatiereFragment extends Fragment {

    ListView list;
    int idStagiaire;
    String type;


    public AbsenceMatiereFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_absence_matiere, container, false);
        list = view.findViewById(R.id.listM);


         idStagiaire = getArguments().getInt("idStagiaire",0);
        type = getArguments().getString("type");

        new Retrofit.Builder()
                .baseUrl(AbsenceApi.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(AbsenceApi.class)
                .getAbsencesByMatires(idStagiaire)
                .enqueue(new Callback<List<AbsenceMatiere>>() {
                    @Override
                    public void onResponse(Call<List<AbsenceMatiere>> call, Response<List<AbsenceMatiere>> response) {
                       list.setAdapter(new NbrAbsenceMatiere(getActivity(),response.body()));
                    }

                    @Override
                    public void onFailure(Call<List<AbsenceMatiere>> call, Throwable t) {
                        t.printStackTrace();
                    }
                });


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView txtId = view.findViewById(R.id.txtid);
                int matiere_id = Integer.parseInt(txtId.getText().toString());

                DateAbsenceMatiereFragment fragment = new DateAbsenceMatiereFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("idStagiaire",idStagiaire);
                bundle.putInt("idMatiere",matiere_id);
                bundle.putString("type",type);

                fragment.setArguments(bundle);

                getFragmentManager().beginTransaction().replace(R.id.container,fragment).addToBackStack(null).commit();

            }
        });

        return view;
    }

}
