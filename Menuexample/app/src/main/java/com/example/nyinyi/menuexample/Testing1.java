package com.example.nyinyi.menuexample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Testing1 extends AppCompatActivity {

    private static EditText name;
    private static EditText nrc;
    private static EditText age;
    private static EditText phone;
    private static EditText address;
    private static Button btnsubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btnSubmitClick();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void btnSubmitClick(){
        name=(EditText)findViewById(R.id.txt1);
        nrc=(EditText)findViewById(R.id.txt2);
        age=(EditText)findViewById(R.id.txt3);
        phone=(EditText)findViewById(R.id.txt4);
        address=(EditText)findViewById(R.id.txt5);
        btnsubmit=(Button)findViewById(R.id.btn1);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                final String MY_PREFERENCE_NAME="my_preference";
                SharedPreferences.Editor editor=getSharedPreferences(MY_PREFERENCE_NAME,MODE_PRIVATE).edit();
                editor.putString("name",name.getText().toString());
                editor.putString("nrc",nrc.getText().toString());
                editor.putString("age",age.getText().toString());
                editor.putString("phone",phone.getText().toString());
                editor.putString("address",address.getText().toString());
                editor.commit();
                */
                Intent myIntent=new Intent(getApplicationContext(),Testing2.class);
                myIntent.putExtra("name",name.getText().toString());
                myIntent.putExtra("nrc",nrc.getText().toString());
                myIntent.putExtra("age",age.getText().toString());
                myIntent.putExtra("phone",phone.getText().toString());
                myIntent.putExtra("address",address.getText().toString());
                startActivity(myIntent);

                Toast.makeText(getApplicationContext(), "Registration have been saved!", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
