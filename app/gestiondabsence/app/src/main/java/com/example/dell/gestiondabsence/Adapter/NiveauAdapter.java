package com.example.dell.gestiondabsence.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dell.gestiondabsence.Bean.Niveau;
import com.example.dell.gestiondabsence.R;

import java.util.List;

/**
 * Created by Dell on 22/04/2018.
 */

public class NiveauAdapter extends BaseAdapter {

    private List<Niveau> niveaux;
    private LayoutInflater layoutInflater;

    public NiveauAdapter(Context context,List<Niveau> niveaux) {
        this.niveaux = niveaux;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return niveaux.size();
    }

    @Override
    public Niveau getItem(int position) {
        return niveaux.get(position);
    }

    @Override
    public long getItemId(int position) {
        return niveaux.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null)
            convertView = layoutInflater.inflate(R.layout.niveau_item,null);

        TextView txtId = convertView.findViewById(R.id.idniveau);
        TextView txtNom = convertView.findViewById(R.id.niveau);


        txtId.setText(niveaux.get(position).getId()+"");
        txtNom.setText(niveaux.get(position).getNom());

        return convertView;
    }
}
