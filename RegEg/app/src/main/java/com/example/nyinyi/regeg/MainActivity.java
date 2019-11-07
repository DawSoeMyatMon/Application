package com.example.nyinyi.regeg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private static RadioGroup rdngpgender;
    private static RadioButton rdngender;
    private static CheckBox chkmyanmar;
    private static CheckBox chkenglish;
    private static CheckBox chkother;
    private static Button btnsubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rdngpgender=(RadioGroup)findViewById(R.id.rdngp_gender);
        chkmyanmar=(CheckBox)findViewById(R.id.chk_myanmar);
        chkenglish=(CheckBox)findViewById(R.id.chk_myanmar);
        chkother=(CheckBox)findViewById(R.id.chk_other);
    }

    public void submit(View view){
        int selected_id=rdngpgender.getCheckedRadioButtonId();
        rdngender=(RadioButton)findViewById(selected_id);
        String gender=rdngender.getText().toString();
        String language="";
        if(chkmyanmar.isChecked()){
            language=language+","+"myanmar";
        }
        if(chkenglish.isChecked()){
            language=language+","+"english";
        }
        if(chkother.isChecked()){
            language=language+","+"other";
        }
        String type="submit";
        DataAccess dataAccess=new DataAccess(this);
        dataAccess.execute(type,gender,language);

    }
}
