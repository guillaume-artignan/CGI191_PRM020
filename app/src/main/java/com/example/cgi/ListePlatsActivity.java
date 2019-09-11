package com.example.cgi;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.cgi.adapter.PlatAdapter;
import com.example.cgi.model.Plat;

public class ListePlatsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_plats);
        Log.i("\t \t \t ETAT", "CREATE");

        PlatAdapter adapter = new PlatAdapter(this);
        Plat p1 = new Plat();
        Plat p2 = new Plat();
        Plat p3 = new Plat();
        Plat p4 = new Plat();
        Plat p5 = new Plat();
        Plat p6 = new Plat();
        Plat p7 = new Plat();

        p1.setNom("Pannacotta au gingembre");
        p2.setNom("Crevette à l'ananas");
        p3.setNom("Porc au légumes");
        p4.setNom("Poulet");
        p5.setNom("Crevette");
        p6.setNom("Porc");
        p7.setNom("Un truc asiatique");

        p1.setPrix(5.5);
        p2.setPrix(12.0);
        p3.setPrix(10.0);
        p4.setPrix(11.0);
        p5.setPrix(12.0);
        p6.setPrix(13.0);
        p7.setPrix(14.0);

        p1.setImage("plat3");
        p2.setImage("plat2");
        p3.setImage("plat1");
        p4.setImage("plat4");
        p5.setImage("plat5");
        p6.setImage("plat6");
        p7.setImage("plat7");


        p1.setDescription("Super pannacotta au gingembre bla bla");
        p2.setDescription("Crevette à l'ananas bla bla");
        p3.setDescription("Porc au legume bla bla");
        p4.setDescription("Super pannacotta au gingembre bla bla");
        p5.setDescription("Crevette à l'ananas bla bla");
        p6.setDescription("Porc au legume bla bla");
        p7.setDescription("Super pannacotta au gingembre bla bla");


        adapter.addAll(p1,p2,p3,p4,p5,p6,p7);
        ListView liste = findViewById(R.id.liste_plats);
        liste.setAdapter(adapter);
        liste.setOnItemClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("\t \t \t ETAT", "START");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("\t \t \t ETAT", "PAUSE");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("\t \t \t ETAT", "RESUME");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("\t \t \t ETAT", "RESTART");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("\t \t \t ETAT", "STOP");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("\t \t \t ETAT", "DESTROY");
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Plat p = (Plat) adapterView.getItemAtPosition(i);
        Intent intent = new Intent(this,DetailActivity.class);
        intent.putExtra("plat",p);

        startActivity(intent);

    }
}
