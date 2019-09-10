package com.example.cgi.task;

import android.os.AsyncTask;
import android.util.Log;

import com.example.cgi.Utils;
import com.example.cgi.model.Avis;

import java.io.IOException;

public class DownloadAvisTask extends AsyncTask<String,Integer, Avis[]> {

    @Override
    protected Avis[] doInBackground(String... strings) {

        try {
            return Utils.getAvis(strings[0]);

        } catch (IOException e) {
            Log.e("Erreur Avis","Erreur dans la récupération"+ e.getMessage());
            return new Avis[]{};
        }
    }

    @Override
    protected void onPostExecute(Avis[] avis) {
        Log.i("AVIS",""+avis.length);
    }
}
