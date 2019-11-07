package com.example.nyinyi.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {

    private static EditText txtcal;
    private static Button btnone;
    private static Button btntwo;
    private static Button btnthree;
    private static Button btnfour;
    private static Button btnfive;
    private static Button btnsix;
    private static Button btnseven;
    private static Button btneight;
    private static Button btnnine;
    private static Button btnzero;
    private static Button btnadd;
    private static Button btnsub;
    private static Button btnmul;
    private static Button btndiv;
    private static Button btndelete;
    private static Button btnequal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        txtcal=(EditText)findViewById(R.id.txt_cal);
        btnone=(Button)findViewById(R.id.btn_one);
        btntwo=(Button)findViewById(R.id.btn_two);
        btnthree=(Button)findViewById(R.id.btn_three);
        btnfour=(Button)findViewById(R.id.btn_four);
        btnfive=(Button)findViewById(R.id.btn_five);
        btnsix=(Button)findViewById(R.id.btn_six);
        btnseven=(Button)findViewById(R.id.btn_seven);
        btneight=(Button)findViewById(R.id.btn_eight);
        btnnine=(Button)findViewById(R.id.btn_nine);
        btnzero=(Button)findViewById(R.id.btn_zero);
        btnadd=(Button)findViewById(R.id.btn_add);
        btnsub=(Button)findViewById(R.id.btn_sub);
        btnmul=(Button)findViewById(R.id.btn_mul);
        btndiv=(Button)findViewById(R.id.btn_div);
        btndelete=(Button)findViewById(R.id.btn_delete);
        btnequal=(Button)findViewById(R.id.btn_equal);

        btnone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String added=txtcal.getText().toString();
                txtcal.setText(added+"1");
            }
        });

        btntwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String added=txtcal.getText().toString();
                txtcal.setText(added+"2");
            }
        });

        btnthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String added=txtcal.getText().toString();
                txtcal.setText(added+"3");
            }
        });

        btnfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String added=txtcal.getText().toString();
                txtcal.setText(added+"4");
            }
        });

        btnfive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String added=txtcal.getText().toString();
                txtcal.setText(added+"5");
            }
        });

        btnsix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String added=txtcal.getText().toString();
                txtcal.setText(added+"6");
            }
        });

        btnseven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String added=txtcal.getText().toString();
                txtcal.setText(added+"7");
            }
        });

        btneight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String added=txtcal.getText().toString();
                txtcal.setText(added+"8");
            }
        });

        btnnine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String added=txtcal.getText().toString();
                txtcal.setText(added+"9");
            }
        });

        btnzero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String added=txtcal.getText().toString();
                txtcal.setText(added+"0");
            }
        });

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String added=txtcal.getText().toString();
                txtcal.setText(added+"+");
            }
        });

        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String added=txtcal.getText().toString();
                txtcal.setText(added+"-");
            }
        });

        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String added=txtcal.getText().toString();
                txtcal.setText(added+"*");
            }
        });

        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String added=txtcal.getText().toString();
                txtcal.setText(added+"/");
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int length = txtcal.getText().length();
                if (length > 0) {
                    txtcal.getText().delete(length - 1, length);
                }
            }
        });

        btnequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String textsum=txtcal.getText().toString();
                Toast.makeText(getApplicationContext(),"Test:"+textsum,Toast.LENGTH_LONG).show();
                txtcal.setText("res:");
                Toast.makeText(getApplicationContext(),"Step1",Toast.LENGTH_LONG).show();
               /* String[] res=textsum.split("-");
                Toast.makeText(getApplicationContext(),"Step2",Toast.LENGTH_LONG).show();
                String op1=res[0];
                Toast.makeText(getApplicationContext(),"Step3",Toast.LENGTH_LONG).show();
                String op2=res[2];
                Toast.makeText(getApplicationContext(),"Step4",Toast.LENGTH_LONG).show();
                String test=res[1];
                Toast.makeText(getApplicationContext(),"Step5",Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),"0:"+op1+"1:"+op2+"2:"+test,Toast.LENGTH_LONG).show();
                int Sub=Integer.parseInt(op1)-Integer.parseInt(op2);
                txtcal.setText(Sub);
                */

            }
        });

    };
}
