package com.erinworks.hellomoon;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ImageView;

public class HelloMoonActivity extends Activity {
    Button playButton;
    Button stopButton;
    ImageView image;
    int picture;

    AudioPlayer player = new AudioPlayer();

    void updateButtons() {
        boolean isEnabled = !player.isPlaying();
        playButton.setEnabled(isEnabled);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_moon);

        picture = R.mipmap.armstrong_on_moon;
        image = (ImageView)findViewById(R.id.hellomoon_image);
        image.setImageResource(picture);
        playButton = (Button)findViewById(R.id.hellomoon_playButton);
        stopButton = (Button)findViewById(R.id.hellomoon_stopButton);

        playButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Toast.makeText(HelloMoonActivity.this, R.string.hellomoon_toast_play, Toast.LENGTH_SHORT).show();
                player.play(HelloMoonActivity.this);
                updateButtons();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Toast.makeText(HelloMoonActivity.this, R.string.hellomoon_toast_stop, Toast.LENGTH_SHORT).show();
                player.stop();
                updateButtons();
            }
        });

        image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(HelloMoonActivity.this, R.string.hellomoon_image_description, Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
    }

}
