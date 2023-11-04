package com.example.fruitapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.fruitapp.adapter.FruitAdapter;
import com.example.fruitapp.model.Fruit;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Fruit> fruitsList = new ArrayList<Fruit>();

    private FruitAdapter fruitAdapter;

    private RecyclerView rv_fruits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 1; i <= 5; i++){
            int Price = (int) (Math.random() * 1000) * 1000;

            String Name = "Apple " + i;

            Fruit fruit = new Fruit(i, Name, Price, "", "");
            fruitsList.add(fruit);
        }

        fruitAdapter = new FruitAdapter(fruitsList);

        rv_fruits = (RecyclerView) findViewById(R.id.rV_fruits);
        rv_fruits.setAdapter(fruitAdapter);
        rv_fruits.setLayoutManager(new LinearLayoutManager(this));
    }
}