package com.example.nyinyi.listaddexample;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DBHelper dbHelper;
    ArrayAdapter<String> madapter;
    ListView lstTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper=new DBHelper(this);
        lstTask=(ListView)findViewById(R.id.lstTask);
        loadTaskList();

    }

    private void loadTaskList() {
        ArrayList<String > taskList=dbHelper.getTaskList();
        if(madapter==null){
            madapter=new ArrayAdapter<String>(this,R.layout.row,R.id.tasktitle,taskList);
            lstTask.setAdapter(madapter);
        }
        else {
            madapter.clear();
            madapter.addAll(taskList);
            madapter.notifyDataSetChanged();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);

        Drawable icon=menu.getItem(0).getIcon();
        icon.mutate();
        icon.setColorFilter(getResources().getColor(android.R.color.white), PorterDuff.Mode.SRC_IN);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_act_task:
                final EditText taskEditText=new EditText(this);
                AlertDialog alertDialog=new AlertDialog.Builder(this)
                        .setTitle("Add New Task")
                        .setMessage("what do you want to do next?")
                        .setView(taskEditText)
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                String task=String.valueOf(taskEditText.getText());
                                dbHelper.insertNewTask(task);
                                loadTaskList();
                            }
                        })
                        .setNegativeButton("Cancel",null)
                        .create();

                alertDialog.show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void deleteTask(View view){
        View parent=(View)view.getParent();
        TextView taskTextView=(TextView)findViewById(R.id.tasktitle);
        String task=String.valueOf(taskTextView.getText());
        dbHelper.insertNewTask(task);
        loadTaskList();


    }
}
