package com.example.nyinyi.myproject;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
 * Created by SMM on 10/12/2017.
 */

public class SelectDB extends AsyncTask<String, Void, String> {

    Context context;
    AlertDialog alertDialog;
    ArrayAdapter<String> arrayAdapter;
    String[] data;
    SelectDB(Context ctnx){
        context=ctnx;
    }

    @Override
    protected String doInBackground(String... params) {

        try {
            String type=params[0];
            if(type.equals("search")) {

                String name=params[1];

                URL url = new URL("http://10.110.23.103:81/selectlist.php");
                HttpURLConnection httpURLConnection;
                httpURLConnection=(HttpURLConnection)url.openConnection();

                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

                String post_data= URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"iso_8859_1");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso_8859_1"));
                String line="";
                String result="";
                StringBuilder stringBuilder=new StringBuilder();
                while ((line=bufferedReader.readLine())!=null){
                   stringBuilder.append(line);
                }

                result=stringBuilder.toString();
                inputStream.close();
                //return result;

                try {
                    JSONArray jsonArray=new JSONArray(result);
                    JSONObject jsonObject=null;

                    data=new String[jsonArray.length()];

                    for(int i=0;i<jsonArray.length();i++){
                        jsonObject=jsonArray.getJSONObject(i);
                        data[i]=jsonObject.getString("name");
                        data[i]+=jsonObject.getString("nrc")+"\n";
                        data[i]+=jsonObject.getString("age")+"\n";
                        data[i]+=jsonObject.getString("phone")+"\n";
                        data[i]+=jsonObject.getString("address")+"\n";
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog=new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Search Status!");

    }

    @Override
    protected void onPostExecute(String result) {
       alertDialog.setMessage("Res:"+result);
        alertDialog.show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
