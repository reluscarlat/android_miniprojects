package com.example.android.mywok2;

import android.app.Activity;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class NumberAdapter extends ArrayAdapter<Word> {
    MediaPlayer mediaPlayer;

    public NumberAdapter(Activity context, ArrayList<Word> words) {
        super(context, 0, words);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.number_item, parent, false);
        }
        Word currentWord = (Word) getItem(position);

        TextView numberView = listItemView.findViewById(R.id.number_id);
        TextView translatedNumberView = listItemView.findViewById(R.id.translated_number_id);
        ImageView numberImage = listItemView.findViewById(R.id.number_image);
        ImageView playButtonImage = listItemView.findViewById(R.id.play_button);

        numberView.setText(currentWord.getNumber());
        translatedNumberView.setText(currentWord.getTranslatedNumber());
        numberImage.setImageResource(currentWord.getNumberImage());

        mediaPlayer = MediaPlayer.create(getContext(), currentWord.getSound());
        playButtonImage.setOnClickListener(v->{
            if(null == mediaPlayer) {
                mediaPlayer = MediaPlayer.create(getContext(), currentWord.getSound());
            }
            if(mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                playButtonImage.setImageResource(R.drawable.play_button_white);
                playButtonImage.setPadding(0,0,0,0);

            } else {
                mediaPlayer.start();
                playButtonImage.setImageResource(R.drawable.pause_button_white);
                playButtonImage.setPadding(25,25,25,25);
                mediaPlayer.setOnCompletionListener( c ->{
                    System.out.println("SOUND FOR " + currentWord.getNumber() + " IS COMPLETED. ---------------------");
                    playButtonImage.setImageResource(R.drawable.play_button_white);
                    playButtonImage.setPadding(0,0,0,0);
                    mediaPlayer.release();
                    mediaPlayer = null;
                });
            }
        });
        return listItemView;
    }
}
