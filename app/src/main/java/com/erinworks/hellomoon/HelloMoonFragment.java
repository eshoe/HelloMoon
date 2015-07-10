package com.erinworks.hellomoon;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.Button;

/**
 * Created by eschumacher on 7/9/15.
 */
public class HelloMoonFragment extends Fragment{

    Button playButton;
    Button stopButton;
    AudioPlayer player;

    void updateButtons() {
        boolean isEnabled = !player.isPlaying();
        playButton.setEnabled(isEnabled);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        player = new AudioPlayer();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_hello_moon, parent, false);

        playButton = (Button)v.findViewById(R.id.hellomoon_playButton);
        stopButton = (Button)v.findViewById(R.id.hellomoon_stopButton);

        playButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Toast.makeText(HelloMoonActivity.this, R.string.hellomoon_toast_play, Toast.LENGTH_SHORT).show();
                player.play(getActivity());
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

        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
    }
}
