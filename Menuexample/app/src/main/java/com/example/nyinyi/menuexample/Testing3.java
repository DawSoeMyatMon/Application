package com.example.nyinyi.menuexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Testing3 extends AppCompatActivity {

    private static EditText username;
    private static EditText password;
    private static Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btnLoginClick();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void btnLoginClick(){
        username=(EditText)findViewById(R.id.t1);
        password=(EditText)findViewById(R.id.t2);
        btnlogin=(Button)findViewById(R.id.btn1);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username2=username.getText().toString();
                String password2=password.getText().toString();

                if(username2.equals(" ") && password2.equals(" ")){
                    Toast.makeText(getApplicationContext(), "User Name and Password is incorrect", Toast.LENGTH_SHORT).show();
                }
                else if(username2.equals("smm") && password2.equals("123456")){
                    Toast.makeText(getApplicationContext(),"User Name and Password is Correct!",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(getApplicationContext(),Testing4.class);
                    intent.putExtra("username",username.getText().toString());
                    intent.putExtra("password",password.getText().toString());
                    startActivity(intent);
                }
            }
        });

    }
}
