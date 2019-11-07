package com.example.nyinyi.notificationexample;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class mainone extends Activity {

    private static Button btnshow;
    private static Button btndelete;
    int notificationId=1;
    NotificationManager notificationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainone);

        btnshow=(Button)findViewById(R.id.btn_show);
        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String serName= Context.NOTIFICATION_SERVICE;
                notificationManager=(NotificationManager)getSystemService(serName);

                int icon=R.drawable.star1;
                String ticketText="1 . My Notification Ticket Text";
                long when= System.currentTimeMillis();

                Notification notification;
                notification=new Notification(icon,ticketText,when);

                String extendedTitle="2 . My Extended Title";
                String extendedText="3 . THis is an extended Text and very important message";

                Intent intent=new Intent(getApplicationContext(),maintwo.class);
                intent.putExtra("extendedText",extendedText);
                intent.putExtra("extendedTitle",extendedTitle);

                PendingIntent lanuchIntent=PendingIntent.getActivity(getApplicationContext(),0,intent,0);

                //notification.setLatestEventinfo(getApplicationContext(),extendedTitle,extendedText,lanuchIntent);

                notificationId=1;
                notificationManager.notify(notificationId,notification);
            }
        });

        btndelete=(Button)findViewById(R.id.btn_delete);
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationId=1;
                notificationManager.cancel(notificationId);
                Toast.makeText(getApplicationContext(), "Cancel Button", Toast.LENGTH_LONG).show();

            }
        });

    }
}
