package com.example.nyinyi.databasetesting;

import android.database.Cursor;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {

    DataBaseHelper myDb;

    private static EditText textname;
    private static EditText textsurname;
    private static EditText textmark;
    private static EditText textid;
    private static Button buttoninsert;
    private static Button buttondelete;
    private static Button buttonupdate;
    private static Button buttonselect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb=new DataBaseHelper(this);

        textname=(EditText)findViewById(R.id.txt_name);
        textsurname=(EditText)findViewById(R.id.txt_surname);
        textmark=(EditText)findViewById(R.id.txt_mark);
        textid=(EditText)findViewById(R.id.txt_id);

        buttoninsert=(Button)findViewById(R.id.btn_insert);
        buttondelete=(Button)findViewById(R.id.btn_delete);
        buttonupdate=(Button)findViewById(R.id.btn_update);
        buttonselect=(Button)findViewById(R.id.btn_select);

        InsertButton();
        DeleteButton();
        UpdateButton();
        SelectButton();
    }

    public void InsertButton(){
        buttoninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Insert",Toast.LENGTH_SHORT).show();

                boolean isInserted=myDb.insertData(textname.getText().toString(),textsurname.getText().toString(),textmark.getText().toString());
                if(isInserted ==true)
                {
                    Toast.makeText(MainActivity.this,"Data  Inserted",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Data not Inserted",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void DeleteButton(){
        buttondelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Delete",Toast.LENGTH_SHORT).show();

                Integer isDeletedRow=myDb.deleteData(textid.getText().toString());
                if(isDeletedRow>0)
                {
                    Toast.makeText(MainActivity.this,"Data Deleted",Toast.LENGTH_SHORT).show();
                }
                 else
                {
                    Toast.makeText(MainActivity.this,"Data not Deleted",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void UpdateButton(){
        buttonupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Update",Toast.LENGTH_SHORT).show();

                boolean isUpdated=myDb.updateData(textid.getText().toString(),textname.getText().toString(),textsurname.getText().toString(),textmark.getText().toString());
                if(isUpdated==true)
                {
                    Toast.makeText(MainActivity.this,"Data Updated",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Data not Updated",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void SelectButton(){
        buttonselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this,"Select",Toast.LENGTH_SHORT).show();

                Cursor res=myDb.getAllData();
                if(res.getCount()==0){
                    showMessage("Error","Nothing Not found");
                    return;
                }
                StringBuffer stringBuffer=new StringBuffer();
                while (res.moveToNext()){
                    stringBuffer.append("Id:"+res.getString(0)+"\n");
                    stringBuffer.append("Name:"+res.getString(1)+"\n");
                    stringBuffer.append("Surname:"+res.getString(2)+"\n");
                    stringBuffer.append("Mark:"+res.getString(3)+"\n");
                }
                showMessage("Data",stringBuffer.toString());
            }
        });
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}
