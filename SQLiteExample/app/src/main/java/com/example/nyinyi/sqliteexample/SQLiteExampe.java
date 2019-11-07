package com.example.nyinyi.sqliteexample;

import android.content.Context;
import android.os.*;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.jar.Attributes;

public class SQLiteExampe extends AppCompatActivity {

    private static EditText name;
    private static EditText password;
    private static EditText oldname;
    private static EditText newname;
    private static EditText deletename;
    private static TextView txtv;
    myDbAdapter helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_exampe);

        name=(EditText)findViewById(R.id.edtxt_name);
        password=(EditText)findViewById(R.id.edtxt_password);
        oldname=(EditText)findViewById(R.id.edtxt_currentname);
        newname=(EditText)findViewById(R.id.edtxt_newname);
        deletename=(EditText)findViewById(R.id.ededtxt_deletename);
        txtv=(TextView)findViewById(R.id.textView1);


        helper=new myDbAdapter(this);



    }

    public void addUser(View view){

        String s1= name.getText().toString();
        String s2=password.getText().toString();
        if(s1.isEmpty() || s2.isEmpty()){
            Message.message(getApplicationContext(),"Enter both Name and Password");
        }
        else {
            long id=helper.inertData(s1,s2);
            if(id<=0){
                Message.message(getApplicationContext(),"Insertion is Unsucessful");
                name.setText("");
                password.setText("");
            }
            else {
                Message.message(getApplicationContext(),"Insertion is Sucessful");
                name.setText("");
                password.setText("");
            }
        }
    }

    public void viewData(View view){
        String data=helper.getData();
        Message.message(this,data);
    }

    public void update(View view){
        String n1=oldname.getText().toString();
        String n2=newname.getText().toString();
        if(n1.isEmpty() || n2.isEmpty()){
            Message.message(getApplicationContext(),"Empty data");
        }
        else {
            int ans=helper.updateName(n1,n2);
            if(ans<=0){
                Message.message(getApplicationContext(),"Update Successful");
                oldname.setText("");
                newname.setText("");
            }
            else {
                Message.message(getApplicationContext(),"Update Unsuccessful");
                oldname.setText("");
                newname.setText("");

            }
        }

    }

    public void delete(View view){
        String d=deletename.getText().toString();
        if(d.isEmpty()){
            Message.message(getApplicationContext(),"Empty Data");
        }
        int ans=helper.delete(d);
        if(ans<=0){
            Message.message(getApplicationContext(),"Delete Successful");
            deletename.setText("");
        }
        else {
            Message.message(getApplicationContext(),"Delete Unsuccessful");
            deletename.setText("");

        }
    }


}
