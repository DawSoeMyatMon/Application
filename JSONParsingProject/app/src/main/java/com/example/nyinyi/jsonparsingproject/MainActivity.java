package com.example.nyinyi.jsonparsingproject;

import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity{

    private static EditText searchname;
    private static Button search;
    private static ProgressBar progressBar;
    Context context;


    ListView listView,listView1;
    ArrayAdapter<String> arrayAdapter;
    ArrayAdapter<String> arrayAdapter1;
    InputStream inputStream=null;
    OutputStream outputStream=null;
    String result=null;
    String line=null;
    String data[];
    String data1[];
    String result1="";
    String result2="";
    String result3="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar=(ProgressBar)findViewById(R.id.pgBar);
        searchname = (EditText) findViewById(R.id.txtsearchname);
        search = (Button) findViewById(R.id.btnsearch);

       /* searchname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {

                if(s.toString().equals(" ")){
                    Toast.makeText(getApplicationContext(),"Please,fill in the blank",Toast.LENGTH_LONG).show();
                    AlertDialog alertDialog=new AlertDialog.Builder(context).create();
                    alertDialog.setTitle("Blank Status");
                    alertDialog.setMessage("Please,fill in the blank");
                    alertDialog.show();
                }
                else {
                    //searchItems(s.toString());
                    Toast.makeText(getApplicationContext(),"Ans:",Toast.LENGTH_LONG).show();
                    AlertDialog alertDialog=new AlertDialog.Builder(context).create();
                    alertDialog.setTitle("Ans Status");
                    alertDialog.setMessage("Please,wait the result");
                    alertDialog.show();


                }
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        */
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);

                listView=(ListView)findViewById(R.id.lstView);

                StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
                getData();
                arrayAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,data);
                //(to show with other res file)
                // arrayAdapter=new ArrayAdapter<String>(MainActivity.this,R.layout.list_item,R.id.txtList,data);
                listView.setAdapter(arrayAdapter);
                progressBar.setVisibility(View.GONE);

            }
        });
    }

    /*
    public void searchItems(String txtsearch){
        String[] items=new String[]{"flower","apple","orange","mango","pineapple","strawberry"};
        for(String item:items){
            if(!item.contains(txtsearch)){
                listView.removeAllViews();
            }
            arrayAdapter.notifyDataSetChanged();
            }
    }
    */
    private void getData()
    {
        try {

           // URL url=new URL("http://10.110.23.103:81/jsonparsing.php");
            URL url = new URL("http://10.110.1.15:9001/MMBTWS2/Service1.svc/GetCashPosition");

            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            inputStream=new BufferedInputStream(httpURLConnection.getInputStream());

        } catch (Exception e) {
            e.printStackTrace();
        }

        try
        {
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder=new StringBuilder();
            while((line=bufferedReader.readLine())!=null)
            {
               stringBuilder.append(line+"\n");
            }

            inputStream.close();

            result=stringBuilder.toString();
            result1 = result.substring(6, result.length() - 3);
            result2 = result1.replace("\\", "");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try
        {
            JSONArray jsonArray=new JSONArray(result2);
            JSONObject jsonObject=null;

            data=new String[jsonArray.length()];

            for(int i=0;i<jsonArray.length();i++){
                jsonObject=jsonArray.getJSONObject(i);
                data[i]="AccountNumber:"+jsonObject.getString("AccountNumber")+"\n";
                data[i]+="TellerID:"+jsonObject.getString("TellerID")+"\n";
                data[i]+="Denom:"+jsonObject.getString("Denom")+"\n";
                data[i]+="Qty:"+jsonObject.getString("Qty")+"\n";
                data[i]+="Amount:"+jsonObject.getString("Amount");

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
