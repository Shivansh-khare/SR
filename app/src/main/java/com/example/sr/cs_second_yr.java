package com.example.sr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class cs_second_yr extends AppCompatActivity {
    Button faizan_bhaiya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cs_second_yr);

        faizan_bhaiya=findViewById(R.id.fac_faizan_bhaiya);

        faizan_bhaiya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(cs_second_yr.this,Faizaan_bhaiya.class));
            }
        });
    }
}