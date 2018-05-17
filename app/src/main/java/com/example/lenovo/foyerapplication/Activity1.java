package com.example.lenovo.foyerapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
public class Activity1 extends AppCompatActivity {
    private static int Splash_time_out = 3000;
    //new code
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }
    Thread splashTread;
    //!new code

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        new Handler().postDelayed(new Runnable(){
        @Override
            public void run(){
                Intent i = new Intent(Activity1.this,Activity2.class);
                startActivity(i);
                finish();
        }
        },Splash_time_out);
    }

}
