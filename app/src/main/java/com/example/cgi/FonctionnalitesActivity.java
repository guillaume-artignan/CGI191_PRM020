package com.example.cgi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.telephony.SmsManager;
import android.view.View;

public class FonctionnalitesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fonctionnalites);
    }

    public void positionActivity(View v){
        Intent i = new Intent(this, PositionActivity.class);
        startActivity(i);
    }

    public void ouvrirSon(View v){
        Intent i = new Intent(this,JouerSonActivity.class);
        startActivity(i);
    }

  public void Flashlight(View v){
        Intent i = new Intent(this,FlashLightActivity.class);
        startActivity(i);
    }

    public void fonctionnalitePhoneCall(View v){
        Intent i = new Intent(this,PhoneCallActivity.class);
        startActivity(i);
    }

    public void sensorFonction(View v){
        Intent i = new Intent(this,SensorActivity.class);
        startActivity(i);
    }

    public void afficheBattery (View v){
        Intent i = new Intent(this,BatteryActivity.class);
        startActivity(i);
    }

    public void volume(View v){
        Intent i = new Intent(this,VolumeActivity.class);
        startActivity(i);
    }

    public void SmsActivity (View v){
        Intent i = new Intent(this,SmsActivity.class);
        startActivity(i);
       }
}
