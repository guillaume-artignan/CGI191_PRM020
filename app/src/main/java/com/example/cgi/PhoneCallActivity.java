package com.example.cgi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.EditText;

public class PhoneCallActivity extends AppCompatActivity {
    TelephonyManager manager ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_call);
        manager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
    }

    public void giveCall(View v){
        EditText et = findViewById(R.id.phone_number);
        String number = et.getText().toString();
        Intent appel = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
        startActivity(appel);
    }
}
