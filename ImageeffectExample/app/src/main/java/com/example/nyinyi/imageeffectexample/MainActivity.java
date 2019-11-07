package com.example.nyinyi.imageeffectexample;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.graphics.BitmapCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.WindowDecorActionBar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    private Bitmap bmp;
    private Bitmap operation;


    private static ImageView imgView;
    private static Button btnGray;
    private static Button btnBright;
    private static Button btnDark;
    private static Button btnRed;
    private static Button btnGreen;
    private static Button btnBlue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgView=(ImageView)findViewById(R.id.imageView);
        btnGray=(Button)findViewById(R.id.btn_gray);
        btnBright=(Button)findViewById(R.id.btn_bright);
        btnDark=(Button)findViewById(R.id.btn_dark);
        btnRed=(Button)findViewById(R.id.btn_red);
        btnGreen=(Button)findViewById(R.id.btn_green);
        btnBlue=(Button)findViewById(R.id.btn_blue);

        final BitmapDrawable bitmapDrawable=(BitmapDrawable)imgView.getDrawable();
        bmp=bitmapDrawable.getBitmap();

        btnGray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Gray Button Started!",Toast.LENGTH_LONG).show();
                operation=Bitmap.createBitmap(bmp.getWidth(),bmp.getHeight(),bmp.getConfig());

                double red=0.33;
                double green=0.59;
                double blue=0.11;

                for(int i=0;i<bmp.getWidth();i++){
                    for(int j=0;j<bmp.getHeight();j++){
                        int p=bmp.getPixel(i,j);
                        int r= Color.red(p);
                        int g=Color.red(p);
                        int b=Color.red(p);

                        r=(int)red*r;
                        g=(int)green*g;
                        b=(int)blue*b;

                        operation.setPixel(i,j,Color.argb(Color.alpha(p),r,g,b));
                    }
                }
                imgView.setImageBitmap(operation);
            }
        });

        btnBright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Bright Button Started!",Toast.LENGTH_LONG).show();
                operation.createBitmap(bmp.getWidth(),bmp.getHeight(),bmp.getConfig());

                for(int i=0;i<bmp.getWidth();i++){
                    for(int j=0;j<bmp.getHeight();j++){
                        int p=bmp.getPixel(i,j);
                        int r=Color.red(p);
                        int g=Color.green(p);
                        int b=Color.blue(p);
                        int alpha=Color.alpha(p);

                        r=100+r;
                        g=100+g;
                        b=100+b;

                        operation.setPixel(i,j,Color.argb(alpha,r,g,b));
                    }
                }
                imgView.setImageBitmap(operation);
            }
        });

        btnDark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Dark Button Started!",Toast.LENGTH_LONG).show();
                operation.createBitmap(bmp.getWidth(),bmp.getHeight(),bmp.getConfig());

                for(int i=0;i<bmp.getWidth();i++){
                    for(int j=0;j<bmp.getHeight();j++){
                        int p=bmp.getPixel(i,j);
                        int r=Color.red(p);
                        int g=Color.green(p);
                        int b=Color.blue(p);
                        int alpha=Color.alpha(p);

                        r=r-50;
                        g=g-50;
                        b=b-50;

                        operation.setPixel(i,j,Color.argb(alpha,r,g,b));
                    }
                }
                imgView.setImageBitmap(operation);
            }
        });

        btnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Green Button Started!",Toast.LENGTH_LONG).show();

                operation.createBitmap(bmp.getWidth(),bmp.getHeight(),bmp.getConfig());

                for(int i=0;i<bmp.getWidth();i++){
                    for(int j=0;j<bmp.getHeight();j++){
                        int p=bmp.getPixel(i,j);
                        int r=Color.red(p);
                        int g=Color.green(p);
                        int b=Color.blue(p);
                        int alpha=Color.alpha(p);

                        r=r+150;
                        g=0;
                        b=0;

                        operation.setPixel(i,j,Color.argb(alpha,r,g,b));
                    }
                }
                imgView.setImageBitmap(operation);
            }
        });

        btnGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Green Buton Strated!",Toast.LENGTH_LONG).show();

                operation=Bitmap.createBitmap(bmp.getWidth(),bmp.getHeight(),bmp.getConfig());

                for(int i=0;i<bmp.getWidth();i++){
                    for(int j=0;j<bmp.getHeight();j++){
                        int p=bmp.getPixel(i,j);
                        int r=Color.red(p);
                        int g=Color.green(p);
                        int b=Color.blue(p);
                        int alpha=Color.alpha(p);

                        r=0;
                        g=g+150;
                        b=0;

                        operation.setPixel(i,j,Color.argb(alpha,r,g,b));
                    }
                }
                imgView.setImageBitmap(operation);
            }
        });

        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Blue Button Started!",Toast.LENGTH_LONG).show();

                operation=Bitmap.createBitmap(bmp.getWidth(),bmp.getHeight(),bmp.getConfig());

                for(int i=0;i<bmp.getWidth();i++){
                    for(int j=0;j<bmp.getHeight();j++){
                        int p=bmp.getPixel(i,j);
                        int r=Color.red(p);
                        int g=Color.green(p);
                        int b=Color.blue(p);
                        int alpha=Color.alpha(p);

                        r=0;
                        g=0;
                        b=b+150;

                        operation.setPixel(i,j,Color.argb(alpha,r,g,b));
                    }
                }
                imgView.setImageBitmap(operation);
            }
        });

    }
}
