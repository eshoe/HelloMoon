package com.erinworks.hellomoon;

import android.media.MediaPlayer;
import android.content.Context;

/**
 * Created by eschumacher on 7/9/15.
 */
public class AudioPlayer {

    MediaPlayer player;

    public void stop() {
        if (player != null) {
            player.release();
            player = null;
        }
    }

    public void play(Context c) {
        stop();

        player = MediaPlayer.create(c, R.raw.one_small_step);

        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                stop();
            }
        });
        player.start();
    }

    public boolean isPlaying() {
        return player != null;
    }

}
