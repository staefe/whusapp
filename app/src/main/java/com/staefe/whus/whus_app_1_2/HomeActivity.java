package com.staefe.whus.whus_app_1_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 4000;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);
        iv = findViewById(R.id.iv);
        Animation fadeAnim = AnimationUtils.loadAnimation(this,R.anim.trans1);
        iv.startAnimation(fadeAnim);
        final Intent i = new Intent(this,MainActivity.class);
        Thread timer = new Thread() {
            public void run () {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };

        timer.start();
    }
}
