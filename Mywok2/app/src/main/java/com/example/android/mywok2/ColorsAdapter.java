package com.example.android.mywok2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class ColorsAdapter extends ArrayAdapter<Color> {
    public ColorsAdapter(Context context, List<Color> colors) {
        super(context, 0, colors);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View colorView = convertView;

        if(colorView == null) {
            colorView = LayoutInflater.from(getContext()).inflate(R.layout.color_item, parent, false);
        }

        TextView colorName = colorView.findViewById(R.id.color_name);
        TextView translatedColor = colorView.findViewById(R.id.translated_color);
        ImageView colorImage = colorView.findViewById(R.id.color_image);

        colorName.setText(getItem(position).getColor());
        translatedColor.setText(getItem(position).getTranslatedColor());
        colorImage.setImageResource(getItem(position).getColorImage());

        return colorView;
    }
}
