package com.example.fruitapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    Button helpButton, settingButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        helpButton = (Button) findViewById(R.id.help_dashboard_intent);
        settingButton = (Button) findViewById(R.id.setting_dashboard_intent);

        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helpIntent();
            }
        });
        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                settingIntent();
            }
        });
    }

    public void helpIntent(){
        Intent helpIntent = new Intent(DashboardActivity.this, HelpActivity.class);
        startActivity(helpIntent);
    }
    public void settingIntent(){
        Intent settingIntent = new Intent(DashboardActivity.this, SettingActivity.class);
        startActivity(settingIntent);
    }
}
