package com.example.nyinyi.loginexample;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by SMM on 9/22/2017.
 */

public  class BackgroundWorker extends AsyncTask<String,Void,String>{
    Context context;
    AlertDialog alertDialog;
    BackgroundWorker(Context ctnx)
    {
        context = ctnx;
    }
    @Override
    protected String doInBackground(String... params) {
        String result="test";
        String type = params[0];
       // Toast.makeText(context,"Type:"+type,Toast.LENGTH_LONG).show();
        String login_url = "http://localhost:81/login.php";
        if (type.equals("login")) {
            try {
                Toast.makeText(context,"Try start",Toast.LENGTH_LONG).show();

                String user_name = params[1];
                String user_password = params[2];

               // Toast.makeText(context,"UserName:"+user_name,Toast.LENGTH_LONG).show();
                //Toast.makeText(context,"Password:"+user_password,Toast.LENGTH_LONG).show();

               /* Log.e("Type:", type);
                Log.e("Name:", user_name);
                Log.e("Password:", user_password);*/

                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("user_name", "UTF-8")+"="+URLEncoder.encode(user_name, "UTF-8")+"&"+URLEncoder.encode("user_password", "UTF-8")+"="+URLEncoder.encode(user_password, "UTF-8");

          /*  String data = URLEncoder.encode("name", "UTF-8")
                    + "=" + URLEncoder.encode(user_name, "UTF-8");
            data += "&" + URLEncoder.encode("password", "UTF-8") + "="
                    + URLEncoder.encode(user_password, "UTF-8"); */

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String line="";
                String line1="test";
                while (( line = bufferedReader.readLine()) == null) {
                    result+=line1;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
               // Toast.makeText(context,"Try end:",Toast.LENGTH_LONG).show();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    protected void onPreExecute(){

       alertDialog=new AlertDialog.Builder(context).create();
        alertDialog.setTitle("LoginStatus");
    }

    @Override
    protected void onPostExecute(String result){
        alertDialog.setMessage(result);
        alertDialog.show();

    }

    @Override
    protected void onProgressUpdate(Void... values)
    {
        super.onProgressUpdate(values);
    }
}
