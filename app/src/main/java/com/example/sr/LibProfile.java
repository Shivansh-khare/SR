package com.example.sr;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sr.Models.issued;
import com.example.sr.adapters.Issued_books_adapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashSet;

public class LibProfile extends AppCompatActivity {
    ImageView cover,prof;
    TextView name,fine;
    RecyclerView rv_issued;
    DatabaseReference mRef;
    ArrayList<issued> lst;
    Issued_books_adapter madapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lib_profile);

        cover = findViewById(R.id.lib_cover);
        prof = findViewById(R.id.profile_image);
        name = findViewById(R.id.TV_lib_prof_name);
        fine = findViewById(R.id.TV_fine);
        mRef = FirebaseDatabase.getInstance().getReference();
        rv_issued = findViewById(R.id.rv_issued_books);
        lst = new ArrayList<>();

        rv_issued.setLayoutManager(new LinearLayoutManager(this));
        madapter = new Issued_books_adapter(lst);
        rv_issued.setAdapter(madapter);
        getSupportActionBar().hide();

        mRef.child("users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("purl_square").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Glide.with(prof.getContext()).load(snapshot.getValue()).into(prof);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mRef.child("users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Full_name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                name.setText(snapshot.getValue().toString().trim());
                madapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mRef.child("users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Fine").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                fine.setText("Fine: \u20B9"+snapshot.getValue().toString().trim());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        mRef.child("users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Issued_books").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                lst.add(new issued(snapshot.getKey(),snapshot.getValue().toString().trim()));
                madapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        Glide.with(this).load("https://i.pinimg.com/originals/1e/4c/23/1e4c23b61e5d835705526e1ea09864b0.jpg").into(cover);
    }
}