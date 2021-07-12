package com.example.sr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView regester;
    EditText user_name, Pass;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        regester=findViewById( R.id.tv_regester );
        user_name=findViewById(R.id.editText_userName);
        Pass=findViewById(R.id.editText2_pass);
        login=findViewById(R.id.button_login);

        regester.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( MainActivity.this,Regester_activity.class ) );
            }
        } );

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = user_name.getText().toString().trim();
                String Password = Pass.getText().toString().trim();

                if(uname.equals("shivansh") && Password.equals("12345")){
                    startActivity( new Intent( MainActivity.this,HomePage.class ) );
                }

                else{
                    Toast.makeText(MainActivity.this,"Wrong Username or Pasword", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}