package com.example.carrent;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ThirdScreen extends Activity {

    RecyclerView recyclerView;
    RecyclerView.Adapter programManager;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_screen);

    }

    @Override
    protected void onStart() {
        recyclerView = findViewById(R.id.third_recycler);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        programManager = new ThirdScreenAdapter();
        recyclerView.setAdapter(programManager);
        super.onStart();
    }

}
