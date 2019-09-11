package com.example.cgi;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.io.IOException;

public class PlayMediaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_media);
    }

    public void onItemClick(View v) throws IOException {
        String url = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3";
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setDataSource(url);//"D:\\Formations\\_POE_CGI\\AndroidStudioProjects\\CGI191_PRM020\\app\\src\\main\\res\\raw\\coffre_jouets.mp3");
        mediaPlayer.prepareAsync();
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });
    }
}
