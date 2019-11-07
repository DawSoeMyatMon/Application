package com.example.nyinyi.jsonobjectexample;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.view.ViewGroup.LayoutParams;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void submit(View view) {
                String result = null;
                InputStream inputStream;

                try {
                    URL url = new URL("http://10.110.23.103:81/selectall.php");
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    inputStream= httpURLConnection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                    Toast.makeText(getApplicationContext(),"Try 1           7",Toast.LENGTH_LONG).show();
                    StringBuilder sb = new StringBuilder();
                    Toast.makeText(getApplicationContext(),"Try 1           8",Toast.LENGTH_LONG).show();
                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    Toast.makeText(getApplicationContext(),"Try 1           9",Toast.LENGTH_LONG).show();
                    inputStream.close();
                    Toast.makeText(getApplicationContext(),"Try 1           10",Toast.LENGTH_LONG).show();
                    result = sb.toString();
                    Toast.makeText(getApplicationContext(),"Try 1           11",Toast.LENGTH_LONG).show();
                    JSONArray jArray = new JSONArray(result);
                    Toast.makeText(getApplicationContext(),"Try 2",Toast.LENGTH_LONG).show();
                    String re = jArray.getString(jArray.length() - 1);
                    TableLayout tv;
                    tv = (TableLayout)findViewById(R.id.table);
                    tv.removeAllViewsInLayout();
                    int flag = 1;
                    for (int i = -1; i < jArray.length() - 1; i++) {
                        TableRow tr = new TableRow(MainActivity.this);
                        tr.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
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
                            b29.setText("no");
                            b29.setTextColor(Color.BLUE);
                            b29.setTextSize(15);
                            tr.addView(b29);

                            tv.addView(tr);

                            final View vline = new View(MainActivity.this);
                            vline.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, 2));
                            vline.setBackgroundColor(Color.BLUE);

                            tv.addView(vline);
                            flag = 0;
                            Toast.makeText(getApplicationContext(),"Try 3",Toast.LENGTH_LONG).show();
                        } else {
                            JSONObject json_data = jArray.getJSONObject(i);

                            Log.i("log_tag", "id: " + json_data.getInt("f1") +
                                    ", Username: " + json_data.getString("f2") +
                                    ", No: " + json_data.getInt("f3"));

                            TextView b = new TextView(MainActivity.this);
                            String stime = String.valueOf(json_data.getInt("f1"));
                            b.setText(stime);
                            b.setTextColor(Color.RED);
                            b.setTextSize(15);
                            tr.addView(b);

                            TextView b1 = new TextView(MainActivity.this);
                            b1.setPadding(10, 0, 0, 0);
                            b1.setTextSize(15);
                            String stime1 = json_data.getString("f2");
                            b1.setText(stime1);
                            b1.setTextColor(Color.WHITE);
                            tr.addView(b1);

                            TextView b2 = new TextView(MainActivity.this);
                            b2.setPadding(10, 0, 0, 0);
                            String stime2 = String.valueOf(json_data.getInt("f3"));
                            b2.setText(stime2);
                            b2.setTextColor(Color.RED);
                            b2.setTextSize(15);
                            tr.addView(b2);

                            tv.addView(tr);

                            final View vline1 = new View(MainActivity.this);
                            vline1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, 1));
                            vline1.setBackgroundColor(Color.WHITE);
                            tv.addView(vline1);
                            Toast.makeText(getApplicationContext(),"Try 4",Toast.LENGTH_LONG).show();
                        }
                    }
                }
                catch(Exception e){
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }

}
