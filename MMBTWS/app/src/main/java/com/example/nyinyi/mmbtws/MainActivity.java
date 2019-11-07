package com.example.nyinyi.mmbtws;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Context context;
    ArrayAdapter<String> arrayAdapter;
    InputStream inputStream = null;
    String result = "";
    String line = "";
    String strresult = "";
    String result1="";
    String[] data;
    AlertDialog alertDialog;
    Button getbtn;
    ProgressBar pgBar;
    TextView textView;
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getbtn = (Button) findViewById(R.id.btnget);
        pgBar=(ProgressBar)findViewById(R.id.progressBar);
        textView=(TextView)findViewById(R.id.txtData);
        textView1=(TextView)findViewById(R.id.txtData1);

        getbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pgBar.setVisibility(View.VISIBLE);
                StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
                getData();
                pgBar.setVisibility(View.GONE);
                textView.setText(strresult);

                // arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
                // listView.setAdapter(arrayAdapter);
            }
        });
    }
    private String getData() {
        try {

            URL url = new URL("http://10.110.1.15:9001/MMBTWS2/Service1.svc/GetCashPosition");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            inputStream = new BufferedInputStream(httpURLConnection.getInputStream());

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line + "\n");
                result += line;
            }

            inputStream.close();
            strresult = stringBuilder.toString();
            strresult = strresult.substring(6, strresult.length()-3);
            strresult = strresult.replace("\\","");
            return strresult;
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            JSONArray jsonArray = new JSONArray(strresult);
            JSONObject jsonObject = null;
            data = new String[jsonArray.length()];
            for (int i = 0; i < jsonArray.length(); i++) {
                data[i] = jsonObject.getString("AccountNumber");
                textView1.setText(data[i]);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

