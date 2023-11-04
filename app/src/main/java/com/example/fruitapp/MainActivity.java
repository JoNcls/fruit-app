package com.example.fruitapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.fruitapp.adapter.FruitAdapter;
import com.example.fruitapp.model.Fruit;
import com.example.fruitapp.service.FruitService;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FruitAdapter fruitAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FruitService fruitService = new FruitService();

        ArrayList<Fruit> arrayList = fruitService.findAllFruits(this);

        fruitAdapter = new FruitAdapter(arrayList);

        RecyclerView rv_fruits = (RecyclerView) findViewById(R.id.rv_fruits);

        rv_fruits.setAdapter(fruitAdapter);
        rv_fruits.setLayoutManager(new LinearLayoutManager(this));
    }
}