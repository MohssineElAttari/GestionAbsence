package com.example.dell.gestiondabsence.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.example.dell.gestiondabsence.Bean.Stagiaire;
import com.example.dell.gestiondabsence.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 18/04/2018.
 */

public class ListeAdapter extends BaseAdapter {

    List<Stagiaire> stagiaires;
    LayoutInflater layoutInflater;
    List<Stagiaire> newList;

    public ListeAdapter(Context context, List<Stagiaire> stagiaires) {
        this.stagiaires = stagiaires;
        this.layoutInflater= (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        newList = new ArrayList<>();
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
        View view=convertView;
        int pos=position;
        if (view==null)
        {
            view=layoutInflater.inflate(R.layout.liste_item,null);
        }

        TextView id_s=view.findViewById(R.id.idS);
        TextView nomS=view.findViewById(R.id.nomS);
        ImageView image = view.findViewById(R.id.img);

        id_s.setText(stagiaires.get(pos).getId()+"");
        nomS.setText(stagiaires.get(pos).getNom()+" "+stagiaires.get(pos).getPrenom());

        ColorGenerator generator = ColorGenerator.MATERIAL; // or use DEFAULT
        int color = generator.getColor(getItem(position));
        TextDrawable drawable = TextDrawable.builder()
                .buildRound((position+1)+"", color); // radius in px
        image.setImageDrawable(drawable);

        return view ;
    }

//    public void filter(String query){
//
//        newList.addAll(stagiaires);
//        stagiaires.clear();
//
//        if(query.length() == 0){
//            stagiaires.addAll(newList);
//        }
//        else {
//
//            for (Stagiaire stg : newList){
//
//                if(stg.getPrenom().toLowerCase().startsWith(query.toLowerCase()) || stg.getNom().toLowerCase().startsWith(query.toLowerCase())){
//                    stagiaires.add(stg);
//                }
//            }
//        }
//
//        notifyDataSetChanged();
//
//    }
}
