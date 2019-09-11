package com.example.cgi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.cgi.R;
import com.example.cgi.model.Plat;
import com.example.cgi.model.Song;

public class SongAdapter extends ArrayAdapter<Song> {

    //private ArrayList<Song> songList;
    //private ListView songView;

    public SongAdapter(Context context) {
        super(context, 0);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater lin = LayoutInflater.from(this.getContext());
        View v = lin.inflate(R.layout.activity_song,null);
        /*TextView nomPlat = v.findViewById(R.id.nom_plat);
        nomPlat.setText(p.getNom());
        TextView prixPlat = v.findViewById(R.id.prix_plat);
        prixPlat.setText(p.getPrix().toString());
        */

        //GESTION D'UNE IMAGE
        //ImageView image = v.findViewById(R.id.img_plat);
        //int id = getId(p.getImage(), "drawable");
        //image.setImageResource(id);

        return v;
    }

    private int getId(String nom, String type) {
        Context context = this.getContext();
        return context.getResources().getIdentifier(nom, type, context.getPackageName());
    }
}
