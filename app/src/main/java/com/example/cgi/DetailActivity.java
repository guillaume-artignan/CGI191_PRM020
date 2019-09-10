package com.example.cgi;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cgi.model.Plat;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent i = this.getIntent();
        Plat p = (Plat) i.getSerializableExtra("plat");

        TextView tv_description = findViewById(R.id.description_plat_detail);
        ImageView image = findViewById(R.id.image_plat_detail);
        TextView tv_nom = findViewById(R.id.nom_plat_detail);

        tv_nom.setText(p.getNom());
        tv_description.setText(p.getDescription());
        image.setImageResource(getId(p.getImage(),"drawable"));
    }

    private int getId(String nom, String type) {
        Context context = this;
        return context.getResources().getIdentifier(nom, type, context.getPackageName());
    }
}
