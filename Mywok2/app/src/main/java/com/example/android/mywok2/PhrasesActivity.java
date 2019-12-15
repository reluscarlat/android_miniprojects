package com.example.android.mywok2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        List<Phrase> phrasesList = new ArrayList<>();
        phrasesList.add(new Phrase("aaa","111"));
        phrasesList.add(new Phrase("bbb","222"));
        phrasesList.add(new Phrase("ccc","333"));
        phrasesList.add(new Phrase("ddd","444"));
        phrasesList.add(new Phrase("eee","555"));
        phrasesList.add(new Phrase("fff","666"));
        phrasesList.add(new Phrase("ccc","333"));
        phrasesList.add(new Phrase("ddd","444"));
        phrasesList.add(new Phrase("eee","555"));
        phrasesList.add(new Phrase("fff","666"));
        phrasesList.add(new Phrase("ccc","333"));
        phrasesList.add(new Phrase("ddd","444"));
        phrasesList.add(new Phrase("eee","555"));
        phrasesList.add(new Phrase("fff","666"));

        PhrasesAdapter phrasesAdapter = new PhrasesAdapter(this, phrasesList);
        ListView phrasesListView = findViewById(R.id.phrases_list_view);
        phrasesListView.setAdapter(phrasesAdapter);
    }
}
