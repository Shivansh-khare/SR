package com.example.sr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Library_Activity extends AppCompatActivity {
    TextView Curr_stat, curr_stat_disc, br, br_disc, faq, faq_disc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_);

        Curr_stat=findViewById(R.id.tv_curr_stat);
        curr_stat_disc=findViewById(R.id.tv_curr_disc);
        br=findViewById(R.id.tv_br_disc);
        br_disc=findViewById(R.id.tv_br);
        faq=findViewById(R.id.tv_faq2);
        faq_disc=findViewById(R.id.tv_faq_disc2);

        br.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Library_Activity.this, Book_request.class));
            }
        });

        br_disc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Library_Activity.this, Book_request.class));

            }
        });
    }
}