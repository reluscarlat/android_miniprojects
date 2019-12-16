package com.example.android.mywok2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;
    AudioManager.OnAudioFocusChangeListener audioFocusChangeListener = focusChange -> {
        if(focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
        focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
//            The AUDIOFOCUS_LOSS_TRANSIENT means that we've lost audio focus for a short amount of time.
//            The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK means that our app is allowed to continue playing sound but at a lower volume.
//            We treated both case because the app is playing short sound.
            mediaPlayer.pause();
            mediaPlayer.seekTo(0);
        } else if(focusChange == AudioManager.AUDIOFOCUS_GAIN){
            // The AUDIOFOCUS_GAIN means that we have regained focus and can resume playback.
            mediaPlayer.start();
        } else if(focusChange == AudioManager.AUDIOFOCUS_LOSS) {
            // The AUDIOFOCUS_LOSS means we've lost audio focus and stop playback and cleanup resources
            releaseMediaPlayer();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);

        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("unu", "one", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("doi", "two", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("trei", "three", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("patru", "four", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("cinci", "five", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("sase", "six", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("sapte", "seven", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("opt", "eight", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("noua", "nine", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("zece", "ten", R.drawable.number_ten, R.raw.number_ten));

        NumberAdapter itemsAdapter = new NumberAdapter(this, words);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Word word = words.get(position);
            releaseMediaPlayer();

            // Request audio focus for playback
            int result = audioManager.requestAudioFocus(audioFocusChangeListener,
                    // Use the music stream.
                    AudioManager.STREAM_MUSIC,
                    // Request permanent focus.
                    AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

            if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                // We have audio focus now.
//                audioManager.registerMediaButtonEventReceiver();
                mediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getSound());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(c -> releaseMediaPlayer());
            }
        });
    }

    private void releaseMediaPlayer() {
        if(mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        audioManager.abandonAudioFocus(audioFocusChangeListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mediaPlayer != null) {
            mediaPlayer.stop();
            releaseMediaPlayer();
        }
    }
}
