package com.example.dell.gestiondabsence;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dell.gestiondabsence.Adapter.ListeAdapter;
import com.example.dell.gestiondabsence.Api.StagiaireApi;
import com.example.dell.gestiondabsence.Bean.Stagiaire;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListStagiaresFragment extends Fragment {


    private ListView listStagiaires;

    private int idGroupe;
    private int idAnnee;

    private int idNiveau;
    private String type;
    private ListeAdapter adapter;
//    private SearchView searchView;


    public ListStagiaresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_stagiares, container, false);

        listStagiaires = view.findViewById(R.id.listStagiaires);

//        searchView = view.findViewById(R.id.searchAr);
        idGroupe = getArguments().getInt("idGroupe");
        idAnnee = getArguments().getInt("idAnnee");

        idNiveau = getArguments().getInt("idNiveau");
        type = getArguments().getString("type");

        new Retrofit.Builder()
                .baseUrl(StagiaireApi.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(StagiaireApi.class)
                .getStagiairesByGroupe(idGroupe,idNiveau)
                .enqueue(new Callback<List<Stagiaire>>() {
                    @Override
                    public void onResponse(Call<List<Stagiaire>> call, Response<List<Stagiaire>> response) {
                        adapter = new ListeAdapter(getActivity(),response.body());
                        listStagiaires.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<List<Stagiaire>> call, Throwable t) {

                    }
                });

               listStagiaires.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView txtid = view.findViewById(R.id.idS);

                int idd = Integer.parseInt(txtid.getText().toString());

                Bundle bundle = new Bundle();
                DetailStagiaireFragment fragment = new DetailStagiaireFragment();
                bundle.putInt("idGroupe",idGroupe);
                bundle.putInt("idAnnee",idAnnee);
                bundle.putInt("idStagiaire",idd);
                bundle.putString("type",type);

                fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.container,fragment).addToBackStack(null).commit();
            }
        });

//               searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//                   @Override
//                   public boolean onQueryTextSubmit(String query) {
//                       return false;
//                   }
//
//                   @Override
//                   public boolean onQueryTextChange(String newText) {
//
//                       adapter.filter(newText);
//
//                       return true;
//                   }
//               });


        return view;
    }

}
