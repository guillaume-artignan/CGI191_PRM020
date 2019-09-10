package com.example.cgi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Log.i("ETAT", "CREATE");
    }

    public void menuListePlats(View v){
        Intent i = new Intent(this,ListePlatsActivity.class);
        startActivity(i);
    }

    public void menuPosteAvis(View v){
        Intent i = new Intent(this,PosteAvisActivity.class);
        startActivity(i);
    }

    public void menuAfficheAvis(View v){
        Intent i = new Intent(this,AfficheAvisActivity.class);
        startActivity(i);
    }

    public void menuCarte(View v){

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ETAT", "START");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ETAT", "PAUSE");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ETAT", "RESUME");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ETAT", "RESTART");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ETAT", "STOP");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ETAT", "DESTROY");
    }
}
