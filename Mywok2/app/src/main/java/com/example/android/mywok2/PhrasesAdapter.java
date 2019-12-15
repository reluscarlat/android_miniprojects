package com.example.android.mywok2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PhrasesAdapter extends ArrayAdapter<Phrase> {
    public PhrasesAdapter(Context context, List<Phrase> phrases) {
        super(context, 0, phrases);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View phraseView = convertView;
        if(convertView == null) {
            phraseView = LayoutInflater.from(getContext()).inflate(R.layout.phrase_item, parent, false);
        }
        TextView phraseName = phraseView.findViewById(R.id.phrase_name);
        TextView translatedPhrase = phraseView.findViewById(R.id.phrase_translated);

        phraseName.setText(getItem(position).getPhraseName());
        translatedPhrase.setText(getItem(position).getTranslatedPhrase());

        return phraseView;
    }
}
