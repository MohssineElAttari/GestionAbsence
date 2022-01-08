package com.example.dell.gestiondabsence.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dell.gestiondabsence.Bean.Groupe;
import com.example.dell.gestiondabsence.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 17/04/2018.
 */

public class GroupAdapter extends BaseAdapter {
    List<Groupe>groupes=new ArrayList<>();
    LayoutInflater layoutInflater;


    public GroupAdapter(Context context, List<Groupe> groupes) {
        this.groupes = groupes;
        this.layoutInflater= (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return groupes.size();
    }

    @Override
    public Object getItem(int position) {
        return groupes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return groupes.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=convertView;
        int pos=position;
        if (view==null)
        {
            view=layoutInflater.inflate(R.layout.item_groupe,null);
        }

        TextView id_g=view.findViewById(R.id.idg);
        TextView code_g=view.findViewById(R.id.codeg);

        id_g.setText(groupes.get(pos).getId()+"");
        code_g.setText(groupes.get(pos).getLibelle());
        return view ;
    }
}
