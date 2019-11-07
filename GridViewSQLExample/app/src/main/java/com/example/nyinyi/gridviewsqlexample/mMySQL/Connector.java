package com.example.nyinyi.gridviewsqlexample.mMySQL;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by SMM on 10/9/2017.
 */

public class Connector {

    public static HttpURLConnection connect(String urlAddress){
        try {
            URL url=new URL("http://10.110.23.103:81/selectlist.php");

            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setReadTimeout(200000);
            httpURLConnection.setConnectTimeout(200000);

            return httpURLConnection;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
