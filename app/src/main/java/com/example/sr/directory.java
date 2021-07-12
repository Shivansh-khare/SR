package com.example.sr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class directory extends AppCompatActivity {
    Button mana_direct, btech_direct, mba_direct, ayu_direct, imba_direct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory2);
        mana_direct= findViewById(R.id.fac_faizan_bhaiya);
        btech_direct= findViewById(R.id.button_second_year);
        mba_direct= findViewById(R.id.button4_mba);
        ayu_direct= findViewById(R.id.button5_ayush);
        imba_direct= findViewById(R.id.button2_imba);

        btech_direct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(directory.this, directory_btech.class));

            }
        });

    }
}