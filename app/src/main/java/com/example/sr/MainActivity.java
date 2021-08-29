package com.example.sr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    TextView regester;
    EditText user_name, Pass;
    Button login;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        regester=findViewById( R.id.tv_regester );
        user_name=findViewById(R.id.editText_userName);
        Pass=findViewById(R.id.editText2_pass);
        login=findViewById(R.id.button_login);
        mAuth = FirebaseAuth.getInstance();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Welcome");
        actionBar.setDisplayShowTitleEnabled(true);

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null)
        {
            Intent intent = new Intent(MainActivity.this,HomePage.class);
            intent.putExtra("user",currentUser.getUid());
            startActivity(intent);
            this.finish();
        }



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

                if(!uname.isEmpty() && !Password.isEmpty()){
                    mAuth.signInWithEmailAndPassword(uname, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent intent = new Intent(MainActivity.this,HomePage.class);
                                intent.putExtra("user",user.getUid());
                                startActivity(intent);
                                MainActivity.this.finish();
                            }
                            else{
                                    Toast.makeText(MainActivity.this,"can't Login",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

                else{
                    Toast.makeText(MainActivity.this,"Wrong Username or Pasword", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}