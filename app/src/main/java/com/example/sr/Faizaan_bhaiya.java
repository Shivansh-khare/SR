package com.example.sr;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Faizaan_bhaiya extends AppCompatActivity {
    Button call,msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faizaan_bhaiya);

        call=findViewById(R.id.button_call_faizan);
        msg=findViewById(R.id.button2_message);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9919523568")));
            }
        });


    }

    public void onsend(View V){
        Intent intent = new Intent(getApplicationContext(),Faizaan_bhaiya.class);
        PendingIntent pi = PendingIntent.getActivity(getApplicationContext(),0,intent,0);

        SmsManager smsManager=SmsManager.getDefault();
        smsManager.sendTextMessage("tel:8887988958",null,"lalit",pi,null);

        Toast.makeText(Faizaan_bhaiya.this,"message send",Toast.LENGTH_SHORT).show();
    }
}