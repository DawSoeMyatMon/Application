package com.example.nyinyi.myproject;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SelectShowListView extends Activity {

    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    InputStream inputStream;
    OutputStream outputStream;
    String line=null;
    String result=null;
    String[] data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_show_list_view);

                Toast.makeText(getApplicationContext(),"Search Button  Start",Toast.LENGTH_LONG).show();

                    listView = (ListView)findViewById(R.id.lstView2);
                    StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
                    getData();
                    arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
                    listView.setAdapter(arrayAdapter);
            }

            private void getData(){
                try {
                    URL url=new URL("http://10.110.23.103:81/selectjson.php");
                    HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);

                 /*   outputStream=new BufferedOutputStream(httpURLConnection.getOutputStream());
                    BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream));
                    String post_data= URLEncoder.encode("name","UTF-8")+"+"+URLEncoder.encode(name,"UTF-8");
                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();*/

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
                       /* data[i]+=jsonObject.getString("nrc");
                        data[i]+=jsonObject.getString("age");
                        data[i]+=jsonObject.getString("phone");
                        data[i]+=jsonObject.getString("address");
                        */
                    }

                }
                catch (Exception e){
                    e.printStackTrace();
                }
    }

}
