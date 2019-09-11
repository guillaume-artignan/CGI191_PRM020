package com.example.cgi;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class VolumeActivity extends AppCompatActivity {
    SeekBar volumeControl;
    TextView showCurrentVolume;
    boolean muted;
    int currentVolume;
    Button muteControl;
    AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);

        muted = false;
        volumeControl = (SeekBar)findViewById(R.id.seekBar1);
        muteControl = (Button)findViewById(R.id.buttonMute);
        showCurrentVolume = (TextView)findViewById(R.id.textView2);
        showCurrentVolume.setText("0");
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        volumeControl.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_RING));

        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                audioManager.setStreamVolume(AudioManager.STREAM_RING, i, 0);
                currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_RING);
                showCurrentVolume.setText(Integer.toString(currentVolume));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void muteAction(View v){
        if(muted == false){
            muted = true;
            audioManager.setStreamMute(AudioManager.STREAM_RING, true);
            muteControl.setText("UnMute");
        } else {
            muted = false;
            audioManager.setStreamMute(AudioManager.STREAM_RING, false);
            muteControl.setText("Mute");
        }
    }
}
