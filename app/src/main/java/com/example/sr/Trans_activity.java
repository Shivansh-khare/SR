package com.example.sr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Trans_activity extends AppCompatActivity {
    EditText token;
    Button btn_token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans_activity);
        token = findViewById(R.id.editTextNumber_token);
        btn_token = findViewById(R.id.button_token);

        btn_token.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = token.getText().toString().trim();

                if(id.equals("786") ){
                    startActivity( new Intent( Trans_activity.this,Bus_activity.class ) );
                }

                else{
                    Toast.makeText(Trans_activity.this,"Wrong Token, Access Denied", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}