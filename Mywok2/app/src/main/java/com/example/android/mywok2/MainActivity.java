package com.example.android.mywok2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView numbers_button = findViewById(R.id.numbers_button);
        TextView family_button = findViewById(R.id.family_button);
        TextView colors_button = findViewById(R.id.colors_button);
        TextView phrases_button = findViewById(R.id.phrases_button);

        numbers_button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, NumbersActivity.class);
            startActivity(intent);
        });

        family_button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FamilyActivity.class);
            startActivity(intent);
        });

        colors_button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ColorsActivity.class);
            startActivity(intent);
        });

        phrases_button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PhrasesActivity.class);
            startActivity(intent);
        });
    }
}
