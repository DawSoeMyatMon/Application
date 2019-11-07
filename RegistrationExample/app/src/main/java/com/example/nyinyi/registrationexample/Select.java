package com.example.nyinyi.registrationexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Select extends AppCompatActivity {

    private static Button btnselect;
    private static EditText etname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        etname=(EditText)findViewById(R.id.et_oldname);
    }

    public void select(View view){
        String name=etname.getText().toString();
        String type="select";

        DataAccessSelect dataAccessSelect=new DataAccessSelect(this);
        dataAccessSelect.execute(type,name);

    }
}
