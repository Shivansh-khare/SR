package com.example.sr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HomePage extends AppCompatActivity {
    ImageButton Lib, Acc, Trans, Direct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Lib=findViewById(R.id.imageButton_Lib);
        Acc=findViewById(R.id.imageButton_Acc);
        Trans=findViewById(R.id.imageButton_trans);
        Direct=findViewById(R.id.imageButton_Direct);

        Lib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this, Library_Activity.class));
            }
        });

        Acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this, Accounts_activity.class));
            }
        });

        Trans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this,Trans_activity.class));
            }
        });

        Direct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this,directory.class));

            }
        });

    }
}