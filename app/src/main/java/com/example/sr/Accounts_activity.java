package com.example.sr;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.widget.TextView;

public class Accounts_activity extends AppCompatActivity {
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts_activity);

        title=findViewById(R.id.textView7);
        title.setPaintFlags(title.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
    }
}