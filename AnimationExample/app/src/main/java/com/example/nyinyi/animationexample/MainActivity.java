package com.example.nyinyi.animationexample;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void zoom(View view){
        ImageView imgImageView=(ImageView)findViewById(R.id.imageView);
        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.myanimation);
        imgImageView.startAnimation(animation);
    }

    public void clockwise(View view){
        ImageView imgImageView=(ImageView)findViewById(R.id.imageView);
        Animation animation1=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.clockwise);
        imgImageView.startAnimation(animation1);
    }

    public void fade(View view){
        ImageView imgImageView=(ImageView)findViewById(R.id.imageView);
        Animation animation2=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
        imgImageView.startAnimation(animation2);

    }

    public void blink(View view){
        ImageView imgImageView=(ImageView)findViewById(R.id.imageView);
        Animation animation3=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
        imgImageView.startAnimation(animation3);

    }

    public void move(View view){
        ImageView imgImageView=(ImageView)findViewById(R.id.imageView);
        Animation animation4=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
        imgImageView.startAnimation(animation4);
    }

    public void slide(View view){
        ImageView imgImageView=(ImageView)findViewById(R.id.imageView);
        Animation animation5=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide);
        imgImageView.startAnimation(animation5);
    }
}
