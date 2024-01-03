package com.example.fruitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fruitapp.helper.DBHelper;
import com.example.fruitapp.model.User;

public class RegisterActivity extends AppCompatActivity {
    private Button loginButton, registerButton;
    private EditText eT_Username, eT_Pass, eT_ConfirmPass;
    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login_register);

        dbHelper = new DBHelper(this);

        eT_Username = (EditText) findViewById(R.id.username_fill);
        eT_Pass = (EditText) findViewById(R.id.password_fill);
        eT_ConfirmPass = (EditText) findViewById(R.id.confirm_password_fill);

        loginButton = (Button) findViewById(R.id.login_page_intent);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginIntent();
            }
        });

        registerButton = (Button) findViewById(R.id.register_submit);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register();
            }
        });
    }

    private void Register(){
        String Username = eT_Username.getText().toString();
        String Pass = eT_Pass.getText().toString();
        String ConfirmPass = eT_ConfirmPass.getText().toString();

        if (Username.isEmpty() || Pass.isEmpty() || ConfirmPass.isEmpty())
        {
            Toast.makeText(this, "Username, Password and Confirm Password are Required", Toast.LENGTH_SHORT).show();
        }
        else if (Pass.equals(ConfirmPass)){
            String checkSameUsername = dbHelper.GetPassword(Username);
            if (checkSameUsername.equals("Username not found")){
                dbHelper.Register(Username, Pass);
                eT_Username.setText("");
                eT_Pass.setText("");
                eT_ConfirmPass.setText("");
                Toast.makeText(this, "Success Register, please Login!", Toast.LENGTH_SHORT).show();
            }
            else
            {
                eT_Pass.setText("");
                eT_ConfirmPass.setText("");
                Toast.makeText(this, "Username has been used.", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(this, "Password and Confirm Passwod must equal.", Toast.LENGTH_SHORT).show();
        }
    }

    public void loginIntent(){
        Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(loginIntent);
    }
}