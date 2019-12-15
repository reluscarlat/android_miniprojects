package com.example.android.mywok2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

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
    }


}
