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

import com.example.fruitapp.adapter.DashboardAdapter;
import com.example.fruitapp.adapter.FruitAdapter;
import com.example.fruitapp.helper.DBHelper;
import com.example.fruitapp.model.Fruit;
import com.example.fruitapp.service.FruitService;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button loginButton, registerButton;
    private DashboardAdapter dashboardAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper dbHelper = new DBHelper(this);
        dbHelper.Register("Admin", "Admin1234");

        FruitService fruitService = new FruitService();

        ArrayList<Fruit> arrayList = fruitService.findAllFruits(this);

        dashboardAdapter = new DashboardAdapter(arrayList);

        RecyclerView rv_fruits = (RecyclerView) findViewById(R.id.rv_fruits);

        rv_fruits.setAdapter(dashboardAdapter);
        rv_fruits.setLayoutManager(new LinearLayoutManager(this));

        loginButton = (Button) findViewById(R.id.login_btn);
        registerButton = (Button) findViewById(R.id.register_btn);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginIntent();
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerIntent();
            }
        });
    }
    public void loginIntent(){
        Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(loginIntent);
    }

    public void registerIntent(){
        Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(registerIntent);
    }
}