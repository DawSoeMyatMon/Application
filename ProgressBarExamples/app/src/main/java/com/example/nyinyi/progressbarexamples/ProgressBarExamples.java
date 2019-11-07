package com.example.nyinyi.progressbarexamples;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ProgressBarExamples extends Activity {
    TextView lblTopCaption;
    EditText txtmsg;
    ProgressBar myBara;
    ProgressBar myBarb;

    Button btnDoSomething;
    Button btnDoItAgain;

    int globalVar=0;
    int accum=0;
    boolean isRunning=false;
    long startingMillion=System.currentTimeMillis();

    String PATIENCE="Some important data is being collected \n Please be patient...wait";

    Handler myHandler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lblTopCaption=(TextView)findViewById(R.id.lblTopCaption);
        txtmsg=(EditText)findViewById(R.id.txt_msg);
        txtmsg.setHint("Foreground destination \n Enter some data here");

        myBara=(ProgressBar)findViewById(R.id.myBar1);
        myBarb=(ProgressBar)findViewById(R.id.myBar2);

        btnDoSomething=(Button)findViewById(R.id.btnDoSomethng);
        btnDoItAgain=(Button)findViewById(R.id.btnDoItAgain);

        btnDoItAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onStart();
            }
        });

        btnDoSomething.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Editable text=txtmsg.getText();
                Toast.makeText(getApplicationContext(), "You said \n" +text, Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void onStart(){
        super.onStart();
        txtmsg.setText("'");
        btnDoItAgain.setEnabled(false);

        accum=0;
        myBara.setProgress(0);
        myBara.setMax(100);
        myBara.setVisibility(View.VISIBLE);
        myBarb.setVisibility(View.VISIBLE);

        Thread mythread=new Thread(backgroundTask,"backalias");
                mythread.start();
    }

    private Runnable foregroundRunnable=new Runnable(){
        @Override
        public void run(){
            try{
                lblTopCaption.setText(PATIENCE +"\n Pct Progress:"+accum +
                "\n Global Var:"+globalVar);
                myBara.incrementProgressBy(1);
                accum++;

                if(accum >= myBara.getMax()){
                    lblTopCaption.setText("Backgroun work is Over!");
                    myBara.setVisibility(View.INVISIBLE);
                    myBarb.setVisibility(View.INVISIBLE);
                    btnDoItAgain.setEnabled(false);
                }

            }
            catch (Exception e){
                Log.e("<<Foreground task>>",e.getMessage());
            }
        }
    };

    private Runnable backgroundTask=new Runnable() {
        @Override
        public void run() {
            try{
                for(int i=0;i<20;i++){
                    Thread.sleep(1000);
                    globalVar++;

                    myHandler.post(foregroundRunnable);
                }
            }
            catch (InterruptedException e){
                Log.e("<<foregroundtask>>",e.getMessage());
            }
        }
    };

}
