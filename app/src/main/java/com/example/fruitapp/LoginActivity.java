package com.example.fruitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
    Button regisButton, forgotButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        regisButton = (Button) findViewById(R.id.register_page_intent);
        regisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regisIntent();
            }
        });
        forgotButton = (Button) findViewById(R.id.forgot_password_btn);
        forgotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                forgotIntent();
            }
        });
    }

    public void regisIntent(){
        Intent regisIntent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(regisIntent);
    }
    public void forgotIntent(){
        Intent forgotIntent = new Intent(LoginActivity.this, ForgotFragment.class);
        startActivity(forgotIntent);
    }


}