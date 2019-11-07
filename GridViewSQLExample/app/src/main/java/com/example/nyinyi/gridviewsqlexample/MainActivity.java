package com.example.nyinyi.gridviewsqlexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridView;

import com.example.nyinyi.gridviewsqlexample.mMySQL.Downloader;

public class MainActivity extends AppCompatActivity {
    final static String urlAddress="http://10.110.23.103:81/selectlist.php";
    private GridView gv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        gv=(GridView)findViewById(R.id.gv);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               new Downloader(MainActivity.this,urlAddress,gv).execute();
            }
        });
    }
}
