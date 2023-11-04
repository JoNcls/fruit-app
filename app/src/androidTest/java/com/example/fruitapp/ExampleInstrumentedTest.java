package com.example.fruitapp;

import android.content.Context;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.fruitapp.model.Fruit;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.fruitapp", appContext.getPackageName());
    }

    @Test
    public void useVolleyInGoogle(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        RequestQueue queue = Volley.newRequestQueue(appContext);

        String url = "https://kwpzm9jf-58888.asse.devtunnels.ms/api/fruits";

        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        JSONArray jsonArray = null;
                        try {
                            Gson gson = new Gson();
                            jsonArray = response.getJSONArray("data");

                            for (int i = 0; i <= jsonArray.length(); i++){
                                Log.d("Qiu Qiu", "onResponse: " + jsonArray.getString(0));
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

        queue.add(stringRequest);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}