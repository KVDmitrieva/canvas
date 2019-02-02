package com.example.kated.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class MainActivity extends AppCompatActivity {
    OnDraw j;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window. FEATURE_NO_TITLE);
        j=new OnDraw(this);
        setContentView(j);
        new Thread() {
            @Override
            public void run() {
                super.run();
                while (true) {
                    j.update();
                }
            }
        }.start();
    }



    }

