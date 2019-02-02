package com.example.kated.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;


public class OnDraw extends View {
    public OnDraw(Context context){
        super (context);

    }
    Ball ball = new Ball();
    Collect collect = new Collect();
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ball.onDraw(canvas);
        collect.onDraw(canvas);
        invalidate();
    }
    void collection(){

    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        ball.setVec(event);


        return super.onTouchEvent(event);
    }
    private int rand(){
        int rand=(int)(Math.random()*10);
        return rand;}
    public void update(){
        ball.move();
        float a = ball.x+ball.rad;
        float b = ball.x-ball.rad;
        float c = ball.y+ball.rad;
        float d = ball.y-ball.rad;
        float a1 = collect.vX+30;
        float b1 = collect.vX-30;
        float c1 = collect.vY+30;
        float d1 = collect.vY-30;
        if (b<=b1&&b1<=a&&d<=c1&&c1<=c||b<=b1&&b1<=a&&d<=d1&&d1<=c||b<=a1&&a1<=a&&d<=c1&&c1<=c||b<=a1&&a1<=a&&d<=d1&&d1<=c){
            ball.bigger();
           // collect.rad=0;

            collect.vX = 1000/rand();
           collect.vY = 1000/rand();
           collect.col=rand()/2;
        }
    }


    }



