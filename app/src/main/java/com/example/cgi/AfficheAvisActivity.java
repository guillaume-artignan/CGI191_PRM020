package com.example.cgi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.cgi.model.Avis;
import com.example.cgi.task.DownloadAvisTask;

import java.io.IOException;

public class AfficheAvisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiche_avis);

        new DownloadAvisTask().execute("https://formation-pro.eu:80/avis");
    }
}
