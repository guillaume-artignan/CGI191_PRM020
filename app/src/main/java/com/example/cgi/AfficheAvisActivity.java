package com.example.cgi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.cgi.model.Avis;
import com.example.cgi.task.DownloadAvisTask;

import java.io.IOException;

public class AfficheAvisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiche_avis);

        new DownloadAvisTask(this).execute("https://formation-pro.eu:80/avis");
    }

    public void setAvis(Avis[] avis) {
        ProgressBar progress = findViewById(R.id.progressBar);
        TextView nbAvis = findViewById(R.id.nb_avis);
        nbAvis.setText("On a récupéré "+avis.length+" avis");
        progress.animate()
                .translationX(500)
                .alpha(0f)
                .setDuration(2000);

        nbAvis.setVisibility(View.VISIBLE);
        nbAvis.setAlpha(0f);
        nbAvis.animate()
                .translationX(100)
                .alpha(1.0f)
                .setDuration(2000);



    }
}
