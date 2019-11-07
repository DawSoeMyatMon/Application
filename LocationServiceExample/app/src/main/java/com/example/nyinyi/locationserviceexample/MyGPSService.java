package com.example.nyinyi.locationserviceexample;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;

public class MyGPSService extends Service {
    String GPS_FILTER = "MyGPSLocation";
    Thread serviceThread;
    LocationManager lm;
    GPSListener myLocationListener;
    boolean isRunning = true;

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {

        Log.e("<<MyGpsServcieonStart>>", "i am alive-GPS!");
        serviceThread = new Thread(new Runnable() {
            @Override
            public void run() {

                getGPSFix_Version1();
                getGPSFix_Version2();

            }
        });

        serviceThread.start();
    }

    public void getGPSFix_Version1() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        Criteria criteria = new Criteria();
        String provider = locationManager.getBestProvider(criteria, false);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location = locationManager.getLastKnownLocation(provider);

        if (location != null) {
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();

            Intent intentFilterResponse = new Intent(GPS_FILTER);
            intentFilterResponse.putExtra("latitude", latitude);
            intentFilterResponse.putExtra("longitude", longitude);
            intentFilterResponse.putExtra("provider", provider);

            Log.e(">> GPS_Service <<", provider + " =>Lat:" + latitude + "long:" + longitude);
            sendBroadcast(intentFilterResponse);

        }

    }

    public void getGPSFix_Version2() {
        try {
            Looper.prepare();
            lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

            myLocationListener = new GPSListener();

            long minTime = 0;
            float minDistance = 5;

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, minTime, minDistance, myLocationListener);

            Looper.loop();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();

        Log.e("<<MyService-Destroy>>","I am a dead GPS");
        try{
            lm.removeUpdates(myLocationListener);
            isRunning=false;
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    private class GPSListener implements LocationListener{
        public void onLocationChanged(Location location){

            double latitude=location.getLatitude();
            double longitude=location.getLongitude();

            Intent myFiletrResponse=new Intent(GPS_FILTER);
            myFiletrResponse.putExtra("latitude",latitude);
            myFiletrResponse.putExtra("longitude",longitude);
            myFiletrResponse.putExtra("provider",location.getProvider());

            Log.e("<<GPS Service>>","latitude"+latitude+"longitude"+longitude);
            sendBroadcast(myFiletrResponse);

        }

        public void onProviderDisabled(String provider){

        }

        public void onProviderEnabled(String provider){

        }

        public void onStatusChanged(String provider, int status, Bundle extras){

        }

    };
}