package com.freed.series.utility;


import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.freed.series.interfaces.Nombre;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class FirebaseHelper {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public void SetAnime(String anime , Context context){
        Map<String, Object> data = new HashMap<>();
        data.put("name", anime);

        db.collection("animes").document(UUID.randomUUID().toString())
                .set(data)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(context,"Agregado" , Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(context,"Error" , Toast.LENGTH_LONG).show();
                    }
                });

    }public void GetAnime(final Context context , Nombre nombre){

        final List<String> proyectosLista = new ArrayList<>();

        db.collection("animes")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {

                                proyectosLista.add((String) document.get("name"));
                            }
                            nombre.getAll(proyectosLista);
                        } else {

                            Toast.makeText(context,"Error al conectar a la base de datos anime",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }


}
