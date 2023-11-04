package com.example.fruitapp.service;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
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

public class FruitService {
    public ArrayList<Fruit> findAllFruits(Context context){
        ArrayList<Fruit> fruitArrayList = new ArrayList<Fruit>();

        RequestQueue queue = Volley.newRequestQueue(context);

        String url = "https://kwpzm9jf-58888.asse.devtunnels.ms/api/fruits";

        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Gson gson = new Gson();
                            JSONArray jsonArray = response.getJSONArray("data");

                            for (int i = 0; i < jsonArray.length(); i++){
                                Fruit fruit = gson.fromJson(jsonArray.getString(i), Fruit.class);
                                fruitArrayList.add(fruit);
                            }
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error", "onErrorResponse: " + error.toString());
            }
        }
        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("X-API-Key", "NmMwMTIxOTMtODQ3Zi00ZWVjLTljOGUtNGM3ZDAwYjdmNzU4");
                return params;
            }
        };

        queue.add(stringRequest);

        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (fruitArrayList.size() == 0){
            Toast.makeText(context, "Hello", Toast.LENGTH_LONG).show();
        } else {
            fruitArrayList.get(0).printLog();
        }

        return fruitArrayList;
    }
}