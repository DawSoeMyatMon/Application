package com.example.nyinyi.myproject;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {
    Context context=this;
    private static EditText ename,enrc,eage,ephone,eaddress;
    private static Button submit,cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        ename=(EditText)findViewById(R.id.etsearchname);
        enrc=(EditText)findViewById(R.id.etnrc);
        eage=(EditText)findViewById(R.id.etage);
        ephone=(EditText)findViewById(R.id.etphone);
        eaddress=(EditText)findViewById(R.id.etaddress);

        submit=(Button)findViewById(R.id.btnsubmit);
        cancel=(Button)findViewById(R.id.btncancel);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Submit Button Click!",Toast.LENGTH_LONG).show();
                String type="register";
                String name=ename.getText().toString();
                String nrc=enrc.getText().toString();
                String age=eage.getText().toString();
                String phone=ephone.getText().toString();
                String address=eaddress.getText().toString();
               /* if(name.equals("")|| nrc.equals("")||age.equals("")||phone.equals("")||address.equals("")){
                   // Toast.makeText(getApplicationContext(),"Please fill in the blank!",Toast.LENGTH_LONG).show();
                    AlertDialog alertDialog=new AlertDialog.Builder(context).create();
                    alertDialog.setTitle("Warranty Status");
                    alertDialog.setMessage("Please fill in the blank!");
                    alertDialog.show();

                }*/
               if(name.equals("")){
                   ename.requestFocus();
                   ename.setError("Field can't be blank!");
               }
               if(nrc.equals("")){
                   enrc.requestFocus();
                   enrc.setError("Field can't be blank!");
               }
               if(age.equals("")){
                   eage.requestFocus();
                   eage.setError("Field can't be blank!");
               }
               if(phone.equals("")){
                   ephone.requestFocus();
                   ephone.setError("Field can't be blank!");
               }
               if(address.equals("")){
                   eaddress.requestFocus();
                   eaddress.setError("Field can't be blank!");
               }
               if((!name.equals("")) && (!age.equals("")) && (!nrc.equals("")) && (!phone.equals("")) && (!address.equals("")))
                {
                    RegistrationDB registrationDB = new RegistrationDB(RegistrationActivity.this);
                    registrationDB.execute(type, name, nrc, age, phone, address);
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Cancel Button Click!",Toast.LENGTH_LONG).show();
                ename.setText("");
                enrc.setText("");
                eage.setText("");
                ephone.setText("");
                eaddress.setText("");
            }
        });
    }


}
