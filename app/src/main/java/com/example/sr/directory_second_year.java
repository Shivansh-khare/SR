package com.example.sr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class directory_second_year extends AppCompatActivity {
    Button cs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory_second_year);

        cs=findViewById(R.id.btn_cs);

        cs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(directory_second_year.this,cs_second_yr.class));
            }
        });
    }
}