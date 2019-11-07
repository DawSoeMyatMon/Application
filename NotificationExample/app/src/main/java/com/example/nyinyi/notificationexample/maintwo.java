package com.example.nyinyi.notificationexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class maintwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintwo);

        Intent myIntent = getIntent();
        String msg = myIntent.getStringExtra("extendedTitle") + "\n" +
                myIntent.getStringExtra("extendedText");

        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"Show Button",Toast.LENGTH_LONG).show();
    }
}