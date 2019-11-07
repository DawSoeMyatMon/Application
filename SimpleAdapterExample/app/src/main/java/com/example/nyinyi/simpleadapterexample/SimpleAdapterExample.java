package com.example.nyinyi.simpleadapterexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class SimpleAdapterExample extends Activity {


    ListView simpleListView;
    String[] fruitNames={"Apple","Mango","Banana","PineApple"};
    int[] fruitImages={R.drawable.apple,R.drawable.mango,R.drawable.banana,R.drawable.pineapple};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter_example);

        simpleListView=(ListView)findViewById(R.id.simplelistview);

        ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();
        for(int i=0;i<fruitNames.length;i++){
            HashMap<String,String> hashMap=new HashMap<>();
            hashMap.put("name",fruitNames[i]);
            hashMap.put("image",fruitImages[i]+"");
            arrayList.add(hashMap);
        }

        String[] from={"name","image"};
        int[] to={R.id.textView,R.id.imageView};

        SimpleAdapter simpleAdapter=new SimpleAdapter(this,arrayList,R.layout.list_view_items,from,to);

        simpleListView.setAdapter(simpleAdapter);

        simpleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),fruitNames[i],Toast.LENGTH_LONG).show();
            }
        });

    }
}
