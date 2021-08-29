package com.example.sr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Accounts_activity extends AppCompatActivity {
    TextView remain_tf,paid_tf,total_tf,remain_rc,paid_rc,total_rc,remain_lf,paid_lf,total_lf,remain_uf,paid_uf,total_uf,remain_ief,paid_ief,total_ief,remain_hf,paid_hf,total_hf,remain_bf,paid_bf,total_bf,fmane,account_no,roll,cource;
    ImageView iv_prof;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts_activity);
        {
            remain_tf = findViewById(R.id.remain_tf);
            paid_tf = findViewById(R.id.paid_tf);
            total_tf = findViewById(R.id.total_tf);

            remain_rc = findViewById(R.id.remain_rc);
            paid_rc = findViewById(R.id.paid_rc);
            total_rc = findViewById(R.id.total_rc);

            remain_lf = findViewById(R.id.remain_lf);
            paid_lf = findViewById(R.id.paid_lf);
            total_lf = findViewById(R.id.total_lf);

            remain_uf = findViewById(R.id.remain_uf);
            paid_uf = findViewById(R.id.paid_uf);
            total_uf = findViewById(R.id.total_uf);

            remain_ief = findViewById(R.id.remain_ief);
            paid_ief = findViewById(R.id.paid_ief);
            total_ief = findViewById(R.id.total_ief);

            remain_hf = findViewById(R.id.remain_hf);
            paid_hf = findViewById(R.id.paid_hf);
            total_hf = findViewById(R.id.total_hf);

            remain_bf = findViewById(R.id.remain_bf);
            paid_bf = findViewById(R.id.paid_bf);
            total_bf = findViewById(R.id.total_bf);

            fmane = findViewById(R.id.fname);
            roll = findViewById(R.id.tv_rol);
            cource = findViewById(R.id.tv_course);
            account_no = findViewById(R.id.tv_acc_no);

            iv_prof = findViewById(R.id.iv_profile_pic);
        } //findViewbyid

        DatabaseReference mref = FirebaseDatabase.getInstance().getReference("users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());

        {
            mref.child("Full_name").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    fmane.setText(snapshot.getValue().toString().trim());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(Accounts_activity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                }
            });
            mref.child("Course").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    cource.setText(snapshot.getValue().toString());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(Accounts_activity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                }
            });
            mref.child("Account_no").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    account_no.setText(snapshot.getValue().toString());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(Accounts_activity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                }
            });
            mref.child("Roll").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    roll.setText(snapshot.getValue().toString());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(Accounts_activity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                }
            });
        } // account info

        DatabaseReference feeref = mref.child("Fees");

        {
            feeref.child("total_bf").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    total_bf.setText(snapshot.getValue().toString().trim());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(Accounts_activity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                }
            });
            feeref.child("paid_tf").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    paid_tf.setText(snapshot.getValue().toString().trim());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(Accounts_activity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                }
            });
            feeref.child("total_tf").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    total_tf.setText(snapshot.getValue().toString().trim());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(Accounts_activity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                }
            });
            feeref.child("paid_rc").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    paid_rc.setText(snapshot.getValue().toString().trim());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(Accounts_activity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                }
            });
            feeref.child("total_rc").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    total_rc.setText(snapshot.getValue().toString().trim());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(Accounts_activity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                }
            });
            feeref.child("paid_lf").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    paid_lf.setText(snapshot.getValue().toString().trim());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(Accounts_activity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                }
            });
            feeref.child("total_lf").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    total_lf.setText(snapshot.getValue().toString().trim());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(Accounts_activity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                }
            });
            feeref.child("paid_uf").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    paid_uf.setText(snapshot.getValue().toString().trim());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(Accounts_activity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                }
            });
            feeref.child("paid_ief").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    paid_ief.setText(snapshot.getValue().toString().trim());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(Accounts_activity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                }
            });
            feeref.child("total_ief").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    total_ief.setText(snapshot.getValue().toString().trim());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(Accounts_activity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                }
            });
            feeref.child("paid_hf").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    paid_hf.setText(snapshot.getValue().toString().trim());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(Accounts_activity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                }
            });
            feeref.child("paid_bf").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    paid_bf.setText(snapshot.getValue().toString().trim());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(Accounts_activity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                }
            });
            feeref.child("total_uf").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    total_uf.setText(snapshot.getValue().toString().trim());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(Accounts_activity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                }
            });
            feeref.child("total_hf").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    total_hf.setText(snapshot.getValue().toString().trim());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(Accounts_activity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                }
            });
            feeref.child("remain_rc").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    remain_rc.setText(snapshot.getValue().toString().trim());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(Accounts_activity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                }
            });
            feeref.child("remain_tf").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    remain_tf.setText(snapshot.getValue().toString().trim());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(Accounts_activity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                }
            });
            feeref.child("remain_uf").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    remain_uf.setText(snapshot.getValue().toString().trim());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(Accounts_activity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                }
            });
            feeref.child("remain_lf").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    remain_lf.setText(snapshot.getValue().toString().trim());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(Accounts_activity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                }
            });
            feeref.child("remain_ief").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    remain_ief.setText(snapshot.getValue().toString().trim());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(Accounts_activity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                }
            });
            feeref.child("remain_hf").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    remain_hf.setText(snapshot.getValue().toString().trim());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(Accounts_activity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                }
            });
            feeref.child("remain_bf").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    remain_bf.setText(snapshot.getValue().toString().trim());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(Accounts_activity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                }
            });
        } //fee setter

        mref.child("purl").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Glide.with(Accounts_activity.this).load(snapshot.getValue().toString()).into(iv_prof);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Accounts_activity.this, "something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }
}