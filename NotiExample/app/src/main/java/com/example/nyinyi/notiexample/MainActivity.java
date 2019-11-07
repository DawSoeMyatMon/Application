package com.example.nyinyi.notiexample;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    private static Button btnnoti;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnnoti=(Button)findViewById(R.id.btn_noti);
        btnnoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNotification();
                Toast.makeText(getApplicationContext()," start  1 !",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void addNotification(){
        Toast.makeText(getApplicationContext(),"start 2 !", Toast.LENGTH_SHORT).show();
        NotificationCompat.Builder builder=
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.pineapple)
                .setContentTitle("Notification Example")
                .setContentText("This is a test notification");

        Toast.makeText(getApplicationContext(),"start 3 !",Toast.LENGTH_LONG).show();

        Intent intent=new Intent(this,MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);

        Toast.makeText(getApplicationContext(),"start 4 !",Toast.LENGTH_LONG).show();

        NotificationManager notificationManager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,builder.build());

    }
}
