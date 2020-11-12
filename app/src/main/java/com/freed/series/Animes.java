package com.freed.series;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.freed.series.interfaces.Nombre;
import com.freed.series.utility.FirebaseHelper;

import java.util.HashSet;
import java.util.List;

public class Animes extends AppCompatActivity implements Nombre {

    private FirebaseHelper firebaseHelper = new FirebaseHelper();
    private ListView listView_listaAnimes;
    private EditText editText_animes;
    private ArrayAdapter<String> stringArrayAdapter;
    private List<String> listaanimes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animes);
        getSupportActionBar().hide();

        listView_listaAnimes = findViewById(R.id.ListView_Animes);
        editText_animes = findViewById(R.id.editTextTextPersonName_animes);

        firebaseHelper.GetAnime(getApplicationContext(),Animes.this);
        findViewById(R.id.cardView_anime_Add).setOnClickListener(v -> {

            firebaseHelper.SetAnime(editText_animes.getText().toString(),Animes.this);
            listaanimes.add(editText_animes.getText().toString());
            stringArrayAdapter.notifyDataSetChanged();

        });
    }

    @Override
    public void getAll(List<String> nombresLista) {
        listaanimes = nombresLista;
        stringArrayAdapter = new ArrayAdapter<>(Animes.this,android.R.layout.simple_list_item_1,nombresLista);
        listView_listaAnimes.setAdapter(stringArrayAdapter);
    }
}