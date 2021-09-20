package com.gerard.actividad_evaluada;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.gerard.actividad_evaluada.Adapter.PizzaAdapter;

public class Recetas_Activity extends AppCompatActivity {
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recetas);

        recycler = findViewById(R.id.recycler);

        recycler.setLayoutManager(new LinearLayoutManager(this));

        PizzaAdapter adapter = new PizzaAdapter(MainActivity.pizzas);
        recycler.setAdapter(adapter);
    }
}