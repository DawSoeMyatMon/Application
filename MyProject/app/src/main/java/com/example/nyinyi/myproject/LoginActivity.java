package com.example.nyinyi.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private static TextView tvname,tvpassword;
    private static EditText ename,epassword;
    private static Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvname.setText("");
        tvpassword.setText("");

        login=(Button)findViewById(R.id.btnlogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ename=(EditText)findViewById(R.id.etname);
                epassword=(EditText)findViewById(R.id.etpassword);
                tvname=(TextView)findViewById(R.id.tvfename);
                tvpassword=(TextView)findViewById(R.id.tvfepassword);

                if(ename.getText().toString().equals("")){
                    tvname.setText("Please fill in the blank");
                }
                else if(epassword.getText().toString().equals("")){
                    tvpassword.setText("Please fill in the blank");
                }
                else if(ename.getText().toString().equals("") && epassword.getText().toString().equals("")){
                    tvname.setText("Please fill in the blank");
                    tvpassword.setText("Please fill in the blank");
                }
                else {
                    Toast.makeText(getApplicationContext(),"Test4 ",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(getApplicationContext(),LoginSuccessfulActivity.class);
                    startActivity(intent);
                }
            }
        });
    }



}
