package com.example.fruitapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.fruitapp.adapter.FruitAdapter;
import com.example.fruitapp.model.Fruit;
import com.example.fruitapp.service.FruitService;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button dashboardButton;
    private Button loginButton;
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


        dashboardButton = (Button) findViewById(R.id.dashboard_btn);
        dashboardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dashboardIntent();
            }
        });

        dashboardButton = (Button) findViewById(R.id.dashboard_btn);
        dashboardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dashboardIntent();
            }
        });
        dashboardButton = (Button) findViewById(R.id.dashboard_btn);
        dashboardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dashboardIntent();
            }
        });

    }
    public void dashboardIntent(){
        Intent dashIntent = new Intent(MainActivity.this, DashboardActivity.class);
        startActivity(dashIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navigation_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_dashboard:
                Intent dashboardIntent = new Intent(MainActivity.this, DashboardActivity.class);
                startActivity(dashboardIntent);
                break;
            case R.id.nav_login:
                Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(loginIntent);
                break;
            case R.id.nav_help:
                Toast.makeText(this, "Help", Toast.LENGTH_LONG).show();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}