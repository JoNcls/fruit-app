package com.example.fruitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fruitapp.helper.DBHelper;
import com.example.fruitapp.helper.GetDataService;
import com.example.fruitapp.helper.RetrofitHelper;
import com.example.fruitapp.model.Fruit;
import com.example.fruitapp.service.FruitService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashScreenActivity extends AppCompatActivity {

    private DBHelper dbHelper;

    private TextView tV_App;

    private FruitService fruitService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        tV_App = (TextView) findViewById(R.id.tV_App);

        dbHelper = new DBHelper(this);
        dbHelper.onStartApp();
        dbHelper.Register("Admin", "Admin12345");

        fruitService = new FruitService();

        fruitService.findAllFruits(this);

        ArrayList<Fruit> temp = fruitService.GetFruitsList();

        dbHelper.AddFruits(temp);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}