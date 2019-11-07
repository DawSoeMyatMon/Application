package com.example.nyinyi.registrationexample;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Delete extends AppCompatActivity {
    private static Button btndelete;
    private static EditText etname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        etname=(EditText)findViewById(R.id.et_oldname);
    }

    public void delete(View view){

        String name=etname.getText().toString();
        String type="delete";
        DataAccessDelete dataAccessDelete=new DataAccessDelete(this);
        dataAccessDelete.execute(type,name);

    }

}
