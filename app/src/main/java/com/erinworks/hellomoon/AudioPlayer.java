package com.erinworks.hellomoon;

import android.media.MediaPlayer;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by eschumacher on 7/9/15.
 */
public class AudioPlayer {

    MediaPlayer player;
    boolean paused = false;

    public void stop() {
        if (player != null) {
            player.release();
            player = null;
            paused = false;
        }
    }

    public void play(Context c) {
        if (!paused) {
            stop();
            player = MediaPlayer.create(c, R.raw.one_small_step);

            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    stop();
                }
            });
        }
            player.start();
    }

    public void pause() {
        player.pause();
        paused = true;
    }

    public boolean isPlaying() {
        if (player == null) {
            return false;
        } else {
            return player.isPlaying();
        }
    }

}
