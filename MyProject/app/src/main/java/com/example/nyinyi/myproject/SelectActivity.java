package com.example.nyinyi.myproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class SelectActivity extends AppCompatActivity {

    private static EditText name;
    private static Button btnsearch;
    private static ListView lstView;
    ArrayAdapter<String> arrayAdapter;
    InputStream inputStream;
    String line=null;
    String result=null;
    String[] data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        name=(EditText)findViewById(R.id.etsearchname);
        lstView=(ListView)findViewById(R.id.lstView2);
        btnsearch=(Button)findViewById(R.id.btnsearch);

        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Search Button Click!",Toast.LENGTH_LONG).show();
               String type="search";
                String searchname=name.getText().toString();
                if(searchname.equals("")){
                    name.requestFocus();
                    name.setError("Field can't be blank!");
                }
                else {
                  /*  SelectDB selectDB = new SelectDB(SelectActivity.this);
                    selectDB.execute(type, searchname);
                    */
                     Toast.makeText(getApplicationContext(),"Click Start",Toast.LENGTH_LONG).show();
                     getData();
                    //StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
                    Toast.makeText(getApplicationContext(),"End",Toast.LENGTH_LONG).show();
                    arrayAdapter=new ArrayAdapter<String>(SelectActivity.this,R.layout.activity_select_show_list_view,R.id.tView,data);
                    lstView.setAdapter(arrayAdapter);

                }
            }
        });
    }

    public void getData(){
        try{
            Toast.makeText(getApplicationContext(),"0",Toast.LENGTH_LONG).show();
            String name="smm";
            URL url=new URL("http://10.110.23.103:81/selectlist.php");
            HttpURLConnection httpURLConnection;
            httpURLConnection= (HttpURLConnection) url.openConnection();
            OutputStream outputStream;
            outputStream=httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
            String post_data= URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8");
            bufferedWriter.write(post_data);
            bufferedWriter.close();
            outputStream.close();

            Toast.makeText(getApplicationContext(),"1",Toast.LENGTH_LONG).show();

            InputStream inputStream;
            inputStream=httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
            StringBuilder stringBuilder=new StringBuilder();
            while ((line=bufferedReader.readLine())!=null){
                stringBuilder.append(line);
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();

            result=stringBuilder.toString();

            Toast.makeText(getApplicationContext(),"2",Toast.LENGTH_LONG).show();

            JSONArray jsonArray=new JSONArray(result);
            JSONObject jsonObject=null;
            data=new String[jsonArray.length()];

            for(int i=0;i<jsonArray.length();i++){
                jsonObject=jsonArray.getJSONObject(i);
                data[i]=jsonObject.getString("name");
                data[i]+=jsonObject.getString("nrc");
            }
        }
        catch(Exception e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();

        }

    }
}

