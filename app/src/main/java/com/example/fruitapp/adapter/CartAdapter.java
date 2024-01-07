package com.example.fruitapp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fruitapp.R;
import com.example.fruitapp.helper.DBHelper;
import com.example.fruitapp.model.Cart;
import com.example.fruitapp.model.Fruit;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder>{
    private ArrayList<Cart> cartsList = new ArrayList<Cart>();
    private DBHelper dbHelper;

    public CartAdapter(ArrayList<Cart> cartsList){
        this.cartsList = cartsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        dbHelper = new DBHelper(context);

        View view = layoutInflater.inflate(R.layout.rv_cart, parent, false);
        CartAdapter.ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        try {
            Cart cart = cartsList.get(position);

            TextView tV_FruitName = holder.tV_FruitName;
            TextView tV_Quantity = holder.tV_Quantity;

            Log.d("QiuQiu", "onBindViewHolder: " + cart.getFruitID());

            Fruit tempFruit = dbHelper.GetFruitByID(cart.getFruitID());

            Log.d("QiuQiu", "onBindViewHolder: " + tempFruit.getName());

            tV_FruitName.setText(tempFruit.getName());
            tV_Quantity.setText(String.valueOf(cart.getQuantity()));
        } catch (Exception ex){
            Log.d("QiuQiu", "onBindViewHolder: " + ex.toString());
        }
    }

    @Override
    public int getItemCount() {
        return cartsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView tV_FruitName, tV_Quantity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            tV_FruitName = (TextView) itemView.findViewById(R.id.tV_FruitName);
            tV_Quantity = (TextView) itemView.findViewById(R.id.tV_Quantity);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), String.valueOf(tV_FruitName.getText()).toUpperCase(), Toast.LENGTH_SHORT).show();
        }
    }
}
