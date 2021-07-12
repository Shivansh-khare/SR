package com.example.sr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Book_request extends AppCompatActivity {
    Button req;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_request);

        req=findViewById(R.id.button_Rqst);

        req.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Book_request.this,"Your Request Has Been submitted",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Book_request.this, Library_Activity.class));
            }
        });
    }
}