package com.example.video;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;
public class PlayerVideo extends AppCompatActivity {
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_video);

        videoView = findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.lost_in_the_space);

        videoView.start();

        videoView.setMediaController(new MediaController(this));

        View decorView = getWindow().getDecorView();

        int option = View.SYSTEM_UI_FLAG_FULLSCREEN;

        decorView.setSystemUiVisibility(option);
    }

}