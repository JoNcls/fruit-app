package com.example.fruitapp.helper;

import com.example.fruitapp.model.Fruit;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {
    @GET("products")
    Call<ArrayList<Fruit>> getFruits();
}
