package com.example.fruitapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fruitapp.adapter.HelpAdapter;
import com.example.fruitapp.model.FaQ;

import java.util.ArrayList;

public class HelpActivity extends AppCompatActivity {

    private ArrayList<FaQ> faqs = new ArrayList<>();
    private HelpAdapter faqAdapters;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        for (int i=1; i<=20; i++){
            faqs.add(new FaQ("Question", "Test RV"));
        }

        RecyclerView rv_faq = findViewById(R.id.rv_help);
        faqAdapters = new HelpAdapter(faqs);
        rv_faq.setAdapter(faqAdapters);
        rv_faq.setLayoutManager(new LinearLayoutManager(this));
    }
}
