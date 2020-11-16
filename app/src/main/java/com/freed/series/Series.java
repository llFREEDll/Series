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

public class Series extends AppCompatActivity implements Nombre, Total {

    private FirebaseHelper firebaseHelper = new FirebaseHelper();
    private ListView listView_listaSeries;
    private EditText editText_series;
    private ArrayAdapter<String> stringArrayAdapter;
    private List<String> listaseries;
    private TextView textView_total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series);

        Objects.requireNonNull(getSupportActionBar()).hide();

        listView_listaSeries = findViewById(R.id.ListView_series);
        editText_series = findViewById(R.id.editTextTextPersonName_series);
        textView_total = findViewById(R.id.textView_series);


        firebaseHelper.GetList(getApplicationContext(),Series.this , Series.this,"series");
        findViewById(R.id.cardView_serie_Add).setOnClickListener(v -> {

            firebaseHelper.SetFB(editText_series.getText().toString(),"series" ,Series.this);
            firebaseHelper.GetList(getApplicationContext(),Series.this , Series.this,"series");

        });
    }

    @Override
    public void getAll(List<String> nombresLista) {
        Collections.sort(nombresLista);
        listaseries = nombresLista;
        stringArrayAdapter = new ArrayAdapter<>(Series.this,android.R.layout.simple_list_item_1,nombresLista);
        listView_listaSeries.setAdapter(stringArrayAdapter);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void getAll(String total) {

        textView_total.setText("Total: " + total);

    }
}