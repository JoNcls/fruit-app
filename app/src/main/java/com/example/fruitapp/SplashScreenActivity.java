package com.example.fruitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.example.fruitapp.helper.DBHelper;
import com.example.fruitapp.model.Fruit;
import com.example.fruitapp.service.FruitService;

import java.util.ArrayList;

public class SplashScreenActivity extends AppCompatActivity {

    private DBHelper dbHelper;

    private FruitService fruitService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        dbHelper = new DBHelper(this);
        dbHelper.onStartApp();
        dbHelper.Register("Admin", "Admin12345");

        fruitService = new FruitService();
        fruitService.findAllFruits(SplashScreenActivity.this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ArrayList<Fruit> temp = fruitService.GetFruitsList();
                dbHelper.AddFruits(temp);

                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }
}