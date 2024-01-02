package com.example.fruitapp.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fruitapp.R;
import com.example.fruitapp.model.Fruit;
import java.util.ArrayList;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder>{
    private ArrayList<Fruit> fruitsList = new ArrayList<Fruit>();

    public FruitAdapter(ArrayList<Fruit> fruitsList){
        this.fruitsList = fruitsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.rv_fruits, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fruit fruit = fruitsList.get(position);

        TextView tV_FruitName = holder.tV_FruitName;
        TextView tV_FruitPrice = holder.tV_FruitPrice;
        ImageView iV_FruitImage = holder.iV_FruitImage;

        tV_FruitName.setText(fruit.getName());
        tV_FruitPrice.setText(String.valueOf(fruit.getPrice()));
        iV_FruitImage.setImageResource(R.drawable.baseline_production_quantity_limits_24);
    }

    @Override
    public int getItemCount() {
        return fruitsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView tV_FruitName, tV_FruitPrice;
        public ImageView iV_FruitImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            tV_FruitName = (TextView) itemView.findViewById(R.id.tV_FruitName);
            tV_FruitPrice = (TextView) itemView.findViewById(R.id.tv_FruitPrice);
            iV_FruitImage = (ImageView) itemView.findViewById(R.id.iV_FruitImage);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
