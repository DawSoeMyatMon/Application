package com.example.nyinyi.menuexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Mainactivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static TextView tview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainactivity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tview=(TextView)findViewById(R.id.tview);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mainactivity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            tview.setTextColor(getResources().getColor(R.color.colorDark));
            tview.setTextSize(30);
            tview.setText("........Test/Testing1.........");
            tview.setBackgroundColor(getResources().getColor(R.color.colorYellow));
            return true;
        }
        else if( id == R.id.action_settings1) {
            tview.setTextColor(getResources().getColor(R.color.colorRed));
            tview.setTextSize(30);
            tview.setText(".........Test/Testing2.........");
            tview.setBackgroundColor(getResources().getColor(R.color.colorGreen));
            return true;
        }
        else if( id == R.id.action_settings2) {
            tview.setTextColor(getResources().getColor(R.color.colorDark));
            tview.setTextSize(30);
            tview.setText(".........Test/Testing3.........");
            tview.setBackgroundColor(getResources().getColor(R.color.colorRed));
            return true;
        }
        else if( id == R.id.action_settings3) {
            tview.setTextColor(getResources().getColor(R.color.colorBlue));
            tview.setTextSize(30);
            tview.setText(".........Test/Testing4..........");
            tview.setBackgroundColor(getResources().getColor(R.color.colorDark));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.testing1) {
            Intent intent=new Intent(getApplicationContext(),Testing1.class);
            startActivity(intent);

           /* tview.setTextColor(getResources().getColor(R.color.colorDark));
            tview.setTextSize(30);
            tview.setText(".............Testing1.............");
            tview.setBackgroundColor(getResources().getColor(R.color.colorYellow));*/

        } else if (id == R.id.testing2) {

            Intent intent=new Intent(getApplicationContext(),Testing2.class);
            startActivity(intent);
            /*
            tview.setTextColor(getResources().getColor(R.color.colorRed));
            tview.setTextSize(30);
            tview.setText("............Testing2............");
            tview.setBackgroundColor(getResources().getColor(R.color.colorGreen));*/

        } else if (id == R.id.testing3) {

            Intent intent=new Intent(getApplicationContext(),Testing3.class);
            startActivity(intent);
            /*
            tview.setTextColor(getResources().getColor(R.color.colorDark));
            tview.setTextSize(30);
            tview.setText("............Testing3............");
            tview.setBackgroundColor(getResources().getColor(R.color.colorRed));*/

        } else if (id == R.id.testing4) {
            Intent intent=new Intent(getApplicationContext(), Testing4.class);
            startActivity(intent);
            /*
            tview.setTextColor(getResources().getColor(R.color.colorDark));
            tview.setTextSize(30);
            tview.setText("............Testing4.............");
            tview.setBackgroundColor(getResources().getColor(R.color.colorBlue));*/

        } else if (id == R.id.testing5) {
            Intent intent=new Intent(getApplicationContext(),Testing5.class);
            startActivity(intent);
            /*
            tview.setTextColor(getResources().getColor(R.color.colorDark));
            tview.setTextSize(30);
            tview.setText(".............Testing5.............");
            tview.setBackgroundColor(getResources().getColor(R.color.colorOrange));*/

        } else if (id == R.id.testing6) {
            Intent intent=new Intent(getApplicationContext(),Testing6.class);
            startActivity(intent);
            /*
            tview.setTextColor(getResources().getColor(R.color.colorRed));
            tview.setTextSize(30);
            tview.setText(".............Testing6............");
            tview.setBackgroundColor(getResources().getColor(R.color.colorGray));*/

        } else if (id == R.id.testing7) {
            Intent intent=new Intent(getApplicationContext(),Testing7.class);
            startActivity(intent);
            /*
            tview.setTextColor(getResources().getColor(R.color.colorRed));
            tview.setTextSize(30);
            tview.setText(".............Testing7.............");
            tview.setBackgroundColor(getResources().getColor(R.color.colorGreenBlue));*/

        } else if (id == R.id.testing8) {
            Intent intent=new Intent(getApplicationContext(),Testing8.class);
            startActivity(intent);
            /*
            tview.setTextColor(getResources().getColor(R.color.colorBlue));
            tview.setTextSize(30);
            tview.setText(".............Testing8.............");
            tview.setBackgroundColor(getResources().getColor(R.color.colorDark));*/
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
