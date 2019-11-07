package com.example.nyinyi.mssqlexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button btn_Get;
    ListView lst_Data;
    SimpleAdapter SA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Get=(Button)findViewById(R.id.btnGet);
        lst_Data=(ListView)findViewById(R.id.lstData);

        btn_Get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Map<String,String>> mydataList=null;
                GetData myData=new GetData();
                try {
                    mydataList=myData.getdata();
                    String[] fromwhere={"ID","Country","Capital"};
                    int[] viewwhere={R.id.ID,R.id.Country,R.id.Capital};
                    SA=new SimpleAdapter(MainActivity.this,mydataList,R.layout.listtemplate,fromwhere,viewwhere);
                    lst_Data.setAdapter(SA);


                } catch (SQLException e) {
                    e.printStackTrace();
                }


            }
        });
    }
}
