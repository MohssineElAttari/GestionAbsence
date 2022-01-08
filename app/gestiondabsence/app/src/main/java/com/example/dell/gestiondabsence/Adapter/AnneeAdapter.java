package com.example.dell.gestiondabsence.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dell.gestiondabsence.Bean.Annee;
import com.example.dell.gestiondabsence.R;

import java.util.List;

/**
 * Created by Dell on 18/04/2018.
 */

public class AnneeAdapter extends BaseAdapter {
    List<Annee> annees;
    LayoutInflater layoutInflater;

    public AnneeAdapter(Context context, List<Annee> annees) {
        this.annees = annees;
        this.layoutInflater= (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return annees.size();
    }

    @Override
    public Object getItem(int position) {
        return annees.get(position);
    }

    @Override
    public long getItemId(int position) {
        return annees.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=convertView;
        int pos=position;
        if (view==null)
        {
            view=layoutInflater.inflate(R.layout.item_annee,null);
        }

        TextView id_a=view.findViewById(R.id.ida);
        TextView annee_a=view.findViewById(R.id.anneea);

        id_a.setText(annees.get(pos).getId()+"");
        annee_a.setText(annees.get(pos).getAnnee());
        return view ;
    }
}
