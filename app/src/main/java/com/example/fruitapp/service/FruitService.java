package com.example.fruitapp.service;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.fruitapp.model.Fruit;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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
                            JSONArray jsonArray = response.getJSONArray("data");

                            for (int i = 0; i <= jsonArray.length(); i++){
                                System.out.println(jsonArray);
                            }
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error.toString());
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

        return fruitArrayList;
    }
}