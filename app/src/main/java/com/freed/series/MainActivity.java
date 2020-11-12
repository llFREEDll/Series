package com.freed.series;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        findViewById(R.id.button_animes).setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, Animes.class);
            startActivity(intent);
        });

        findViewById(R.id.button_series).setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, Series.class);
            startActivity(intent);
        });

        findViewById(R.id.button_peliculas).setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, Peliculas.class);
            startActivity(intent);
        });

        findViewById(R.id.button_libros).setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, Libros.class);
            startActivity(intent);
        });
    }
}