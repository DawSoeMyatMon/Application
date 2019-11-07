package com.example.nyinyi.loginexample;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity{

    private static EditText username;
    private static EditText password;
    private static Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=(EditText)findViewById(R.id.txt_username);
        password=(EditText)findViewById(R.id.txt_password);

    }

    public void loginClick(View view){

        String UserName=username.getText().toString();
        String Password=password.getText().toString();
        String type="login";
        BackgroundWorker backgroundWorker=new BackgroundWorker(this);
        backgroundWorker.execute(type,UserName,Password);


    }
}
