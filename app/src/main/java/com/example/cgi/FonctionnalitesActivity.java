package com.example.cgi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FonctionnalitesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fonctionnalites);
    }

    public void afficheBattery (View v){
        Intent i = new Intent(this,BatteryActivity.class);
        startActivity(i);
    }
}