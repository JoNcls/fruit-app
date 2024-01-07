package com.example.fruitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fruitapp.helper.DBHelper;

public class BuyFruitActivity extends AppCompatActivity {

    private TextView tV_FruitName, tV_FruitQuantity;
    private ImageView btn_Add, btn_Sub;
    private Button btn_Buy;

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_fruit);

        dbHelper = new DBHelper(this);

        tV_FruitName = findViewById(R.id.tV_FruitName);
        tV_FruitQuantity = findViewById(R.id.tV_FruitQuantity);

        btn_Add = findViewById(R.id.btn_Add);
        btn_Sub = findViewById(R.id.btn_Sub);
        btn_Buy = findViewById(R.id.btn_Buy);

        Intent intent = getIntent();
        int FruitID = intent.getIntExtra("FruitID", 0);
        String FruitName = intent.getStringExtra("FruitName");

        tV_FruitName.setText(FruitName);

        btn_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int Quantity = Integer.parseInt(tV_FruitQuantity.getText().toString());
                Quantity += 1;
                tV_FruitQuantity.setText(String.valueOf(Quantity));
            }
        });

        btn_Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int Quantity = Integer.parseInt(tV_FruitQuantity.getText().toString());
                if (Quantity <= 0){
                    Quantity = 0;
                } else {
                    Quantity -= 1;
                }
                tV_FruitQuantity.setText(String.valueOf(Quantity));
            }
        });

        btn_Buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int Quantity = Integer.parseInt(tV_FruitQuantity.getText().toString());
                    dbHelper.InsertCart(FruitID, dbHelper.GetSession(), Quantity);
                    Toast.makeText(BuyFruitActivity.this, "Success Add to Cart", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(BuyFruitActivity.this, DashboardActivity2.class);
                    startActivity(intent1);
                } catch (Exception ex){
                    Log.d("QiuQiu", "onClick: " + ex.toString());
                }
            }
        });
    }
}