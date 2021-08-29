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
import android.widget.Toast;

import com.example.sr.adapters.direc_adapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class directory extends AppCompatActivity implements direc_adapter.a {
    ArrayList<String> lst;
    RecyclerView rv;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory2);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Directory");
        actionBar.setDisplayShowHomeEnabled(true);
        lst=new ArrayList<>();

        rv = findViewById(R.id.direc_list);
        rv.setLayoutManager(new LinearLayoutManager(this));
        direc_adapter myAdapter = new direc_adapter(lst,this,1);
        rv.setAdapter(myAdapter);

        myRef = FirebaseDatabase.getInstance().getReference("Dir");
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
                Toast.makeText(directory.this,error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onclicked(int pos, int pge, Context context) {

            switch (pge)
            {
                case 1:
                    Intent intent = new Intent(directory.this,directory_btech.class);
                    intent.putExtra("name",lst.get(pos));
                    intent.putExtra("path","Dir/"+lst.get(pos));
                    startActivity(intent);
                    break;

            }

    }
}