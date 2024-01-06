package com.example.fruitapp.service;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.fruitapp.helper.DBHelper;
import com.example.fruitapp.helper.GetDataService;
import com.example.fruitapp.helper.RetrofitHelper;
import com.example.fruitapp.model.Fruit;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;

public class FruitService {
    private ArrayList<Fruit> fruitArrayList = new ArrayList<Fruit>();

    private GetDataService service;
    private Call<ArrayList<Fruit>> call_fruits;

    public void findAllFruits(Context context){
        this.fruitArrayList.add(new Fruit(1, "BAN", "Banana", GeneratePrice()));
        this.fruitArrayList.add(new Fruit(2, "WAT", "Watermelon", GeneratePrice()));
        this.fruitArrayList.add(new Fruit(3, "MEL", "Melon", GeneratePrice()));
        this.fruitArrayList.add(new Fruit(4, "ORA", "Orange", GeneratePrice()));
        this.fruitArrayList.add(new Fruit(5, "DRF", "Dragon Fruit", GeneratePrice()));


        RequestQueue queue = Volley.newRequestQueue(context);

        String url = "https://ec.europa.eu/agrifood/api/fruitAndVegetable/products";

        ArrayList<Fruit> tempFruits = new ArrayList<Fruit>();
        DBHelper dbHelper = new DBHelper(context);

        JsonArrayRequest stringRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            Gson gson = new Gson();

                            for (int i = 0; i < response.length(); i++){
                                Fruit fruit = gson.fromJson(response.getString(i), Fruit.class);
                                fruit.setID(i+6);
                                fruit.setPrice(GeneratePrice());
                                tempFruits.add(fruit);
                                dbHelper.AddFruit(fruit);
                            }
                        } catch (JSONException e) {
                            Log.d("QiuQiu", "JSONException: " + e);
                            throw new RuntimeException(e);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("QiuQiu", "onErrorResponse: " + error.toString());
            }
        }
        );

        this.fruitArrayList.addAll(tempFruits);

        queue.add(stringRequest);
    }

    public void findAllFruitsRetrofit(Context context){
        service = RetrofitHelper.get_retrofit_instance().create(GetDataService.class);
        call_fruits = service.getFruits();

        call_fruits.enqueue(new Callback<ArrayList<Fruit>>() {
            @Override
            public void onResponse(Call<ArrayList<Fruit>> call, retrofit2.Response<ArrayList<Fruit>> response) {
                generate_fruits(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Fruit>> call, Throwable t) {
                Toast.makeText(context, "Maaf, Sepuh, masih pemula.", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void generate_fruits(ArrayList<Fruit> fruits){
        int ID = 6;
        for (Fruit fruit: fruits){
            fruit.setID(ID);
            fruit.setPrice(GeneratePrice());
            ID += 1;
        }
        this.fruitArrayList = fruits;
    }

    public ArrayList<Fruit> GetFruitsList(){
        return this.fruitArrayList;
    }

    private int GeneratePrice(){
        Random random = new Random();
        return random.nextInt(9001) * 100 + 10000;
    }
}