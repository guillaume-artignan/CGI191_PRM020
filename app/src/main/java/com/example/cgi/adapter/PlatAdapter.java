package com.example.cgi.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cgi.R;
import com.example.cgi.model.Plat;

public class PlatAdapter extends ArrayAdapter<Plat> {


    public PlatAdapter(Context context) {
        super(context, 0);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //super.getView(position, convertView, parent);
        Plat p = this.getItem(position);
        LayoutInflater lin = LayoutInflater.from(this.getContext());
        View v = lin.inflate(R.layout.plat,null);
        TextView nomPlat = v.findViewById(R.id.nom_plat);
        nomPlat.setText(p.getNom());
        TextView prixPlat = v.findViewById(R.id.prix_plat);
        prixPlat.setText(p.getPrix().toString());
        ImageView image = v.findViewById(R.id.img_plat);

        int id = getId(p.getImage(), "drawable");
        image.setImageResource(id);

        return v;

    }

    private int getId(String nom, String type) {
        Context context = this.getContext();
        return context.getResources().getIdentifier(nom, type, context.getPackageName());
    }
}
