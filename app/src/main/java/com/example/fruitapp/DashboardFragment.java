package com.example.fruitapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fruitapp.adapter.DashboardAdapter;
import com.example.fruitapp.adapter.FruitAdapter;
import com.example.fruitapp.helper.DBHelper;
import com.example.fruitapp.model.Fruit;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {
    private DBHelper dbHelper;

    private FruitAdapter fruitAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, null);

        dbHelper = new DBHelper(getActivity());

        ArrayList<Fruit> fruitArrayList = dbHelper.GetFruitsList();

        fruitAdapter = new FruitAdapter(fruitArrayList);

        RecyclerView rv_fruits = (RecyclerView) view.findViewById(R.id.rv_fruits);

        rv_fruits.setAdapter(fruitAdapter);
        rv_fruits.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }
}
