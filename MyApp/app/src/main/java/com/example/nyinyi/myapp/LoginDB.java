package com.example.nyinyi.myapp;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by SMM on 10/3/2017.
 */

public class LoginDB extends AsyncTask<String,Void,String>{
    Context context;
    AlertDialog alertDialog;
    LoginDB(Context ctnx){
        context=ctnx;
    }
    @Override
    protected String doInBackground(String... params) {
        String type=params[0];
        String name=params[1];
        String password=params[2];

        try {
            URL url=new URL("http://10.110.23.103:81/logintable.php");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
