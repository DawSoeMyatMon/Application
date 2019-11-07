package com.example.nyinyi.jsontest;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends Activity {
    public void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submit(View view){
        String result = null;
        InputStream is = null;

        try {
                   /* HttpClient httpclient = new DefaultHttpClient();
                    HttpPost httppost = new HttpPost("http://10.0.2.2/selectall.php");
                    HttpResponse response = httpclient.execute(httppost);
                    HttpEntity entity = response.getEntity();
                    is = entity.getContent();
                    */
            Toast.makeText(getApplicationContext(),"Test 0",Toast.LENGTH_LONG).show();
            URL url=new URL("http://10.110.23.103:81/selectjson.php");
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            Toast.makeText(getApplicationContext(),"Test 1",Toast.LENGTH_LONG).show();
            is=httpURLConnection.getInputStream();
            Toast.makeText(getApplicationContext(),"Test 2",Toast.LENGTH_LONG).show();

            Log.e("log_tag", "connection success ");
            //   Toast.makeText(getApplicationContext(), "pass", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.e("log_tag", "Error in http connection " + e.toString());
            Toast.makeText(getApplicationContext(), "Connection fail", Toast.LENGTH_SHORT).show();

        }
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
                //  Toast.makeText(getApplicationContext(), "Input Reading pass", Toast.LENGTH_SHORT).show();
            }
            is.close();

            result = sb.toString();
        } catch (Exception e) {
            Log.e("log_tag", "Error converting result " + e.toString());
            Toast.makeText(getApplicationContext(), " Input reading fail", Toast.LENGTH_SHORT).show();

        }
        try {

            JSONArray jArray = new JSONArray(result);


            String re = jArray.getString(jArray.length() - 1);


            TableLayout tv = (TableLayout) findViewById(R.id.table);
            tv.removeAllViewsInLayout();


            int flag = 1;

            for (int i = -1; i < jArray.length() - 1; i++)

            {


                TableRow tr = new TableRow(MainActivity.this);

                tr.setLayoutParams(new TableLayout.LayoutParams(
                        TableLayout.LayoutParams.FILL_PARENT,
                        TableLayout.LayoutParams.WRAP_CONTENT));


                if (flag == 1) {

                    TextView b6 = new TextView(MainActivity.this);
                    b6.setText("ID");
                    b6.setTextColor(Color.BLUE);
                    b6.setTextSize(15);
                    tr.addView(b6);


                    TextView b19 = new TextView(MainActivity.this);
                    b19.setPadding(10, 0, 0, 0);
                    b19.setTextSize(15);
                    b19.setText("Name");
                    b19.setTextColor(Color.BLUE);
                    tr.addView(b19);

                    TextView b29 = new TextView(MainActivity.this);
                    b29.setPadding(10, 0, 0, 0);
                    b29.setText("Nrc");
                    b29.setTextColor(Color.BLUE);
                    b29.setTextSize(15);
                    tr.addView(b29);

                    TextView b39 = new TextView(MainActivity.this);
                    b6.setText("Age");
                    b6.setTextColor(Color.BLUE);
                    b6.setTextSize(15);
                    tr.addView(b39);


                    TextView b49 = new TextView(MainActivity.this);
                    b19.setPadding(10, 0, 0, 0);
                    b19.setTextSize(15);
                    b19.setText("Phone");
                    b19.setTextColor(Color.BLUE);
                    tr.addView(b49);

                    TextView b59 = new TextView(MainActivity.this);
                    b29.setPadding(10, 0, 0, 0);
                    b29.setText("Address");
                    b29.setTextColor(Color.BLUE);
                    b29.setTextSize(15);
                    tr.addView(b59);

                    tv.addView(tr);

                    final View vline = new View(MainActivity.this);
                    vline.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, 2));
                    vline.setBackgroundColor(Color.BLUE);


                    tv.addView(vline);
                    flag = 0;


                } else {

                    JSONObject json_data = jArray.getJSONObject(i);

                    Log.i("log_tag", "id: " + json_data.getInt("id") +
                            ", name: " + json_data.getString("name") +
                            ", nrc: " + json_data.getInt("nrc")+
                            ", age: " + json_data.getString("age") +
                            ", phone: " + json_data.getString("phone") +
                            ", address: " + json_data.getString("address"));


                    TextView b = new TextView(MainActivity.this);
                    String stime = String.valueOf(json_data.getInt("id"));
                    b.setText(stime);
                    b.setTextColor(Color.RED);
                    b.setTextSize(15);
                    tr.addView(b);


                    TextView b1 = new TextView(MainActivity.this);
                    b1.setPadding(10, 0, 0, 0);
                    b1.setTextSize(15);
                    String stime1 = json_data.getString("name");
                    b1.setText(stime1);
                    b1.setTextColor(Color.WHITE);
                    tr.addView(b1);

                    TextView b2 = new TextView(MainActivity.this);
                    b2.setPadding(10, 0, 0, 0);
                    String stime2 = String.valueOf(json_data.getInt("nrc"));
                    b2.setText(stime2);
                    b2.setTextColor(Color.RED);
                    b2.setTextSize(15);
                    tr.addView(b2);

                    TextView b3 = new TextView(MainActivity.this);
                    String stime3 = String.valueOf(json_data.getInt("age"));
                    b.setText(stime3);
                    b.setTextColor(Color.RED);
                    b.setTextSize(15);
                    tr.addView(b3);

                    TextView b4 = new TextView(MainActivity.this);
                    b1.setPadding(10, 0, 0, 0);
                    b1.setTextSize(15);
                    String stime4 = json_data.getString("phone");
                    b1.setText(stime4);
                    b1.setTextColor(Color.WHITE);
                    tr.addView(b4);

                    TextView b5 = new TextView(MainActivity.this);
                    b2.setPadding(10, 0, 0, 0);
                    String stime5 = String.valueOf(json_data.getInt("address"));
                    b2.setText(stime5);
                    b2.setTextColor(Color.RED);
                    b2.setTextSize(15);
                    tr.addView(b5);

                    tv.addView(tr);

                    final View vline1 = new View(MainActivity.this);
                    vline1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, 1));
                    vline1.setBackgroundColor(Color.WHITE);
                    tv.addView(vline1);

                }
            }

        } catch (JSONException e) {
            Log.e("log_tag", "Error parsing data " + e.toString());
            Toast.makeText(getApplicationContext(), "JsonArray fail", Toast.LENGTH_SHORT).show();
        }
    }
}



