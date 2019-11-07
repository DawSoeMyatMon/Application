package com.example.nyinyi.preferenceexample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.view.CollapsibleActionView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import org.w3c.dom.Text;
import java.util.Date;

public class PreferenceExample extends Activity implements OnClickListener{

    private static Button btnone;
    private static Button btntwo;
    private static TextView txtmsg;
    View layout_vertical;
    final int mode=Activity.MODE_PRIVATE;
    final String prefName="MyPreference";
    SharedPreferences mySharedPreferences;
    SharedPreferences.Editor myEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference_example);

        btnone=(Button)findViewById(R.id.btn_one);
        btnone.setOnClickListener(this);
        btntwo=(Button)findViewById(R.id.btn_two);
        btntwo.setOnClickListener(this);
        txtmsg=(TextView)findViewById(R.id.txt_result);
        layout_vertical=(View)findViewById(R.id.layout_vertical1);

        txtmsg.setText("This is a sample line \n"
                        + "This is a first line \n"
                        + "This is a second line");

        mySharedPreferences=getSharedPreferences(prefName,0);
        myEditor=mySharedPreferences.edit();

        if(mySharedPreferences != null && mySharedPreferences.contains("backColor")){
            applySavedPrefernces();

        }
        else {
            Toast.makeText(getApplicationContext(), "No Prefrences found", Toast.LENGTH_LONG).show();
        }

    }

    public void onClick(View view){
        myEditor.clear();

        if(view.getId()==btnone.getId()){
            myEditor.putInt("backColor", Color.BLACK);
            myEditor.putInt("textSize",12);
            myEditor.putInt("layoutColor",Color.DKGRAY);

        }
        else
        {
            myEditor.putInt("backColor",Color.BLUE);
            myEditor.putInt("textSize",20);
            myEditor.putInt("layoutColor",Color.GREEN);

        }

        myEditor.commit();
        applySavedPrefernces();

    }


    public void applySavedPrefernces(){

        int backColor=mySharedPreferences.getInt("backColor",Color.BLACK);
        int textSize=mySharedPreferences.getInt("textSize",12);
        String textStyle=mySharedPreferences.getString("textStyle","normal");
        int layoutColor=mySharedPreferences.getInt("layoutColor",Color.DKGRAY);

        String msg="color: "+ backColor +"\n"+
                   "size: "+textSize + "\n" +
                "style: "+textStyle+ "\n" +
                "layout: "+layoutColor + "\n";

        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();

        txtmsg.setBackgroundColor(backColor);
        txtmsg.setTextSize(textSize);

        if(textStyle.compareTo("normal")==0){
            txtmsg.setTypeface(Typeface.SERIF,Typeface.NORMAL);
        }
        else {
            txtmsg.setTypeface(Typeface.SERIF,Typeface.BOLD);
        }

        layout_vertical.setBackgroundColor(layoutColor);

    }
}
