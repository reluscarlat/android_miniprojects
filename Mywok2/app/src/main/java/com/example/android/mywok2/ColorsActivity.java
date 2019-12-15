package com.example.android.mywok2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        List<Color> colors = new ArrayList<>();
        colors.add(new Color("alb","white", R.drawable.color_white));
        colors.add(new Color("galben","yellow", R.drawable.color_dusty_yellow));
        colors.add(new Color("rosu","red", R.drawable.color_red));
        colors.add(new Color("negru","black", R.drawable.color_black));
        colors.add(new Color("maro","brown", R.drawable.color_brown));
        colors.add(new Color("verde","green", R.drawable.color_green));
        colors.add(new Color("gri","gray", R.drawable.color_gray));

        ColorsAdapter colorsAdapter = new ColorsAdapter(this, colors);
        ListView colorsListView = findViewById(R.id.colors_list_view);
        colorsListView.setAdapter(colorsAdapter);
    }
}
