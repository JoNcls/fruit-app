package com.example.fruitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fruitapp.helper.DBHelper;

public class LoginActivity extends AppCompatActivity {
    private Button loginButton, regisButton, forgotButton;
    private EditText eT_Username, eT_Password;
    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbHelper = new DBHelper(this);
        Log.d("QiuQiu", "onCreate: LoginActivity: " + dbHelper.GetPassword("Admin"));

        eT_Username = (EditText) findViewById(R.id.username_fill);
        eT_Password = (EditText) findViewById(R.id.password_fill);

        loginButton = (Button) findViewById(R.id.login_submit);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

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

    private void login(){
        String username = eT_Username.getText().toString();
        String password = eT_Password.getText().toString();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Username and Password are Required", Toast.LENGTH_SHORT).show();
        }
        else {
            Boolean valid = dbHelper.login(username, password);

            if (valid){
                dashboardIntent();
            }
            else {
                Toast.makeText(this, "Username and Password are incorrect.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void dashboardIntent(){
        Intent dashIntent = new Intent(LoginActivity.this, DashboardActivity.class);
        startActivity(dashIntent);
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