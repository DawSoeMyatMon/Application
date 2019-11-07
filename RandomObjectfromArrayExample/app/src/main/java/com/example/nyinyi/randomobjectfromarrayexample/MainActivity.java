package com.example.nyinyi.randomobjectfromarrayexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView=(ImageView)findViewById(R.id.iView);
        textView=(TextView)findViewById(R.id.tView);
        button=(Button)findViewById(R.id.btnRandom);
        showRandomList();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Click Start",Toast.LENGTH_LONG).show();
                showRandomList();
            }
        });
    }

    public void showRandomList()
    {
        imageView.setImageResource(factArray[0].getmImage());
        textView.setText(factArray[0].getmFact());
        shuffle();
    }
    Fact f01=new Fact(R.drawable.a,"HelloWorld a");
    Fact f02=new Fact(R.drawable.b,"HelloWorld b");
    Fact f03=new Fact(R.drawable.c,"HelloWorld c");
    Fact f04=new Fact(R.drawable.d,"HelloWorld d");
    Fact f05=new Fact(R.drawable.e,"HelloWorld e");
    Fact f06=new Fact(R.drawable.f,"HelloWorld f");

    Fact[] factArray=new Fact[]{f01,f02,f03,f04,f05,f06};

    public void shuffle()
    {
        Collections.shuffle(Arrays.asList(factArray));
    }
}
