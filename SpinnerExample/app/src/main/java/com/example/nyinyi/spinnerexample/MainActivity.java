package com.example.nyinyi.spinnerexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;
    String[] data;
    String result="";
    String line="";
    InputStream inputStream=null;
    BufferedReader bufferedReader=null;
    HttpURLConnection httpURLConnection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner=(Spinner)findViewById(R.id.spinners);
        getData();
        arrayAdapter=new ArrayAdapter<String>(MainActivity.this,R.layout.spinner_layout,R.id.txtView,data);
        spinner.setAdapter(arrayAdapter);
    }
    private void getData() {

        try{

            URL url=new URL("http://10.110.1.15:9001/MMBTWS2/Service1.svc/GetCashPosition");

            httpURLConnection=(HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoInput(true);

            inputStream=new BufferedInputStream(httpURLConnection.getInputStream());
            bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder=new StringBuilder();
            while((line=bufferedReader.readLine())!=null){
                stringBuilder.append(line);
            }
            result=stringBuilder.toString();
            inputStream.close();
            bufferedReader.close();
            httpURLConnection.disconnect();
            result=result.substring(6,result.length()-3);
            result=result.replace("\\","");

            JSONArray jsonArray=new JSONArray(result);
            JSONObject jsonObject=null;
            data=new String[jsonArray.length()];

            for(int i=0;i<jsonArray.length();i++){
                jsonObject=jsonArray.getJSONObject(i);
                data[i]=jsonObject.getString("AccountNumber");
            }
        }
        catch(Exception e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"Error:"+e.toString(),Toast.LENGTH_LONG).show();
        }
    }
}
