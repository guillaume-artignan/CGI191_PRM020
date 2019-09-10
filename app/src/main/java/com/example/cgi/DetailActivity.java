package com.example.cgi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.cgi.model.Plat;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent i = this.getIntent();
        Plat p = (Plat) i.getSerializableExtra("plat");
        Toast.makeText(this,""+p.getPrix(),Toast.LENGTH_LONG).show();


    }
}
