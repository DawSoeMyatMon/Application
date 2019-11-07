package com.example.nyinyi.myapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private static EditText etusername;
    private static EditText etpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etusername=(EditText)findViewById(R.id.et_username);
        etpassword=(EditText)findViewById(R.id.et_password);

    }
    public void login(View view){
        String type="login";
        String name=etusername.getText().toString();
        String password=etpassword.getText().toString();

        LoginDB loginDB=new LoginDB();
        loginDB.execute(type,name,password);


    }
}
