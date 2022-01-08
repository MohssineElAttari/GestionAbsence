package com.example.dell.gestiondabsence;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomFragment extends Fragment {

Button btnFA;
Button btnFR;
Button btnCA;
Button btnCR;

    public WelcomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_welcom, container, false);

        btnFA=view.findViewById(R.id.btnFA);

        btnFR=view.findViewById(R.id.btnFR);

        btnCA=view.findViewById(R.id.btnCA);

        btnCR=view.findViewById(R.id.btnCR);

        btnFA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.container,new GABFragment()).addToBackStack(null).commit();
            }
        });

        btnFR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.container,new GRFragment()).addToBackStack(null).commit();
            }
        });

        btnCA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.container,new CAFragment()).addToBackStack(null).commit();
            }
        });

        btnCR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.container,new CRFragment()).addToBackStack(null).commit();
            }
        });
        return view;
    }

}
