package com.example.sr;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sr.adapters.cs_second_adapter;
import com.example.sr.adapters.secondYear_adapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class cs_second_yr extends AppCompatActivity implements cs_second_adapter.a {
    RecyclerView rv_sec;
    ArrayList<String> lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cs_second_yr);
        lst = new ArrayList<String>();


        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getIntent().getStringExtra("name"));
//        actionBar.setTitle("2");
        actionBar.setDisplayShowHomeEnabled(true);

        rv_sec = findViewById(R.id.rv_cs_sec);
        rv_sec.setLayoutManager(new LinearLayoutManager(this));
        cs_second_adapter myAdapter = new cs_second_adapter(lst,this,1);
        rv_sec.setAdapter(myAdapter);

        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference(getIntent().getStringExtra("path"));
//        Toast.makeText(this,getIntent().getStringExtra("path"),Toast.LENGTH_SHORT).show();
        // Read from the database
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                lst.add(snapshot.getKey());
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                lst.add(snapshot.getKey());
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                lst.add(snapshot.getKey());
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                lst.add(snapshot.getKey());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(cs_second_yr.this,error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onclicked(int pos, int pge, Context context) {
        Intent inte = new Intent(cs_second_yr.this,Faizaan_bhaiya.class);
        inte.putExtra("name",lst.get(pos));
        inte.putExtra("path",getIntent().getStringExtra("path")+"/"+lst.get(pos));
        startActivity(inte);
    }
}