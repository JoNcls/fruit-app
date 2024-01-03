package com.example.fruitapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fruitapp.R;
import com.example.fruitapp.model.Fruit;

import java.util.ArrayList;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.ViewHolder>{
    private ArrayList<Fruit> fruitsList = new ArrayList<Fruit>();

    public DashboardAdapter(ArrayList<Fruit> fruitsList){
        this.fruitsList = fruitsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.rv_dashboard, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fruit fruit = fruitsList.get(position);

        TextView tV_FruitCode = holder.tV_FruitCode;
        TextView tV_FruitName = holder.tV_FruitName;
        TextView tV_FruitPrice = holder.tV_FruitPrice;

        tV_FruitCode.setText(fruit.getCode());
        tV_FruitName.setText(fruit.getName());
        tV_FruitPrice.setText(String.valueOf(fruit.getPrice()));
    }

    @Override
    public int getItemCount() {
        return fruitsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView tV_FruitCode, tV_FruitName, tV_FruitPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            tV_FruitCode = (TextView) itemView.findViewById(R.id.tV_FruitCode);
            tV_FruitName = (TextView) itemView.findViewById(R.id.tV_FruitName);
            tV_FruitPrice = (TextView) itemView.findViewById(R.id.tV_FruitPrice);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), String.valueOf(tV_FruitName.getText()).toUpperCase(), Toast.LENGTH_SHORT).show();
        }
    }
}
