package com.example.nyinyi.notificationexamples;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.PendingIntent;

public class createnotification extends Activity implements OnClickListener {

    NotificationManager notificationManager;
    final int notificationId=12345;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createnotification);

        findViewById(R.id.btn_create).setOnClickListener(this);
        findViewById(R.id.btn_cancel).setOnClickListener(this);
    }

    @SuppressLint("New api")
    public void createBigNotification(View view) {

        Intent intent = new Intent(this, cancelnotification.class);
        intent.putExtras("callerID", "main");
        intent.putExtras("notificationID", notificationId);

        PendingIntent pintent = PendingIntent.getActivity(this, 0, intent, 0);
        PendingIntent pintent1 = makePendingIntent(cancelnotification1.class, "Action1");
        PendingIntent pintent2 = makePendingIntent(cancelnotification2.class,"Action2");
        PendingIntent pintent3 = makePEndingIntent(cancelnotification3.class,"Action3");

        Bitmap mybitmap = BitmapFactory.decodeResource(getResources(), drawable.star);

        Notification.Builder basenotification = new Notification.Builder(this)
                .setContentTitle("Title .............")
                .setContentText("Text....................")
                .setTicker("Ticker..................")
                .addAction(drawable.star1,"Action1",pintent1)
                .addAction(drawable.star1,"Action2",pintent2)
                .addAction(drawable.star1,"ACtion3",pintent3)
                .setSmallIcon(R.drawable.star1)
                .setLargeIcon(mybitmap)
                .setContentIntent(pintent);



    }
}
