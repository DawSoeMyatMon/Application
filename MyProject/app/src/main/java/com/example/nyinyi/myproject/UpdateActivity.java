package com.example.nyinyi.myproject;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class UpdateActivity extends AppCompatActivity {

    private static EditText upid,upname,upnrc,upage,upphone,upaddress;
    private static Button update,cancel,select;
    Context context=this;
    ArrayAdapter<String> arrayAdapter;
    String[] data;
    String res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        upid = (EditText) findViewById(R.id.etupid);
        upname = (EditText) findViewById(R.id.etupname);
        upnrc = (EditText) findViewById(R.id.etupnrc);
        upage = (EditText) findViewById(R.id.etupage);
        upphone = (EditText) findViewById(R.id.etupphone);
        upaddress = (EditText) findViewById(R.id.etupaddress);

        select = (Button) findViewById(R.id.btnupselect);
        update = (Button) findViewById(R.id.btnulpdate);
        cancel = (Button) findViewById(R.id.btncancel);

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Select Button Click!", Toast.LENGTH_LONG).show();
                String id = upid.getText().toString();
                if(id.equals("")){
                    upid.requestFocus();
                    upid.setError("Field can't be blank!");
                }
                else {

                    Toast.makeText(getApplicationContext(), "Ok!", Toast.LENGTH_LONG).show();
                    try {
                        Toast.makeText(getApplicationContext(), "try ...getData() Start", Toast.LENGTH_LONG).show();
                        URL url = new URL("http://10.110.23.103:81/updateselect.php");
                        HttpURLConnection httpURLConnection;
                        httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);

                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "uTF-8"));
                        String post_data = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(id, "UTF-8");
                        bufferedWriter.write(post_data);
                        bufferedWriter.flush();
                        bufferedWriter.close();

                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                        String line = "";
                        String result = "";
                        StringBuilder stringBuilder = new StringBuilder();
                        while ((line = bufferedReader.readLine()) != null) {
                            stringBuilder.append(line + "\n");
                        }
                        result = stringBuilder.toString();
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();

                        JSONArray jsonArray = new JSONArray(result);
                        JSONObject jsonObject = null;
                        data = new String[jsonArray.length()];

                        for (int i = 0; i < jsonArray.length(); i++) {
                            jsonObject = jsonArray.getJSONObject(i);
                            data[i] = jsonObject.getString("name");
                        }

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    arrayAdapter=new ArrayAdapter<String>(UpdateActivity.this,android.R.layout.simple_list_item_1,data);
                    upname.setText(arrayAdapter.toString());
                }
            }

        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Update Button Click!",Toast.LENGTH_LONG).show();

                String name=upname.getText().toString();
                String nrc=upnrc.getText().toString();
                String age=upage.getText().toString();
                String phone=upphone.getText().toString();
                String address=upaddress.getText().toString();

               /* if(name.equals("")||nrc.equals("")||age.equals("")||phone.equals("")||address.equals("")){
                    AlertDialog alertDialog=new AlertDialog.Builder(context).create();
                    alertDialog.setTitle("Update Warranty Status");
                    alertDialog.setMessage("Please fill in the blank");
                    alertDialog.show();

                }
                */
               if(name.equals("")){
                   upname.requestFocus();
                   upname.setError("Field can't be blank!");
               }
               if(nrc.equals("")){
                   upnrc.requestFocus();
                   upnrc.setError("Field can't be blank!");
               }
               if(age.equals("")){
                   upage.requestFocus();
                   upage.setError("Field can't be blank!");
               }
               if(phone.equals("")){
                   upphone.requestFocus();
                   upphone.setError("Field can't be blank!");
               }
               if(address.equals("")){
                   upaddress.requestFocus();
                   upaddress.setError("Field can't be blank!");
               }
               if((!name.equals("")) &&(!nrc.equals("")) && (!age.equals("")) && (!phone.equals("")) && (!address.equals("")))
                {

                    String type = "update";
                    UpdateDB updateDB = new UpdateDB(UpdateActivity.this);
                    updateDB.execute(type, name, nrc, age, phone, address);
                }

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Cancel Button Click!",Toast.LENGTH_LONG).show();

                upname.setText("");
                upnrc.setText("");
                upage.setText("");
                upphone.setText("");
                upaddress.setText("");

            }
        });

    }
}
