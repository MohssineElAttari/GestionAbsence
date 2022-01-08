package com.example.dell.gestiondabsence.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dell.gestiondabsence.Bean.Filiere;
import com.example.dell.gestiondabsence.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 17/04/2018.
 */

public class FiliereAdapter extends BaseAdapter {
    private List<Filiere> filieres =new ArrayList<>();
    private LayoutInflater layoutInflater;

    public FiliereAdapter(Context context, List<Filiere> filieres) {
        this.filieres=filieres;
        this.layoutInflater= (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return filieres.size();
    }

    @Override
    public Object getItem(int position) {
        return filieres.get(position);
    }

    @Override
    public long getItemId(int position) {
        return filieres.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view =convertView;
        int pos=position;
        if(view==null)
        {
            view=layoutInflater.inflate(R.layout.item_filiere,null);
        }

        TextView id_f=view.findViewById(R.id.idf);
        TextView code_f=view.findViewById(R.id.codef);

        id_f.setText(filieres.get(pos).getId()+"");
        code_f.setText(filieres.get(pos).getCode());

        return view;
    }
}
