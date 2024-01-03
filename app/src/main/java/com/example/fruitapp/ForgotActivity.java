package com.example.fruitapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fruitapp.helper.DBHelper;

public class ForgotActivity extends AppCompatActivity {
    private EditText eT_Username;
    private Button btn_ForgotPassword, btn_Login;
    private DBHelper dbHelper;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login_forgot_password);

        dbHelper = new DBHelper(this);

        eT_Username = (EditText) findViewById(R.id.eT_Username);
        btn_ForgotPassword = (Button) findViewById(R.id.btn_ForgotPassword);
        btn_Login = (Button) findViewById(R.id.btn_Login);

        btn_ForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ForgotPassword();
            }
        });

        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginIntent();
            }
        });
    }

    private void ForgotPassword(){
        String username = eT_Username.getText().toString();
        if (username.isEmpty()){
            Toast.makeText(this, "Please input your username", Toast.LENGTH_SHORT).show();
        } else {
            eT_Username.setText("");
            String password = dbHelper.GetPassword(username);
            Toast.makeText(this, "Your password: " + password, Toast.LENGTH_SHORT).show();
        }
    }

    private void LoginIntent(){
        Intent loginIntent = new Intent(this, LoginActivity.class);
        startActivity(loginIntent);
    }
}
