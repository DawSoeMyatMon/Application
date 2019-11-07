package com.example.nyinyi.registrationexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Update extends AppCompatActivity {

    private static EditText etoldname1,etnewname1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        etoldname1=(EditText)findViewById(R.id.et_oldname);
        etnewname1=(EditText)findViewById(R.id.et_newname);

    }

    public void update(View view){
        String nameold=etoldname1.getText().toString();
        String namenew=etnewname1.getText().toString();
        String type="update";
        DataAccessUpdate dataAccessUpdate=new DataAccessUpdate(this);
        dataAccessUpdate.execute(type,nameold,namenew);


    }
}
