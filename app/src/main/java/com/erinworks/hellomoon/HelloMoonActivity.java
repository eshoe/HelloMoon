package com.erinworks.hellomoon;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HelloMoonActivity extends Activity {
    Button playButton;
    Button stopButton;

    AudioPlayer player = new AudioPlayer();

    void updateButtons() {
        boolean isEnabled = !player.isPlaying();
        playButton.setEnabled(isEnabled);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_moon);

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
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
    }

}
