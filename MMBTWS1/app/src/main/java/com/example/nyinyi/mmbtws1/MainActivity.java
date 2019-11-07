package com.example.nyinyi.mmbtws1;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int CONNECTION_TIMEOUT = 10000;
    public static final int READ_TIMEOUT = 15000;
    private RecyclerView mTWSView;
    private AdapterTWS mAdapter;
    InputStream inputStream;
    String line="";
    String result="";
    String strresult="";
    String result1="";
    String result2="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new AsynFetch().execute();
    }

    private class AsynFetch extends AsyncTask<String,Void,String> {
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        HttpURLConnection httpURLConnection;
        URL url;

        @Override
        protected void onPreExecute() {
            progressDialog.setMessage("\tLoading");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... strresult) {
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
                   // stringBuilder.append(line + "\n");
                    result += line;
                }

                inputStream.close();
                result1 = result.substring(6, result.length() - 3);
                result2 = result1.replace("\\", "");
                result2=result2.toString();
                return result2;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result2;
        }


        @Override
        protected void onPostExecute(String result2) {
            progressDialog.dismiss();
            List<DataTWS> data=new ArrayList<>();

            progressDialog.dismiss();
            try {
                JSONArray jArray = new JSONArray(result2);
                /*  Original Code

                for(int i=0;i<jArray.length();i++){
                    JSONObject json_data = jArray.getJSONObject(i);
                    DataTWS twsData = new DataTWS();
                    twsData.AccountNumber= json_data.getString("AccountNumber");
                    twsData.TellerID= json_data.getInt("TellerID");
                    twsData.Qty= json_data.getString("Qty");
                    twsData.Denomination= json_data.getString("Denomination");
                    twsData.Amount= json_data.getString("Amount");
                    data.add(twsData);
                }

                mTWSView = (RecyclerView)findViewById(R.id.twsList);
                mAdapter = new AdapterTWS(MainActivity.this, data);
                mTWSView.setAdapter(mAdapter);
                mTWSView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                */
                String[] dataa;
                JSONObject jsonObject = null;
                dataa = new String[jArray.length()];
                for (int i = 0; i < jArray.length(); i++) {
                    dataa[i] = jsonObject.getString("AccountNumber");

                }
                Toast.makeText(MainActivity.this,"Res:"+dataa,Toast.LENGTH_LONG).show();
            } catch (JSONException e) {
                Toast.makeText(MainActivity.this, "Error:"+e.toString(), Toast.LENGTH_LONG).show();
            }

        }

    }
}
