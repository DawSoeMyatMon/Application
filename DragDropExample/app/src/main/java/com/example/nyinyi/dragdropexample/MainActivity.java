package com.example.nyinyi.dragdropexample;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Bundle;
import android.util.EventLogTags;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    private static String msg;
    private static TextView tvname;
    private static ImageView ivstar;
    private static ImageView imageView2;
    private static ImageView imageView3;
    private android.widget.RelativeLayout.LayoutParams layoutParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView2=(ImageView)findViewById(R.id.imageView2);
        imageView2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return false;
            }
        });

        imageView3=(ImageView)findViewById(R.id.imageView3);
        imageView3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return false;
            }
        });


        tvname=(TextView)findViewById(R.id.tv_name);
        tvname.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ClipData.Item item=new ClipData.Item((CharSequence)(view.getTag()));
                String[] mimetypes={ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData=new ClipData(view.getTag().toString(),mimetypes,item);
                View.DragShadowBuilder myShadow=new View.DragShadowBuilder(ivstar);

                view.startDrag(dragData,myShadow,null,0);
                return true;
            }
        });

        ivstar=(ImageView)findViewById(R.id.iv_star);
        ivstar.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ClipData.Item item=new ClipData.Item((CharSequence)(view.getTag()));
                String[] mimetypes={ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData=new ClipData(view.getTag().toString(),mimetypes,item);
                View.DragShadowBuilder myShadow=new View.DragShadowBuilder(ivstar);

                view.startDrag(dragData,myShadow,null,0);
                return true;
            }
        });

        tvname.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View view, DragEvent dragEvent) {
                int x_cord;
                int y_cord;
                switch (dragEvent.getAction()){
                    case DragEvent.ACTION_DRAG_STARTED:
                        layoutParams= (RelativeLayout.LayoutParams)view.getLayoutParams();
                        Log.d(msg,"Action is DragEvent.ACTION_DRAG_STARTED");
                        break;

                    case DragEvent.ACTION_DRAG_ENTERED:
                        Log.d(msg,"Action is DragEvent.ACTION_DRAG_ENTERED");
                        x_cord=(int)dragEvent.getX();
                        y_cord=(int)dragEvent.getY();
                        break;

                    case DragEvent.ACTION_DRAG_EXITED:
                        Log.d(msg,"Action is DragEvent.ACTION_DRAG_EXISTED");
                        x_cord=(int)dragEvent.getX();
                        y_cord=(int)dragEvent.getY();
                        layoutParams.leftMargin=x_cord;
                        layoutParams.topMargin=y_cord;
                        view.setLayoutParams(layoutParams);
                        break;

                    case DragEvent.ACTION_DRAG_LOCATION:
                        Log.d(msg,"Action is DragEvent.ACTION_DRAG_LOCATION");
                        x_cord=(int)dragEvent.getX();
                        y_cord=(int)dragEvent.getY();
                        break;

                    case DragEvent.ACTION_DRAG_ENDED:
                        Log.d(msg,"Action is DragEvent.ACTION_DRAG_ENDED");
                        break;

                    case DragEvent.ACTION_DROP:
                        Log.d(msg,"Action is DragEvent.ACTION_DROP");

                    default:break;

                }
                return true;
            }
        });

        ivstar.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View view, DragEvent dragEvent) {
                int x_cord;
                int y_cord;
                switch (dragEvent.getAction()){
                    case DragEvent.ACTION_DRAG_STARTED:
                        layoutParams= (RelativeLayout.LayoutParams)view.getLayoutParams();
                        Log.d(msg,"Action is DragEvent.ACTION_DRAG_STARTED");
                        break;

                    case DragEvent.ACTION_DRAG_ENTERED:
                        Log.d(msg,"Action is DragEvent.ACTION_DRAG_ENTERED");
                        x_cord=(int)dragEvent.getX();
                        y_cord=(int)dragEvent.getY();
                        break;

                    case DragEvent.ACTION_DRAG_EXITED:
                        Log.d(msg,"Action is DragEvent.ACTION_DRAG_EXISTED");
                        x_cord=(int)dragEvent.getX();
                        y_cord=(int)dragEvent.getY();
                        layoutParams.leftMargin=x_cord;
                        layoutParams.topMargin=y_cord;
                        view.setLayoutParams(layoutParams);
                        break;

                    case DragEvent.ACTION_DRAG_LOCATION:
                        Log.d(msg,"Action is DragEvent.ACTION_DRAG_LOCATION");
                        x_cord=(int)dragEvent.getX();
                        y_cord=(int)dragEvent.getY();
                        break;

                    case DragEvent.ACTION_DRAG_ENDED:
                        Log.d(msg,"Action is DragEvent.ACTION_DRAG_ENDED");
                        break;

                    case DragEvent.ACTION_DROP:
                        Log.d(msg,"Action is DragEvent.ACTION_DROP");

                    default:break;

                }
                return true;
            }
        });

        tvname.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    ClipData data=ClipData.newPlainText("","");
                    View.DragShadowBuilder shadowBuilder=new View.DragShadowBuilder(tvname);
                    tvname.startDrag(data,shadowBuilder,tvname,0);
                    tvname.setVisibility(View.VISIBLE);
                    return true;

                }
                else {
                    return false;
                }
            }
        });
        ivstar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    ClipData data=ClipData.newPlainText("","");
                    View.DragShadowBuilder shadowBuilder=new View.DragShadowBuilder(ivstar);
                    ivstar.startDrag(data,shadowBuilder,ivstar,0);
                    ivstar.setVisibility(View.INVISIBLE);
                    return true;

                }
                else {
                    return false;
                }
            }
        });
    }
}
