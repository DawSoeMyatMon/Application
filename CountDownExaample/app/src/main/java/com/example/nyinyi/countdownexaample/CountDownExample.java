package com.example.nyinyi.countdownexaample;

import android.icu.text.SimpleDateFormat;
import android.os.Handler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class CountDownExample extends AppCompatActivity {

    private TextView txtDay , txtHour , txtMinute , txtSecond ;
    private TextView tvEventStart ;
    private Handler handler ;
    private Runnable runnable ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down_example);

        txtDay = ( TextView ) findViewById ( R . id .txtDay );
        txtHour = ( TextView ) findViewById ( R . id . txtHour );
        txtMinute = ( TextView ) findViewById ( R . id . txtMinute );
        txtSecond = ( TextView ) findViewById ( R . id . txtSecond );
        tvEventStart = ( TextView ) findViewById ( R . id . tveventStart );
        countDownStart ();
    }

    public void countDownStart () {

        Toast.makeText(getApplicationContext(),"Function Start",Toast.LENGTH_LONG).show();
        handler = new Handler ();
        runnable = new Runnable () {
            @Override
            public void run () {
                Toast.makeText(getApplicationContext(),"Run Start",Toast.LENGTH_LONG).show();
                handler.postDelayed(this,1000);
                try {
                    Toast.makeText(getApplicationContext(),"Try Start",Toast.LENGTH_LONG).show();
                    SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");

                    Date futureDate = dateFormat.parse("2019-5-30");
                    Date currentDate = new Date ();
                    if (! currentDate . after ( futureDate )) {
                        Toast.makeText(getApplicationContext(),"Try If Start",Toast.LENGTH_LONG).show();
                        long diff = futureDate . getTime () - currentDate. getTime ();
                        long days = diff / ( 24 * 60 * 60 * 1000 );
                        diff = days * ( 24 * 60 * 60 * 1000 );
                        long hours = diff / ( 60 * 60 * 1000 );
                        diff = hours * ( 60 * 60 * 1000 );
                        long minutes = diff / ( 60 * 1000 );
                        diff = minutes * ( 60 * 1000 );
                        long seconds = diff / 1000 ;
                        txtDay.setText("Day:");
                        txtDay . setText ( "" + String . format ( "%02d" , days ));
                        txtHour . setText ( "" + String . format ( "%02d" , hours ));
                        txtMinute . setText ( "" + String . format ( "%02d" , minutes ));
                        txtSecond . setText ( "" + String . format ( "%02d" , seconds ));
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Try Else Start",Toast.LENGTH_LONG).show();
                        tvEventStart . setVisibility ( View. VISIBLE );
                        tvEventStart . setText ( "The event started!" );
                        textViewGone ();
                    }
                } catch ( Exception e ) {
                    e . printStackTrace ();
                    Toast.makeText(getApplicationContext(),"Catch Error",Toast.LENGTH_LONG).show();
                }
            }
        };
        handler . postDelayed ( runnable , 1 * 1000 );
    }
    public void textViewGone ()
    {
        findViewById ( R . id . LinearLayout1 ). setVisibility ( View . GONE );
        findViewById ( R . id . LinearLayout2 ). setVisibility ( View . GONE );
        findViewById ( R . id . LinearLayout3 ). setVisibility ( View . GONE );
        findViewById ( R . id . LinearLayout4 ). setVisibility ( View . GONE );
        findViewById ( R . id . textViewheader1 ). setVisibility ( View . GONE );
        findViewById ( R . id . textViewheader2 ). setVisibility ( View . GONE );
    }
}
