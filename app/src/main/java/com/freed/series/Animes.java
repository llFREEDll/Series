package com.freed.series;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.freed.series.utility.FirebaseHelper;

public class Animes extends AppCompatActivity {

    private FirebaseHelper firebaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animes);
        getSupportActionBar().hide();

        findViewById(R.id.cardView_anime_Add).setOnClickListener(v -> {



        });
    }
}