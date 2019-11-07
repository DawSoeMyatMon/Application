package com.example.nyinyi.listviewsqlexample;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends Activity {
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    InputStream inputStream;
    String line=null;
    String result=null;
    String[] data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.ListView1);

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));

        getData();

        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        listView.setAdapter(arrayAdapter);
    }

    public void getData(){
        try {
            URL url=new URL("http://10.110.23.103:81/selectlist.php");
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);

            inputStream=new BufferedInputStream(httpURLConnection.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder=new StringBuilder();
            while((line=bufferedReader.readLine())!=null){
                stringBuilder.append(line+"\n");
            }

            inputStream.close();
            result=stringBuilder.toString();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        try
        {
            JSONArray jsonArray=new JSONArray(result);
            JSONObject jsonObject=null;

            data=new String[jsonArray.length()];

            for(int i=0;i<jsonArray.length();i++){
            jsonObject=jsonArray.getJSONObject(i);
            data[i]=jsonObject.getString("name");
            data[i]+=jsonObject.getString("nrc");
            data[i]+=jsonObject.getString("age");
            data[i]+=jsonObject.getString("phone");
            data[i]+=jsonObject.getString("address");
        }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
