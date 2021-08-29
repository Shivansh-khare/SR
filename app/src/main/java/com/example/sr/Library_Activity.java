package com.example.sr;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Library_Activity extends AppCompatActivity {
    TextView Tv_req1,Tv_req2,TV_sec,TV_sec2,TV_pro1,TV_pro2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_);

        Tv_req1 = findViewById(R.id.tv_br);
        Tv_req2 = findViewById(R.id.tv_br_disc);

        TV_sec = findViewById(R.id.tv_search);
        TV_sec2 = findViewById(R.id.tv_search_disc);

        TV_pro1 = findViewById(R.id.tv_curr_stat);
        TV_pro2 = findViewById(R.id.tv_curr_disc);

        TV_pro1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Library_Activity.this,LibProfile.class));
            }
        });

        TV_pro2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Library_Activity.this,LibProfile.class));
            }
        });

        Tv_req1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Library_Activity.this,Book_request.class));
            }
        });

        Tv_req2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Library_Activity.this,Book_request.class));
            }
        });

        TV_sec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Library_Activity.this,LibrarySearch.class));
            }
        });

        TV_sec2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Library_Activity.this,LibrarySearch.class));
            }
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Library");
        actionBar.setDisplayShowHomeEnabled(true);
    }
}