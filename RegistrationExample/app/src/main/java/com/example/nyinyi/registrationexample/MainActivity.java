package com.example.nyinyi.registrationexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static EditText name;
    private static EditText nrc;
    private static EditText age;
    /*
    private static RadioGroup rdngpgender;
    private static RadioButton rdngeder;
    private static CheckBox chkbook,chkothers;
    */
    private static EditText phone;
    private static EditText address;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.txt_name);
        nrc = (EditText) findViewById(R.id.txt_nrc);
        age = (EditText) findViewById(R.id.txt_age);
        phone = (EditText) findViewById(R.id.txt_phone);
        address = (EditText) findViewById(R.id.txt_address);

        /*
        rdngpgender=(RadioGroup)findViewById(R.id.rdngp_gender);
        int rdn_selectedid=rdngpgender.getCheckedRadioButtonId();
        rdngeder=(RadioButton)findViewById(rdn_selectedid);
        chkbook=(CheckBox)findViewById(R.id.chk_book);
        chkothers=(CheckBox)findViewById(R.id.chk_other);
        */

    }
    public void register(View view){

        String Name = name.getText().toString();
        String Nrc = nrc.getText().toString();
        String Age = age.getText().toString();
        /*
        String Gender=rdngeder.getText().toString();
        */
        String Phone = phone.getText().toString();
        String Address = address.getText().toString();
        /*
        String Interest="";
        if(chkbook.isChecked() && chkothers.isChecked()){
            Interest="book others";
        }
        else if(chkbook.isChecked()) {
            Interest = "book";
        }
        else if(chkothers.isChecked()) {
            Interest ="others";
        }
        */

        String type="register";
        DataAccess dataAccess = new DataAccess(this);
        dataAccess.execute(type,Name, Nrc, Age,Phone, Address);

        Intent myIntent = new Intent(getApplicationContext(), Main3Activity.class);
        startActivity(myIntent);

    }
}
