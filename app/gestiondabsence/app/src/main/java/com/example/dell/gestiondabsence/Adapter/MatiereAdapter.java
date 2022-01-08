package com.example.dell.gestiondabsence.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dell.gestiondabsence.Bean.Matiere;
import com.example.dell.gestiondabsence.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 17/04/2018.
 */

public class MatiereAdapter extends BaseAdapter {
     List<Matiere> matieres=new ArrayList<>();
     LayoutInflater layoutInflater ;

    public MatiereAdapter(Context context, List<Matiere> matieres) {
        this.matieres=matieres;
        this.layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return matieres.size();
    }

    @Override
    public Object getItem(int position) {
        return matieres.get(position);
    }

    @Override
    public long getItemId(int position) {
        return matieres.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view =convertView;
        int pos=position;

        if (view==null)
        {
            view=layoutInflater.inflate(R.layout.item_matiere,null);
        }

        TextView id_m=view.findViewById(R.id.idm);
        TextView code_m=view.findViewById(R.id.codem);

        id_m.setText(matieres.get(pos).getId()+"");
        code_m.setText(matieres.get(pos).getNom());
        return view;
    }
}
