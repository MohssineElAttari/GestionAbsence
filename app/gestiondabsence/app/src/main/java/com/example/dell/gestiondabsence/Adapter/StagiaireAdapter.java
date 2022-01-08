package com.example.dell.gestiondabsence.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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

public class StagiaireAdapter extends BaseAdapter{

    List<Stagiaire> stagiaires=new ArrayList<>();
    LayoutInflater layoutInflater ;
    String type;

    private int[] numIds;
    private boolean[]  checkedItems;

    public StagiaireAdapter(Context context, List<Stagiaire> stagiaires,String type) {
        this.stagiaires=stagiaires;
        this.layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        numIds = new int[stagiaires.size()];
        checkedItems = new boolean[stagiaires.size()];

        this.type = type;
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
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;



        if (convertView==null)
        {
            convertView=layoutInflater.inflate(R.layout.listeabsence,null);
            viewHolder = new ViewHolder();

            viewHolder.image = convertView.findViewById(R.id.img);

            viewHolder.txtId=convertView.findViewById(R.id.txtid);
            viewHolder.txtNom=convertView.findViewById(R.id.txtnom);
            viewHolder.checkBox = convertView.findViewById(R.id.absence);

            if(type.equals("retard")){
            viewHolder.checkBox.setText("Retard");
        }
        else{
            viewHolder.checkBox.setText("Absent");
        }

            convertView.setTag(viewHolder);
        }
        else{

            viewHolder = (ViewHolder) convertView.getTag();

            viewHolder.checkBox.setOnCheckedChangeListener(null);

            viewHolder.checkBox.setChecked(checkedItems[position]);
        }

        viewHolder.txtId.setText(stagiaires.get(position).getId()+"");
        viewHolder.txtNom.setText(stagiaires.get(position).getNom()+"");

        ColorGenerator generator = ColorGenerator.MATERIAL; // or use DEFAULT
        int color = generator.getColor(getItem(position));
        TextDrawable drawable = TextDrawable.builder()
                .buildRound((position+1)+"", color); // radius in px
        viewHolder.image.setImageDrawable(drawable);

        viewHolder.checkBox.setTag(R.id.absence,position);

        viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                int position = (int) buttonView.getTag(R.id.absence);

                if(isChecked){
                    numIds[position] = stagiaires.get(position).getId();
                    checkedItems[position] = true;
                }
                else {
                    numIds[position] = 0;
                    checkedItems[position] = false;
                }

            }
        });

        return convertView;
    }

    class ViewHolder{
        ImageView image;
        TextView txtId;
        TextView txtNom;
        CheckBox checkBox;
    }

    public List<Integer> getNumIds() {

        List<Integer> listAbsences = new ArrayList<>();

        for (int id : numIds){
            if(id != 0){
                listAbsences.add(id);
            }
        }

        return listAbsences;
    }
}
