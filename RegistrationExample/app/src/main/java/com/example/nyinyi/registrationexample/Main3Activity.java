package com.example.nyinyi.registrationexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void delete(View view){
        Intent intent=new Intent(getApplicationContext(),Delete.class);
        startActivity(intent);
    }

    public void select(View view){
        Intent intent=new Intent(getApplicationContext(),Select.class);
        startActivity(intent);
    }

    public void update(View view){
        Intent intent=new Intent(getApplicationContext(),Update.class);
        startActivity(intent);
    }
}
