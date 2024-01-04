package com.example.fruitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.fruitapp.helper.DBHelper;

public class SplashScreenActivity extends AppCompatActivity {

    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        dbHelper = new DBHelper(this);
        dbHelper.onStartApp();
        dbHelper.Register("Admin", "Admin12345");

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}