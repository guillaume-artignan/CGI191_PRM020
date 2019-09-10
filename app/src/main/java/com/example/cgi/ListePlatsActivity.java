package com.example.cgi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.cgi.adapter.PlatAdapter;
import com.example.cgi.model.Plat;

public class ListePlatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_plats);
        Log.i("\t \t \t ETAT", "CREATE");

        PlatAdapter adapter = new PlatAdapter(this);
        Plat p1 = new Plat();
        Plat p2 = new Plat();
        Plat p3 = new Plat();

        p1.setNom("Pannacotta au gingembre");
        p2.setNom("Crevette à l'ananas");
        p3.setNom("Porc au légumes");

        adapter.addAll(p1,p2,p3);
        ListView liste = findViewById(R.id.liste_plats);
        liste.setAdapter(adapter);
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
}
