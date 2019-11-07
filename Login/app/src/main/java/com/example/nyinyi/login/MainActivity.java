package com.example.nyinyi.login;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
    EditText UsernameEt,PasswordEt;
    TextView Resultq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UsernameEt=(EditText)findViewById(R.id.etUserName);
        PasswordEt=(EditText)findViewById(R.id.etPassword);
        Resultq=(TextView)findViewById(R.id.tv);

    }

    public void onLogin(View view){
        String username=UsernameEt.getText().toString();
        String password=PasswordEt.getText().toString();
        BackgroundWorker backgroundWorker=new BackgroundWorker(this);
        String type="login";
        backgroundWorker.execute(type,username,password);

    }
}
