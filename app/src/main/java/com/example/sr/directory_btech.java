package com.example.sr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class directory_btech extends AppCompatActivity {
    Button btn_second_yr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory_btech);

        btn_second_yr=findViewById(R.id.button_second_year);

        btn_second_yr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(directory_btech.this,directory_second_year.class));
            }
        });
    }
}