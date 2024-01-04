package com.example.fruitapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fruitapp.adapter.CartAdapter;
import com.example.fruitapp.adapter.FruitAdapter;
import com.example.fruitapp.helper.DBHelper;
import com.example.fruitapp.model.Cart;
import com.example.fruitapp.model.Fruit;

import java.util.ArrayList;

public class CartFragment extends Fragment {
    private DBHelper dbHelper;

    private CartAdapter cartAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, null);

        dbHelper = new DBHelper(getActivity());

        ArrayList<Cart> cartArrayList = dbHelper.GetCart(dbHelper.GetSession());
        Log.d("QiuQiu", "onCreateView: " + cartArrayList.size());

        cartAdapter = new CartAdapter(cartArrayList);

        RecyclerView rv_fruits = (RecyclerView) view.findViewById(R.id.rv_carts);

        rv_fruits.setAdapter(cartAdapter);
        rv_fruits.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }
}
