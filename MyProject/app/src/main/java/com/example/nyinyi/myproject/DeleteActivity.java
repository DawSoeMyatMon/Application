package com.example.nyinyi.myproject;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DeleteActivity extends AppCompatActivity {

    private static EditText etnrc;
    private static Button btndelete;
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        etnrc=(EditText)findViewById(R.id.etdenrc);
        btndelete=(Button)findViewById(R.id.btndelete);
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nrc=etnrc.getText().toString();
                String type="delete";
                String regx="[0-9]{2}/[a-zA-Z]{9}(N)[0-9]{6}";

                if(nrc.equals("")){
                   /* AlertDialog alertDialog=new AlertDialog.Builder(context).create();
                    alertDialog.setTitle("Delete Warranty Status:");
                    alertDialog.setMessage("Please fill in the blank!");
                    alertDialog.show();
                    */
                    etnrc.requestFocus();
                    etnrc.setError("Field can't be blank!");

                }
              /* else if(!nrc.trim().matches(regx))
                {
                    AlertDialog alertDialog=new AlertDialog.Builder(context).create();
                    alertDialog.setTitle("Delete Warranty Status");
                    alertDialog.setMessage("NRC format is incorrect!");
                    alertDialog.show();
                }
                */
                else {
                    DeleteDB deleteDB = new DeleteDB(DeleteActivity.this);
                    deleteDB.execute(type,nrc);
                }
            }
        });
    }

}
