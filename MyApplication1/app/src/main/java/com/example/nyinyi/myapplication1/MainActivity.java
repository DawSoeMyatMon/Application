package com.example.nyinyi.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static EditText txtname;
    private static EditText txtpassword;
    private static Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLoginClickListener();
    }

    public void btnLoginClickListener(){
        txtname=(EditText)findViewById(R.id.txt_name);
        txtpassword=(EditText)findViewById(R.id.txt_password);
        btnlogin=(Button)findViewById(R.id.btn_login);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtname.getText().toString().trim().equals("smm")&&txtpassword.getText().toString().trim().equals("123"))
                {
                    Toast.makeText(MainActivity.this,"Name and Password is Correct",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                    Bundle b=new Bundle();
                    b.putString("name",txtname.getText().toString());
                    b.putString("password",txtpassword.getText().toString());
                    intent.putExtras(b);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Name and Paassword is Incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
