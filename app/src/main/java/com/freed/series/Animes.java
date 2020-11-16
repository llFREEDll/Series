package com.freed.series;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.freed.series.interfaces.Nombre;
import com.freed.series.interfaces.Total;
import com.freed.series.utility.FirebaseHelper;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Animes extends AppCompatActivity implements Nombre , Total {

    private FirebaseHelper firebaseHelper = new FirebaseHelper();
    private ListView listView_listaAnimes;
    private EditText editText_animes;
    private ArrayAdapter<String> stringArrayAdapter;
    private List<String> listaanimes;
    private TextView textView_total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animes);
        Objects.requireNonNull(getSupportActionBar()).hide();

        listView_listaAnimes = findViewById(R.id.ListView_Animes);
        editText_animes = findViewById(R.id.editTextTextPersonName_animes);
        textView_total = findViewById(R.id.textView_animes);


        firebaseHelper.GetList(getApplicationContext(),Animes.this , Animes.this, "animes");
        findViewById(R.id.cardView_anime_Add).setOnClickListener(v -> {

            firebaseHelper.SetFB(editText_animes.getText().toString(),"animes" ,Animes.this);
            firebaseHelper.GetList(getApplicationContext(),Animes.this , Animes.this, "animes");

        });
    }

    @Override
    public void getAll(List<String> nombresLista) {
        Collections.sort(nombresLista);
        listaanimes = nombresLista;
        stringArrayAdapter = new ArrayAdapter<>(Animes.this,android.R.layout.simple_list_item_1,nombresLista);
        listView_listaAnimes.setAdapter(stringArrayAdapter);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void getAll(String total) {

        textView_total.setText("Total: " + total);


    }
}