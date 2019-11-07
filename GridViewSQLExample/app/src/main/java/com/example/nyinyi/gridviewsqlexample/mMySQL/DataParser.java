package com.example.nyinyi.gridviewsqlexample.mMySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by SMM on 10/9/2017.
 */

public class DataParser extends AsyncTask<Void,Void,Integer> {

    Context context;
    GridView gv;
    String jsonData;

    ProgressDialog progressDialog;
    ArrayList<String> spacecrafts = new ArrayList<>();

    public DataParser(Context context, GridView gv, String jsonData) {
        this.context = context;
        this.gv = gv;
        this.jsonData = jsonData;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Parse");
        progressDialog.setMessage("Parsing data.....Please wait");
        progressDialog.show();
    }

    @Override
    protected Integer doInBackground(Void... voids) {
        return this.parseData();
    }

    @Override
    protected void onPostExecute(Integer result) {
        super.onPostExecute(result);
        progressDialog.dismiss();

        if(result==0){
            Toast.makeText(context,"Unsuccessful,Null Returned",Toast.LENGTH_LONG).show();
        }
        else {
            ArrayAdapter arrayAdapter=new ArrayAdapter(context,android.R.layout.simple_list_item_1,spacecrafts);
            gv.setAdapter(arrayAdapter);

            gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    Toast.makeText(context,spacecrafts.get(position),Toast.LENGTH_LONG).show();
                }
            });

        }
    }

    private int parseData(){
        try
        {
            JSONArray jsonArray=new JSONArray(jsonData);
            JSONObject jsonObject=null;

            spacecrafts.clear();
            for(int i=0;i<jsonArray.length();i++){
                jsonObject=jsonArray.getJSONObject(i);

                String name=jsonObject.getString("name");
                spacecrafts.add(name);

            }
            return 1;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

}
