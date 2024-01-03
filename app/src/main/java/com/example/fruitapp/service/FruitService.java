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
import com.example.fruitapp.model.Fruit;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class FruitService {
    public ArrayList<Fruit> findAllFruits(Context context){
        ArrayList<Fruit> fruitArrayList = new ArrayList<Fruit>();

        RequestQueue queue = Volley.newRequestQueue(context);

        String url = "https://ec.europa.eu/agrifood/api/fruitAndVegetable/products";

        JsonArrayRequest stringRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            Gson gson = new Gson();

                            for (int i = 0; i < response.length(); i++){
                                Fruit fruit = gson.fromJson(response.getString(i), Fruit.class);
                                fruit.setID(i);
                                fruit.setPrice(GeneratePrice());
                                fruitArrayList.add(fruit);
                            }
                        } catch (JSONException e) {
                            Log.d("QiuQiu", "JSONException: ");
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

        queue.add(stringRequest);

        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return fruitArrayList;
    }

    private int GeneratePrice(){
        Random random = new Random();
        return random.nextInt(9001) * 100 + 10000;
    }
}