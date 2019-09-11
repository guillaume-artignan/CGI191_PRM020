package com.example.cgi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.cgi.adapter.SongAdapter;
import com.example.cgi.model.Song;

public class SongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        SongAdapter adapter = new SongAdapter(this);
        Song song1 = new Song(1, "TitleSong", "Les 3 cafés gourmands");
        adapter.addAll(song1);
        //ListView liste = findViewById(R.id.liste_medias);
        //liste.setAdapter(adapter);
        //liste.setOnItemClickListener(this);
    }
}
