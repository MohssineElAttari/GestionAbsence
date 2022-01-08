package com.example.dell.gestiondabsence.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dell.gestiondabsence.Bean.AbsenceMatiere;
import com.example.dell.gestiondabsence.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 20/04/2018.
 */

public class NbrAbsenceMatiere extends BaseAdapter{
    List<AbsenceMatiere> matiereList = new ArrayList<>();
    LayoutInflater layoutInflater ;

    public NbrAbsenceMatiere(Context context, List<AbsenceMatiere> matiereList) {
        this.matiereList = matiereList;
        this.layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return matiereList.size();
    }

    @Override
    public Object getItem(int position) {
        return matiereList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return matiereList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view =convertView;
        int pos=position;

        if (view==null)
        {
            view=layoutInflater.inflate(R.layout.item_absence_matiere,null);
        }

        TextView idmatiere=view.findViewById(R.id.txtid);
        TextView nommatiere=view.findViewById(R.id.txtnommatiere);
        TextView nbrabsence=view.findViewById(R.id.txtnbr);

        idmatiere.setText(matiereList.get(pos).getId()+"");
        nommatiere.setText(matiereList.get(pos).getNom());
        nbrabsence.setText(matiereList.get(pos).getNbr_absence()+"");
        return view;
    }
}
