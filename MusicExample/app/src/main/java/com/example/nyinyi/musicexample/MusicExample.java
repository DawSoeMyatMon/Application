package com.example.nyinyi.musicexample;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MusicExample extends AppCompatActivity {

    MediaPlayer mp;
    private static Button btnstart;
    private static Button btnstop;
    private static Button btnpause;
    private static Button btnexit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_example);

        btnstart = (Button) findViewById(R.id.btn_start);
        btnstart.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Play Music 1", Toast.LENGTH_LONG).show();
                mp = MediaPlayer.create(MusicExample.this, R.raw.naungta);
                mp.start();

                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Toast.makeText(getApplicationContext(), "Play Music 2", Toast.LENGTH_SHORT).show();
                    }

                });
            }

        });

        btnstop = (Button) findViewById(R.id.btn_stop);
        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mp.isPlaying()) {
                    mp.stop();
                    Toast.makeText(getApplicationContext(), "Stop Music", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnpause = (Button) findViewById(R.id.btn_pause);
        btnpause.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Pause Music", Toast.LENGTH_LONG).show();
                mp.pause();
            }

        });

        btnexit = (Button) findViewById(R.id.btn_exit);
        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Exit Music", Toast.LENGTH_SHORT).show();
                mp.stop();
                finish();
            }
        });
    }

    }

