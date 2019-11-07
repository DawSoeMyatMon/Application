package com.example.nyinyi.progressbarexample;

import android.app.Activity;
import android.app.Notification;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class ProgressBarExample extends Activity {

    ProgressBar bar1;
    ProgressBar bar2;

    TextView msgWorking;
    TextView msgReturned;

    boolean isRunning=false;

    final int MAX_SEC=50;

    int globalIntTest=0;

    Handler handler=new Handler() {
        @Override

        public void handleMessage(Message msg){

            String returnedValue=(String)msg.obj;
            msgReturned.append("\n Returned value:"+returnedValue);

            bar1.incrementProgressBy(2);

            if(bar1.getProgress()==MAX_SEC){
                msgReturned.append("\n Done \n back thred has been stopped");
                isRunning=false;

            }
            if(bar1.getProgress()==bar1.getMax()){
                msgWorking.setText("Done");
                bar1.setVisibility(View.INVISIBLE);
                bar2.setVisibility(View.INVISIBLE);
            }
            else
            {
                msgWorking.setText("Working............."+bar1.getProgress());
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar_example);

        bar1=(ProgressBar)findViewById(R.id.progress1);
        bar1.setProgress(0);
        bar1.setMax(MAX_SEC);

        bar2=(ProgressBar)findViewById(R.id.progress2);

        msgWorking=(TextView)findViewById(R.id.txt_workprogress);
        msgReturned=(TextView)findViewById(R.id.txt_returnvalues);

        globalIntTest=1;

    }

    public void onStart(){
        super.onStart();

        Thread background=new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    for (int i = 0; i < MAX_SEC && isRunning; i++){
                        Thread.sleep(1000);

                    Random rdn = new Random();
                    int localData = (int) rdn.nextInt(1000);
                    String data = "Data:" + globalIntTest + "-" + localData;
                    globalIntTest++;

                    Message msg = handler.obtainMessage(1, (String)data);

                    if (isRunning) {
                        handler.sendMessage(msg);
                    }
                }
                }
                catch(Throwable t){
                    isRunning=false;
                }
            }
        });

        isRunning=true;
        background.start();
    }
        public void onStop() {
            super.onStop();
            isRunning=false;
    }

}
