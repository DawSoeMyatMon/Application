package com.example.nyinyi.locationserviceexample;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.DeflaterOutputStream;

public class LocationServiceExample extends Activity implements OnClickListener {

    private static TextView txtmsg;
    private static TextView txtcoordinates;
    private static Button btnstartservice;
    private static Button btnstopservice;
    private static Button btndrawmap;

    /***For Location Service***/

    ComponentName service;
    Intent intentmyServiice;
    BroadcastReceiver receiver;
    String GPS_FILTER="cis470.action.GPS_LOCATION";
    double latitude;
    double longitude;
    String provider;

    /***             ***/


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_service_example);

        txtcoordinates = (TextView) findViewById(R.id.txt_coordinate);
        txtmsg = (TextView) findViewById(R.id.txt_msg);

        findViewById(R.id.btn_drawmap).setOnClickListener(this);
        findViewById(R.id.btn_startservice).setOnClickListener(this);
        findViewById(R.id.btn_stopservice).setOnClickListener(this);


        /*** For Location Service ***/

        getMyLocationServiceStarted();

        IntentFilter mylocationFilter = new IntentFilter(GPS_FILTER);
        receiver = new MyMainLocalReceiver();
        registerReceiver(receiver, mylocationFilter);
    }

    public void getMyLocationServiceStarted(){

        txtmsg.append("\n My service started / restarted ?-( See Logcat)");
        intentmyServiice = new Intent(this,MyGPSService.class);
        service=startService(intentmyServiice);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            stopService(intentmyServiice);
            unregisterReceiver(receiver);
            ;
        } catch (Exception e) {
            Log.e("Main Destroy>>>", e.getMessage());
        }

        Log.e("Main Destroy", "Adios");
    }

    private class MyMainLocalReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context localContext,Intent intetFilteredResponse){
            latitude=intetFilteredResponse.getDoubleExtra("latitude",-1);
            longitude=intetFilteredResponse.getDoubleExtra("longitude",-1);
            provider=intetFilteredResponse.getStringExtra("provider");


            Log.e ("Main>>>",Double.toString(latitude));
            Log.e ("Main>>>",Double.toString(longitude));
            Log.e ("Main>>>",provider);

            String msg=provider + "lat :" + Double.toString(latitude) +" "
                    +"lon :" + Double.toString(longitude);

            txtmsg.append("\n"+ msg);
        }

    }

    public void drawGoogleMap(double latitude,double longitude){

        String myGeoCode="geo:" + latitude
                + "," +longitude
                + "?z=15";

        Intent intentViewMap=new Intent(Intent.ACTION_VIEW, Uri.parse(myGeoCode));
        startActivity(intentViewMap);

    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.btn_stopservice){
            try
            {
                Toast.makeText(getApplicationContext(),"Stop Button  Started",Toast.LENGTH_LONG).show();
                stopService(new Intent(intentmyServiice));
                txtmsg.setText("After Stoping Service:" + service.getClassName());
                btnstopservice.setText("Finished");
                btnstopservice.setClickable(false);
            }
            catch(Exception ec){
                ec.printStackTrace();
            }
        }
        else if(v.getId()==R.id.btn_drawmap){
            Toast.makeText(getApplicationContext(),"Draw Button  Started",Toast.LENGTH_LONG).show();
                drawGoogleMap(latitude,longitude);
        }
        else if(v.getId()==R.id.btn_startservice){
            Toast.makeText(getApplicationContext(),"Start Button Started",Toast.LENGTH_LONG).show();
                getMyLocationServiceStarted();
        }

    }

}