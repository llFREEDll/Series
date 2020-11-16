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

public class Libros extends AppCompatActivity implements Nombre, Total {

    private FirebaseHelper firebaseHelper = new FirebaseHelper();
    private ListView listView_listaLibros;
    private EditText editText_libros;
    private ArrayAdapter<String> stringArrayAdapter;
    private List<String> listaLibros;
    private TextView textView_total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libros);

        Objects.requireNonNull(getSupportActionBar()).hide();

        listView_listaLibros = findViewById(R.id.ListView_libros);
        editText_libros = findViewById(R.id.editTextTextPersonName_libros);
        textView_total = findViewById(R.id.textView_libros);


        firebaseHelper.GetList(getApplicationContext(),Libros.this , Libros.this,"libros");
        findViewById(R.id.cardView_libro_Add).setOnClickListener(v -> {

            firebaseHelper.SetFB(editText_libros.getText().toString(),"libros" ,Libros.this);
            firebaseHelper.GetList(getApplicationContext(),Libros.this , Libros.this,"libros");

        });
    }

    @Override
    public void getAll(List<String> nombresLista) {

        Collections.sort(nombresLista);
        listaLibros = nombresLista;
        stringArrayAdapter = new ArrayAdapter<>(Libros.this,android.R.layout.simple_list_item_1,nombresLista);
        listView_listaLibros.setAdapter(stringArrayAdapter);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void getAll(String total) {

        textView_total.setText("Total: " + total);

    }
}