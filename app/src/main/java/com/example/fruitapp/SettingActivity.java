package com.example.fruitapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SettingActivity extends AppCompatActivity {

    Button reportBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        reportBtn = (Button) findViewById(R.id.report_btn);
        reportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reportIntent();
            }
        });
    }

    public void reportIntent(){
        Intent reportIntent =  new Intent(SettingActivity.this, ReportFragment.class);
        startActivity(reportIntent);
    }

}
