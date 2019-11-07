package com.example.nyinyi.gridviewsqlexample.mMySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.GridView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/**
 * Created by SMM on 10/9/2017.
 */

public class Downloader extends AsyncTask<Void,Void,String>{

    Context context;
    String urlAddress;
    GridView gv;
    ProgressDialog progressDialog;

    public Downloader(Context context,String urlAddress,GridView gv){
        this.context=context;
        this.urlAddress=urlAddress;
        this.gv=gv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog=new ProgressDialog(context);
        progressDialog.setTitle("Fetch");
        progressDialog.setMessage("Fetching data.........Please wait");
        progressDialog.show();

    }

    @Override
    protected String doInBackground(Void... strings) {
        return this.downloadData();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        progressDialog.dismiss();

        if(s==null){
            Toast.makeText(context,"Unsuccessful,Null Returned",Toast.LENGTH_LONG).show();
        }
        else {
            DataParser dataParser=new DataParser(context,gv,s);
            dataParser.execute();
        }
    }

    public String downloadData() {
        HttpURLConnection httpURLConnection = Connector.connect(urlAddress);
        if(httpURLConnection==null){
            return null;
        }

        InputStream is=null;
        try {
            is=new BufferedInputStream(httpURLConnection.getInputStream());
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(is));
            StringBuffer stringBuffer=new StringBuffer();
            String line=null;

            if(bufferedReader !=null){
                while ((line=bufferedReader.readLine())!=null){
                    stringBuffer.append(line);

                }
                bufferedReader.close();
            }
            else
            {
                return null;
            }
            return stringBuffer.toString();
        }
        catch (Exception e){

        }finally {
            if(is !=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

}
