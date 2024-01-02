package com.example.fruitapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fruitapp.R;
import com.example.fruitapp.model.FaQ;

import java.util.ArrayList;

public class HelpAdapter extends RecyclerView.Adapter<HelpAdapter.Viewholder> {

    private ArrayList<FaQ> faqs = new ArrayList<>();
    public HelpAdapter(ArrayList<FaQ> faqs){
        this.faqs = faqs;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.rv_help, parent, false);
        Viewholder viewHolder = new Viewholder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        FaQ faq = faqs.get(position);

        TextView txtTitle = holder.txtTitle;
        TextView txtDescription = holder.txtDescription;

        txtTitle.setText(faq.getTitle());
        txtDescription.setText(faq.getDescription());
    }

    @Override
    public int getItemCount() {
        return faqs.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView txtTitle, txtDescription;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            txtTitle = itemView.findViewById(R.id.rv_help_title);
            txtDescription = itemView.findViewById(R.id.rv_help_description);
        }

        @Override
        public void onClick(View view) {
            int position = getLayoutPosition();
            faqs.remove(position);
            notifyDataSetChanged();
        }
    }
}
