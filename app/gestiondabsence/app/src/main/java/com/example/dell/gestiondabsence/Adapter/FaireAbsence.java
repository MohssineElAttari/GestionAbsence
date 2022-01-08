package com.example.dell.gestiondabsence.Adapter;

import android.app.LauncherActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.gestiondabsence.Bean.Stagiaire;
import com.example.dell.gestiondabsence.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 15/04/2018.
 */
public class FaireAbsence extends BaseAdapter {
    private List<Stagiaire> stagiaires = new ArrayList<>();
    private LayoutInflater inflater;

    public FaireAbsence(Context context, List<Stagiaire> stagiaires) {
        this.stagiaires = stagiaires;
        this.inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return stagiaires.size();
    }

    @Override
    public Object getItem(int position) {
        return stagiaires.get(position);
    }

    @Override
    public long getItemId(int position) {
        return stagiaires.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    View liststg=convertView;
    int pos=position;
    if(liststg==null)
        {
            liststg=inflater.inflate(R.layout.listeabsence,null);
        }

        TextView id=liststg.findViewById(R.id.txtid);
        TextView nom=liststg.findViewById(R.id.txtnom);
        CheckBox checkA=liststg.findViewById(R.id.absence);

        id.setText(stagiaires.get(pos).getId()+"");
        nom.setText(stagiaires.get(pos).getNom()+" "+stagiaires.get(pos).getPrenom());
        checkA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        return liststg;

    }
}
