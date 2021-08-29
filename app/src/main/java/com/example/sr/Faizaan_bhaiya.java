package com.example.sr;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.sr.Models.interest_model;
import com.example.sr.adapters.Interest_adapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Faizaan_bhaiya extends AppCompatActivity {
    Button call,msg;
    EditText etmsg;
    FloatingActionButton fbtn;
    private static final int PERMISSION_SEND_SMS = 123;
    DatabaseReference mRef;

    RecyclerView rv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faizaan_bhaiya);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getIntent().getStringExtra("name"));

        mRef = FirebaseDatabase.getInstance().getReference(getIntent().getStringExtra("path"));

        call=findViewById(R.id.button_call_faizan);
        msg=findViewById(R.id.button2_message);
        ImageView iv = findViewById(R.id.profile_image);
        TextView tv_name = findViewById(R.id.Teacher_name);
        TextView title = findViewById(R.id.teacher_title);
        etmsg = findViewById(R.id.ETmsg);
        fbtn = findViewById(R.id.floatingActionButton);
        rv = findViewById(R.id.rv_faiz);

        rv.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<interest_model> lst = new ArrayList<>();
        Interest_adapter myadapter = new Interest_adapter(lst);
        rv.setAdapter(myadapter);

        mRef.child("Interests").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                lst.add(new interest_model(snapshot.getKey().toString().trim(),Float.parseFloat(snapshot.getValue().toString().trim())));
                myadapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                lst.add(new interest_model(snapshot.getKey().toString().trim(),Float.parseFloat(snapshot.getValue().toString().trim())));
                myadapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().hide(fragmentManager.findFragmentById(R.id.fragment)).commit();

        mRef.child("purl").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Glide.with(Faizaan_bhaiya.this).load(snapshot.getValue()).into(iv);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        tv_name.setText(mRef.getKey().toString());
        mRef.child("HeadLine").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                title.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRef.child("mob").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+snapshot.getValue())));
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragmentManager.beginTransaction().show(fragmentManager.findFragmentById(R.id.fragment)).commit();
            }
        });
        fbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestSmsPermission();
                fragmentManager.beginTransaction().hide(fragmentManager.findFragmentById(R.id.fragment)).commit();
            }
        });
    }
    private void requestSmsPermission() {

        // check permission is given
        if (ContextCompat.checkSelfPermission(Faizaan_bhaiya.this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            // request permission (see result in onRequestPermissionsResult() method)
            ActivityCompat.requestPermissions(Faizaan_bhaiya.this,
                    new String[]{Manifest.permission.SEND_SMS},
                    PERMISSION_SEND_SMS);
        } else {
            // permission already granted run sms send
            sendSms();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_SEND_SMS: {

                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted
                    sendSms();
                } else {
                    // permission denied
                }
                return;
            }
        }
    }
    private void sendSms(){

        mRef.child("mob").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String msg_txt = msg.getText().toString();

                if(!msg_txt.equals("")) {
                //Get the SmsManager instance and call the sendTextMessage method to send message
                    SmsManager sms=SmsManager.getDefault();
//                    sms.sendTextMessage(snapshot.getValue().toString().trim(), null, msg_txt, null,null);
                Toast.makeText(Faizaan_bhaiya.this,msg_txt,Toast.LENGTH_SHORT).show();
                Toast.makeText(Faizaan_bhaiya.this,"message send",Toast.LENGTH_SHORT).show();}
                else
                {
                    Toast.makeText(Faizaan_bhaiya.this,"Can not send empty msg",Toast.LENGTH_SHORT).show();
                }
//            }


    }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}