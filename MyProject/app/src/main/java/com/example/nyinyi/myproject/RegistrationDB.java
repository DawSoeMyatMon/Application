package com.example.nyinyi.myproject;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

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
 * Created by SMM on 10/11/2017.
 */

public class RegistrationDB extends AsyncTask<String ,Void,String>{

    Context context;
    AlertDialog alertDialog;
    RegistrationDB(Context ctnx){
        context=ctnx;
    }

    @Override
    protected String doInBackground(String... params) {

        String type=params[0];
        if(type.equals("register")){

            try {
                URL url=new URL("http://10.110.23.103:81/register.php");
                String name=params[1];
                String nrc=params[2];
                String age=params[3];
                String phone=params[4];
                String address=params[5];

                HttpURLConnection httpURLConnection;

                httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoOutput(true);

                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

                String post_data= URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")
                        +"&"+URLEncoder.encode("nrc","UTF-8")+"="+URLEncoder.encode(nrc,"UTF-8")
                        +"&"+URLEncoder.encode("age","UTF-8")+"="+URLEncoder.encode(age,"UTF-8")
                        +"&"+URLEncoder.encode("phone","UTF-8")+"="+URLEncoder.encode(phone,"UTF-8")
                        +"&"+URLEncoder.encode("address","UTF-8")+"="+URLEncoder.encode(address,"UTF-8");


                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String line="";
                String result="";
                while ((line=bufferedReader.readLine())!=null){
                    result+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog=new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Registration Dialog Box");
    }

    @Override
    protected void onPostExecute(String result) {
        alertDialog.setMessage(result);
        alertDialog.show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
