package com.freed.series;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.freed.series.interfaces.Nombre;
import com.freed.series.interfaces.Total;
import com.freed.series.utility.FirebaseHelper;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Peliculas extends AppCompatActivity implements Nombre, Total {

    private FirebaseHelper firebaseHelper = new FirebaseHelper();
    private ListView listView_listapeliculas;
    private EditText editText_peliculas;
    private ArrayAdapter<String> stringArrayAdapter;
    private List<String> listapeliculas;
    private TextView textView_total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peliculas);

        Objects.requireNonNull(getSupportActionBar()).hide();

        listView_listapeliculas = findViewById(R.id.ListView_peliculas);
        editText_peliculas = findViewById(R.id.editTextTextPersonName_peliculas);
        textView_total = findViewById(R.id.textView_peliculas);


        firebaseHelper.GetList(getApplicationContext(),Peliculas.this , Peliculas.this,"peliculas");
        findViewById(R.id.cardView_pelicula_Add).setOnClickListener(v -> {

            firebaseHelper.SetFB(editText_peliculas.getText().toString(),"peliculas" ,Peliculas.this);
            firebaseHelper.GetList(getApplicationContext(),Peliculas.this , Peliculas.this,"peliculas");

        });
    }

    @Override
    public void getAll(List<String> nombresLista) {

        Collections.sort(nombresLista);
        listapeliculas = nombresLista;
        stringArrayAdapter = new ArrayAdapter<>(Peliculas.this,android.R.layout.simple_list_item_1,nombresLista);
        listView_listapeliculas.setAdapter(stringArrayAdapter);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void getAll(String total) {

        textView_total.setText("Total: " + total);

    }
}