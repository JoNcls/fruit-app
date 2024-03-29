package com.example.fruitapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fruitapp.BuyFruitActivity;
import com.example.fruitapp.R;
import com.example.fruitapp.helper.DBHelper;
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

        View view = layoutInflater.inflate(R.layout.rv_fruit, parent, false);
        FruitAdapter.ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        try{
            Fruit fruit = fruitsList.get(position);

            TextView tV_FruitID = holder.tV_FruitID;
            TextView tV_FruitCode = holder.tV_FruitCode;
            TextView tV_FruitName = holder.tV_FruitName;
            TextView tV_FruitPrice = holder.tV_FruitPrice;

            tV_FruitID.setText(String.valueOf(fruit.getID()));
            tV_FruitCode.setText(fruit.getCode());
            tV_FruitName.setText(fruit.getName());
            tV_FruitPrice.setText(String.valueOf(fruit.getPrice()));
        } catch (Exception ex){
            Log.d("QiuQiu", "onBindViewHolder: " + ex.toString());
        }
    }

    @Override
    public int getItemCount() {
        return fruitsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView tV_FruitID, tV_FruitCode, tV_FruitName, tV_FruitPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            try{
                itemView.setOnClickListener(this);

                tV_FruitID = (TextView) itemView.findViewById(R.id.tV_FruitID);
                tV_FruitCode = (TextView) itemView.findViewById(R.id.tV_FruitCode);
                tV_FruitName = (TextView) itemView.findViewById(R.id.tV_FruitName);
                tV_FruitPrice = (TextView) itemView.findViewById(R.id.tV_FruitPrice);
            } catch (Exception ex){
                Log.d("QiuQiu", "ViewHolder: " + ex.toString());
            }
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), BuyFruitActivity.class);
            intent.putExtra("FruitID", Integer.parseInt(tV_FruitID.getText().toString()));
            intent.putExtra("FruitName", tV_FruitName.getText().toString());
            view.getContext().startActivity(intent);
        }
    }
}
