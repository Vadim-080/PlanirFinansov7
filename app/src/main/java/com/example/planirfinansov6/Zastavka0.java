package com.example.planirfinansov6;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Zastavka0 extends AppCompatActivity {
    private TextView tv;
    private ImageView iv1, iv2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zastavka);

        tv = (TextView) findViewById(R.id.tv);
        iv1 = (ImageView) findViewById(R.id.iv1);
        iv2 = (ImageView) findViewById(R.id.iv2);
        Animation myanim1 = AnimationUtils.loadAnimation(this, R.anim.zastav_anim1);
        Animation myanim2 = AnimationUtils.loadAnimation(this, R.anim.zastav_anim2);
        iv1.startAnimation(myanim1);
        iv2.startAnimation(myanim2);
        final Intent i = new Intent(this, MainActivity.class);
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(15000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(i);
                    finish();
                }
            }
        };

        timer.start();
    }
}