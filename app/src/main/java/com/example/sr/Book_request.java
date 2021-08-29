package com.example.sr;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sr.Models.Book_req_model;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Book_request extends AppCompatActivity {
    Button req;
    EditText n,a,p,e,r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_request);
        n=findViewById(R.id.editTextTextPersonName4);
        a=findViewById(R.id.editTextTextPersonName);
        p=findViewById(R.id.editTextTextPersonName3);
        e=findViewById(R.id.editTextTextPersonName2);
        r=findViewById(R.id.editTextTextMultiLine);

        req=findViewById(R.id.button_Rqst);
        ActionBar actionBar=getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Request Book");
        actionBar.setDisplayShowTitleEnabled(true);

        req.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name,author,pub,edition,reason;
                name = n.getText().toString().trim();
                author = a.getText().toString().trim();
                pub = p.getText().toString().trim();
                edition = e.getText().toString().trim();
                reason = r.getText().toString().trim();
                if(!name.equals("") && !author.equals("") && !pub.equals("") && !edition.equals("") && !reason.equals(""))
                {
                    DatabaseReference mRef = FirebaseDatabase.getInstance().getReference("requests");
                    mRef.push().setValue(new Book_req_model(name,author,pub,edition,reason));
                    Toast.makeText(Book_request.this,"Your Request Has Been submitted",Toast.LENGTH_SHORT).show();
                    n.setText("");
                    a.setText("");
                    p.setText("");
                    e.setText("");
                    r.setText("");
                }
                else{
                    Toast.makeText(Book_request.this,"Fill all the fields !!!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}