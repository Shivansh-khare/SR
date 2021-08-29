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
import android.widget.Button;
import android.widget.Toast;

import com.example.sr.adapters.bTech_adapter;
import com.example.sr.adapters.direc_adapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class directory_btech extends AppCompatActivity implements bTech_adapter.a{
    Button btn_second_yr;
    RecyclerView rv;
    ArrayList<String> lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory_btech);
        lst = new ArrayList<>();


        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getIntent().getStringExtra("name"));
//        actionBar.setTitle("1");
        actionBar.setDisplayShowHomeEnabled(true);

        rv = findViewById(R.id.rv_btech_direc);
        rv.setLayoutManager(new LinearLayoutManager(this));
        bTech_adapter myAdapter = new bTech_adapter(lst,this,1);
        rv.setAdapter(myAdapter);

        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference(getIntent().getStringExtra("path"));
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
                Toast.makeText(directory_btech.this,error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onclicked(int pos, int pge, Context context) {
        Intent inte = new Intent(directory_btech.this,directory_second_year.class);
        inte.putExtra("name",lst.get(pos));
        inte.putExtra("path",getIntent().getStringExtra("path")+"/"+lst.get(pos));
        startActivity(inte);
//        Toast.makeText(this,getIntent().getStringExtra("path")+lst.get(pos),Toast.LENGTH_SHORT).show();
    }
}