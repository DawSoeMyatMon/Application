package com.example.nyinyi.menuexample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Testing2 extends AppCompatActivity {

    private static TextView name;
    private static TextView nrc;
    private static TextView age;
    private static TextView phone;
    private static TextView address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        name=(TextView)findViewById(R.id.tv1);
        nrc=(TextView)findViewById(R.id.tv2);
        age=(TextView)findViewById(R.id.tv3);
        phone=(TextView)findViewById(R.id.tv4);
        address=(TextView)findViewById(R.id.tv5);

        Intent intent=getIntent();

        String name1=intent.getStringExtra("name");
        String nrc1=intent.getStringExtra("nrc");
        String age1=intent.getStringExtra("age");
        String phone1=intent.getStringExtra("phone");
        String address1=intent.getStringExtra("address");

        name.setText("Name:"+name1.toString());
        nrc.setText("NRC:"+nrc1.toString());
        age.setText("Age:"+age1.toString());
        phone.setText("Phone:"+phone1.toString());
        address.setText("Address:"+address1.toString());


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
