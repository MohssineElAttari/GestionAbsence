package com.example.dell.gestiondabsence.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dell.gestiondabsence.Bean.DateAbsenceMatiere;
import com.example.dell.gestiondabsence.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 20/04/2018.
 */

public class DateAbsenceMatiereAdapter extends BaseAdapter {
    List<DateAbsenceMatiere> matiereList = new ArrayList<>();
    LayoutInflater layoutInflater ;
    String type;

    public DateAbsenceMatiereAdapter(Context context, List<DateAbsenceMatiere> matiereList,String type) {
        this.matiereList = matiereList;
        this.type = type;
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
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view =convertView;
        int pos=position;

        if (view==null)
        {
            view=layoutInflater.inflate(R.layout.item_date_absence_matiere,null);
        }


        TextView nommatiere=view.findViewById(R.id.txtnommatiere);
        TextView nbrheure=view.findViewById(R.id.txtnbr);
        TextView dateabsence=view.findViewById(R.id.txtdate);

        nommatiere.setText(matiereList.get(pos).getNom());


        String nb = type.equals("retard") ? "min" : "H";

        nbrheure.setText(matiereList.get(pos).getNbrHeure()+" "+nb);

        dateabsence.setText(matiereList.get(pos).getDate_absence()+"");


        return view;
    }
}
